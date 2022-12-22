import java.io.*;
import java.util.*;

public class Day3pt2 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        int score = 0;
        String rep = "";

        String[] ans = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        while (sc.hasNextLine()) {
            String next1 = sc.nextLine();
            String next2 = sc.nextLine();
            String next3 = sc.nextLine();
            int len1 = next1.length();
            int len2 = next2.length();
            int len3 = next3.length();

            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    for (int j2 = 0; j2 < len3; j2++) {
                        if (next1.substring(i, i+1).equals(next2.substring(j, j+1)) && next1.substring(i, i+1).equals(next3.substring(j2, j2+1))) {
                            rep = next1.substring(i, i+1);
                        }
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