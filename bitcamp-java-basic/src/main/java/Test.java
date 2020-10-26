import java.util.ArrayList;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    List arr = new ArrayList();
    arr.add(3);
    arr.add(4);
    arr.add(3);
    arr.add(3);
    arr.add(3);
    arr.add(3);
    int b = (int)(Math.random()* arr.size());
    int index = (int) Math.random() * arr.size();
    System.out.println(index);
    System.out.println(b);
  }
}
