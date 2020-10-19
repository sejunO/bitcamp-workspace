import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner sc = new Scanner(System.in)) {
      while (true) {
        System.out.printf("명령 > ");
        String str = sc.nextLine();
        out.println(str);
        out.println();
        out.flush();

      }

    } catch (Exception e) {

    }
  }
}
