package com.eomcs.pms.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.eomcs.context.ApplicationContextListener;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.google.gson.Gson;

public class DataHandlerListener implements ApplicationContextListener {
  // main(), saveBoards(), loadBoards() 가 공유하는 필드
  List<Board> boardList = new ArrayList<>();
  File boardFile = new File("./board.json"); // 게시글을 저장할 파일 정보

  // main(), saveMembers(), loadMembers() 가 공유하는 필드
  List<Member> memberList = new LinkedList<>();
  File memberFile = new File("./member.json"); // 회원을 저장할 파일 정보

  // main(), saveProjects(), loadProjects() 가 공유하는 필드
  List<Project> projectList = new LinkedList<>();
  File projectFile = new File("./project.json"); // 프로젝트를 저장할 파일 정보

  // main(), saveTasks(), loadTasks() 가 공유하는 필드
  List<Task> taskList = new ArrayList<>();
  File taskFile = new File("./task.json"); // 작업을 저장할 파일 정보

  @Override
  public void contextInitialized(Map<String, Object> context) {
    // 파일에서 데이터 로딩
    loadData(boardList, boardFile, Board[].class);
    context.put("boardList", boardList);
    loadData(memberList, memberFile, Member[].class);
    context.put("memberList", memberList);
    loadData(projectList, projectFile, Project[].class);
    context.put("projectList", projectList);
    loadData(taskList, taskFile, Task[].class);
    context.put("taskList", taskList);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    saveData(boardList, boardFile);
    saveData(memberList, memberFile);
    saveData(projectList, projectFile);
    saveData(taskList, taskFile);

  }


  private <T> void loadData(Collection<T> list, File file, Class<T[]> clazz) {
    BufferedReader in = null;

    try {
      in = new BufferedReader(new FileReader(file));

      list.addAll(Arrays.asList(new Gson().fromJson(in, clazz)));

      System.out.printf("총 %d 개의 %s데이터를 로딩했습니다.\n", list.size(), file.getName());


    } catch (Exception e) {

      System.out.println("게시글 파일 읽기 중 오류 발생! - " + e.getMessage());
    } finally {
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private <T> void saveData(Collection<T> list, File file) {
    BufferedWriter out = null;

    try {
      out = new BufferedWriter(new FileWriter(file));

      out.write(new Gson().toJson(list));

      out.flush();

      System.out.printf("총 %d 개의 게시글 데이터를 저장했습니다.\n", list.size());

    } catch (IOException e) {
      System.out.println("게시글 데이터의 파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }

}
