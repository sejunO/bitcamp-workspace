import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    try(ServerSocket ss = new ServerSocket(8888)) {
      System.out.println("클라이언트 기다리는 중 ");
      try(Socket socket = ss.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {
        System.out.println("연결되었습니다.");
        while (true) {
          getRequest(in, out);
        }

      }

    } catch (Exception e) {

    }
  }

  static void getRequest(BufferedReader in, PrintWriter out) throws Exception{
    while (true) {
      String request = in.readLine();
      if (request.length() == 0) {
        break;
      }
      System.out.println(request);
      out.println(request);
    }
  }
}
