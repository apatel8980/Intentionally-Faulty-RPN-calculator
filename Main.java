import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        SPRN sprn = new SPRN();

      //while loop to take in input
      //allows single line input & new line input

        while (true) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String i = sc.next();
                sprn.evaluateInput(i);
            }
        }
    }
}
