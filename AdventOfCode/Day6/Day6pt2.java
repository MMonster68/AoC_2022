import java.io.*;
import java.time.temporal.IsoFields;
import java.util.*;

public class Day6pt2 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        int n = 0;
        
        String next = sc.nextLine();

        System.out.println();
        sc.close();
        search(n, next);
    }
    public static void search(int n, String next) {
        String next1 = next.substring(0 + n, 14 + n);

        for (int j = 0; j < 13; j++) {
            if (next1.charAt(j) == next1.charAt(j + 1)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 12; j++) {
            if (next1.charAt(j) == next1.charAt(j + 2)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 11; j++) {
            if (next1.charAt(j) == next1.charAt(j + 3)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 10; j++) {
            if (next1.charAt(j) == next1.charAt(j + 4)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (next1.charAt(j) == next1.charAt(j + 5)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 8; j++) {
            if (next1.charAt(j) == next1.charAt(j + 6)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 7; j++) {
            if (next1.charAt(j) == next1.charAt(j + 7)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 6; j++) {
            if (next1.charAt(j) == next1.charAt(j + 8)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 5; j++) {
            if (next1.charAt(j) == next1.charAt(j + 9)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 4; j++) {
            if (next1.charAt(j) == next1.charAt(j + 10)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (next1.charAt(j) == next1.charAt(j + 11)) {
                n++;
                search(n, next);
                return;
            }
        }
        for (int j2 = 0; j2 < 2; j2++) {
            if (next1.charAt(j2) == next1.charAt(j2 + 12)) {
                n++;
                search(n, next);
                return;
            }
        }
        if (next1.charAt(0) != next1.charAt(13)) {
            System.out.println(n + 14);
            System.out.println(next1);
        } else {
            n++;
            search(n, next);
        }
    }
}