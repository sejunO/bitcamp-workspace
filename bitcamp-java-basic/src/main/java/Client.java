import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      intro(in);

    } catch (Exception e) {

    }
  }

  static void intro(BufferedReader in) throws Exception {
    while (true) {
      String str = in.readLine();
      if (str.equals("")) {
        break;
      }
      System.out.println(str);
    }

  }
}
