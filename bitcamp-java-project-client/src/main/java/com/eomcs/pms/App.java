package com.eomcs.pms;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import com.eomcs.context.ApplicationContextListener;
import com.eomcs.pms.filter.AuthCommandFilter;
import com.eomcs.pms.filter.CommandFilterManager;
import com.eomcs.pms.filter.DefaultCommandFilter;
import com.eomcs.pms.filter.LogCommandFilter;
import com.eomcs.pms.handler.Request;
import com.eomcs.pms.listener.AppInitListener;
import com.eomcs.util.Prompt;

public class App {

  Map<String,Object> context = new Hashtable<>();
  List<ApplicationContextListener> listeners = new ArrayList<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationContextListenerOnServiceStarted() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationContextListenerOnServiceStopped() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }


  public static void main(String[] args) throws Exception {
    App app = new App();

    app.addApplicationContextListener(new AppInitListener());

    app.service();
  }

  public void service() throws Exception {

    notifyApplicationContextListenerOnServiceStarted();

    CommandFilterManager filterManager = new CommandFilterManager();
    filterManager.add(new LogCommandFilter(new File("command.log")));
    filterManager.add(new AuthCommandFilter());
    filterManager.add(new DefaultCommandFilter());

    filterManager.init(context);
    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    loop:
      while (true) {
        String inputStr = Prompt.inputString("명령> ");
        if (inputStr.length() == 0) {
          continue;
        }

        commandStack.push(inputStr);
        commandQueue.offer(inputStr);

        switch (inputStr) {
          case "history": printCommandHistory(commandStack.iterator()); break;
          case "history2": printCommandHistory(commandQueue.iterator()); break;
          case "quit":
          case "exit":
            System.out.println("안녕!");
            break loop;
          default:
            Request request = new Request(inputStr, context);
            filterManager.reset();
            filterManager.doFilter(request);

            //
        }
        System.out.println();
      }
    Prompt.close();
    filterManager.destroy();
    notifyApplicationContextListenerOnServiceStopped();
  }

  void printCommandHistory(Iterator<String> iterator) {
    try {
      int count = 0;
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
        count++;

        if ((count % 5) == 0 && Prompt.inputString(":").equalsIgnoreCase("q")) {
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("history 명령 처리 중 오류 발생!");
    }
  }
}
