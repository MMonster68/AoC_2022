import java.io.*;
import java.util.*;

public class Day4pt2 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        int score = 0;

        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            String[] h = next.split(",");
            String h1 = h[0];
            String h2 = h[1];
            String[] p1 = h1.split("-");
            String[] p2 = h2.split("-");            
            int min1 = Integer.parseInt(p1[0]);
            int max1 = Integer.parseInt(p1[1]);
            int min2 = Integer.parseInt(p2[0]);
            int max2 = Integer.parseInt(p2[1]);

            if (min1 <= min2 && max1 >= min2) {
                score++;
            } else if (min1 <= max2 && max1 >= max2) {
                score++;
            } else if (min2 <= min1 && max2 >= min1) {
                score++;
            } else if (min2 <= max1 && max2 >= max1) {
                score++;
            }
        }
    System.out.println(score);
    sc.close();
    }
}