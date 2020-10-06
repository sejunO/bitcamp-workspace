import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    try (ServerSocket ss = new ServerSocket(8888)) {
      try (Socket socket = ss.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          BufferedWriter out =
              new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
        out.write("asdf\n");
        out.write("asdf");
        out.write("asdf");
      }
    } catch (Exception e) {

    }
  }
}
