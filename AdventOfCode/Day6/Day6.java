import java.io.*;
import java.time.temporal.IsoFields;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        int n = 0;
        
        String next = sc.nextLine();

        System.out.println();
        sc.close();
        search(n, next);
    }
    public static void search(int n, String next) {
        String next1 = next.substring(0 + n, 4 + n);
        // System.out.println(next1.charAt(0) != next1.charAt(3));
        for (int j = 0; j < 3; j++) {
            if (next1.charAt(j) == next1.charAt(j + 1)) {
                System.out.println("1");
                n++;
                search(n, next);
                return;
            }
        }
        for (int j2 = 0; j2 < 2; j2++) {
            if (next1.charAt(j2) == next1.charAt(j2 + 2)) {
                System.out.println(2);
                n++;
                search(n, next);
                return;
            }
        }
        if (next1.charAt(0) != next1.charAt(3)) {
            System.out.println(3);
            System.out.println(n + 4);
            System.out.println(next1);
        } else {
            n++;
            search(n, next);
        }
    }
}