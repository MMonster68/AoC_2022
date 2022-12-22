import java.io.*;
import java.util.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        int score = 0;

        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            String[] n1 = next.split(" ");

            if (n1[1].equals("X")) {
                score += 0;
                if (n1[0].equals("A")) {
                    score += 3;
                } else if (n1[0].equals("B")) {
                    score += 1;
                } else {
                    score += 2;
                }
            }

            if (n1[1].equals("Y")) {
                score += 3;
                if (n1[0].equals("A")) {
                    score += 1;
                } else if (n1[0].equals("B")) {
                    score += 2;
                } else {
                    score += 3;
                }
            }

            if (n1[1].equals("Z")) {
                score += 6;
                if (n1[0].equals("A")) {
                    score += 2;
                } else if (n1[0].equals("B")) {
                    score += 3;
                } else {
                    score += 1;
                }
            }
        }
    System.out.println(score);
    sc.close();
    }
}