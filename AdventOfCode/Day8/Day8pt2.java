import java.util.*;
import java.io.*;

public class Day8pt2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("data.dat"));
        int num = 99;
        String[][] input = new String[num][num];
        Integer[][] leftResults = new Integer[num][num];
        Integer[][] rightResults = new Integer[num][num];
        Integer[][] upResults = new Integer[num][num];
        Integer[][] downResults = new Integer[num][num];
        String[] rows = new String[num];

        System.out.println(process(sc, rows, num, input, leftResults, rightResults, upResults, downResults));

        sc.close();
    }
    public static Integer process(Scanner sc, String[] rows, int num, String[][] input, Integer[][] leftResults, Integer[][] rightResults, Integer[][] upResults, Integer[][] downResults) {
        while (sc.hasNextLine()) {
            for (int i = 0; i < num; i++) {
                String next = sc.nextLine();
                String[] newLine = next.split("|");
                for (int j = 0; j < num; j++) {
                    input[i][j] = newLine[j];
                }
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                leftResults[i][j] = 0;
                rightResults[i][j] = 0;
                upResults[i][j] = 0;
                downResults[i][j] = 0;
            }
        }
        for (int j = 0; j < num; j++) {
            for (int j2 = 0; j2 < num; j2++) {
                int a = 1;
                for (int k = j2 - 1; k >= 0; k--) {
                    if (Integer.parseInt(input[j][j2]) > Integer.parseInt(input[j][k])) {
                        leftResults[j][j2] += a;
                    } else {
                        a = 0;
                    }
                }
                if (a == 0) {
                    leftResults[j][j2] += 1;
                }
            }
        }
        for (int j = 0; j < num; j++) {
            for (int j2 = 0; j2 < num; j2++) {
                int a = 1;
                for (int k = j2 + 1; k < num; k++) {
                    if (Integer.parseInt(input[j][j2]) > Integer.parseInt(input[j][k])) {
                        rightResults[j][j2] += a;
                    } else {
                        a = 0;
                    }
                }
                if (a == 0) {
                    rightResults[j][j2] += 1;
                }
            }
        }
        for (int j = 0; j < num; j++) {
            for (int j2 = 0; j2 < num; j2++) {
                int a = 1;
                for (int k = j - 1; k >= 0; k--) {
                    if (Integer.parseInt(input[j][j2]) > Integer.parseInt(input[k][j2])) {
                        upResults[j][j2] += a;
                    } else {
                        a = 0;
                    }
                }
                if (a == 0) {
                    upResults[j][j2] += 1;
                }
            }
        }
        for (int j = 0; j < num; j++) {
            for (int j2 = 0; j2 < num; j2++) {
                int a = 1;
                for (int k = j + 1; k < num; k++) {
                    if (Integer.parseInt(input[j][j2]) > Integer.parseInt(input[k][j2])) {
                        downResults[j][j2] += a;
                    } else {
                        a = 0;
                    }
                }
                if (a == 0) {
                    downResults[j][j2] += 1;
                }
            }
        }
        System.out.println(downResults[3][2]);
        Integer[][] products = new Integer[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                products[i][j] = leftResults[i][j] * rightResults[i][j] * upResults[i][j] * downResults[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (products[i][j] > max) {
                    max = products[i][j];
                }
            }
        }
        return max;
    }
}