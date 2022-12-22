import java.util.*;
import java.io.*;

public class Day8 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> m = new HashMap<>();

        Scanner sc = new Scanner(new File("data.dat"));
        int num = 99;
        String[] rows = new String[num];

        System.out.println(process(sc, m, rows, num));

        sc.close();
    }
    public static Integer process(Scanner sc, Map<Integer, Integer> m, String[] rows, int num) {
        int x = 0;
        int[] columnReverseMaxHeight = new int[num];
        int[] columnMaxHeight = new int[num];

        for (int i = 0; i < num * num; i++) {
            m.put(i, 0);
        }
        while (sc.hasNextLine()) {
            for (int i = 0; i < num; i++) {
                rows[i] = sc.nextLine();
            }
        }
        for (int i = 0; i < num; i++) {

            String[] columns;
            String[] columnsReverse;

            columns = rows[i].split("|");
            columnsReverse = rows[num - 1 - i].split("|");
            int rowMaxHeight = 0;
            int leftRowMaxHeight = 0;

            for (int j = 0; j < num; j++) {
                if (columnMaxHeight[j] < Integer.parseInt(columns[j])) {
                    columnMaxHeight[j] = Integer.parseInt(columns[j]);
                    m.replace(x, 1);
                } else if (x < num) {
                    m.replace(x, 1);
                }
                if (rowMaxHeight < Integer.parseInt(columns[j])) {
                    rowMaxHeight = Integer.parseInt(columns[j]);
                    m.replace(x, 1);
                } else if (x % num == 0) {
                    m.replace(x, 1);
                }
                if (leftRowMaxHeight < Integer.parseInt(columns[num - 1 - j])) {
                    leftRowMaxHeight = Integer.parseInt(columns[num - 1 - j]);
                    m.replace(x + num - 1 - (2 * j), 1);
                } else if (((x + num - 1 - (2 * j)) % num) == (num - 1)) {
                    m.replace(x + num - 1 - (2 * j), 1);
                }
                if (columnReverseMaxHeight[num - 1 - j] < Integer.parseInt(columnsReverse[num - 1 - j])) {
                    columnReverseMaxHeight[num - 1 - j] = Integer.parseInt(columnsReverse[num - 1 - j]);
                    m.replace((num * num) - 1 - x, 1);
                } else if (x < num) {
                    m.replace((num * num) - 1 - x, 1);
                }
                x++;
            }
        }
        Integer[] allInts = m.values().toArray(new Integer[m.size() - 1]);
        int total = 0;
        for (int i = 0; i < allInts.length; i++) {
            total += allInts[i];
        }
        return total;
    }
}