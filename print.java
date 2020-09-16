
public class print {
  public static void main(String[] args) {

    String[] arr = new String[5];
    arr[0] = "__        __   _";
    arr[1] = "\\ \\      / /__| | ___ ___  _ __ ___   ___ ";
    arr[2] = " \\ \\ /\\ / / _ \\ |/ __/ _ \\|  _   _ \\ / _ \\";
    arr[3] = "  \\ V  V /  __/ | (_| (_) | | | | | |  __/";
    arr[4] = "   \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|";


    String[] arr2 = new String[6];
    arr2[0] = " __ _  _____ _____  ___  _       _  _      ___";
    arr2[1] = "|  __\\|_   _|_   _|/ __) A \\    /  M \\   |  _ \\";
    arr2[2] = "| |__)  | |   | | / / / / \\ \\  / /  \\ \\  | | ) |";
    arr2[3] = "|  __<  | |   | |(  |/ / A \\ \\/ /    \\ \\ |  _ /";
    arr2[4] = "| |__) _| |_  | | \\ \\_/     V  V         | |";
    arr2[5] = "|__ _/|_____| |_|  \\___)                 |_| ";

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      System.out.println(arr2[i]);
    }
  }
}
