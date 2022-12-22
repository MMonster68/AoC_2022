import java.io.*;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        int max = 0;
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int num = 0;

        while (sc.hasNextLine()) {
            String next = sc.nextLine();

            if (!next.equals("")) {
                num = Integer.parseInt(next);
                max += num;
            } else {
                if (max > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = max;
                } else if (max > max2) {
                    max3 = max2;
                    max2 = max;
                } else if (max > max3) {
                    max3 = max;
                }
                max = 0;
            }
        }

        System.out.println(max1 + max2 + max3);
        sc.close();
    }
}