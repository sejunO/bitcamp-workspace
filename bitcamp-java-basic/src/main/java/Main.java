import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.nextLine().trim();

    if (a.isEmpty()) {
      System.out.println(0);
    }else {
      String[] b = a.split(" ");
      System.out.println(b.length);
      sc.close();
    }
  }
}
