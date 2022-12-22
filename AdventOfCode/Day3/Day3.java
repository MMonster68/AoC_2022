import java.io.*;
import java.util.*;

public class Day3 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        int score = 0;
        String rep = "";

        String[] ans = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            int len = next.length();
            int len2 = len / 2;
            String h1 = next.substring(0, len2);
            String h2 = next.substring(len2);

            for (int i = 0; i < len2; i++) {
                for (int j = 0; j < len2; j++) {
                    if (h1.substring(i, i+1).equals(h2.substring(j, j+1))) {
                        rep = h1.substring(i, i+1);
                    }
                }
            }


            for (int i = 0; i < 52; i++) {
                if (ans[i].equals(rep)) {
                    score += (i+1);
                }
            }
        }
    System.out.println(score);
    sc.close();
    }
}