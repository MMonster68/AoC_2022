import java.util.*;
import java.io.*;

public class Day7pt2 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> m = new HashMap<>();

        Scanner sc = new Scanner(new File("data.dat"));

        process("", sc, "", m);


        sc.close();
    }
    public static void process(String next, Scanner sc, String currentDir, Map<String, Integer> m) {
        while (sc.hasNextLine()) {
            next = sc.nextLine();
            String[] commands = next.split(" ");
            if (commands[0].equals("$")) {
                if (commands[1].equals("cd")) {
                    currentDir = currentDirectory(currentDir, commands[2]);
                }
            } else if (!commands[0].equals("dir")) {
                m = mapper(currentDir, commands[0], m);
            }
        }
        System.out.println(m);
        Integer[] allInts = m.values().toArray(new Integer[m.size() - 1]);
        ArrayList<Integer> size = new ArrayList<>();
        for (int i = 0; i < allInts.length; i++) {
            if (allInts[i] > 6876531) {
                size.add(allInts[i]);
            }
        }
        while (size.size() != 1) {
            for (int i = 1; i < size.size(); i++) {
                if (size.get(0) < size.get(i)) {
                    size.remove(i);
                } else {
                    size.remove(0);
                }
            }
        }
        System.out.println(size);
    }
    public static String currentDirectory(String currentDir, String newDir) {
        if (newDir.equals("..")) {
            String output = currentDir.substring(0, currentDir.lastIndexOf("!"));
            return output;
        } else {
            if (!currentDir.equals("")) {
                String output = currentDir + "!" + newDir;
                return output;
            } else {
                String output = newDir;
                return output;
            }
        }
    }
    public static Map<String, Integer> mapper(String currentDir, String input, Map<String, Integer> m) {
        String[] dir = currentDir.split("!");
        String prevString = "";
        for (int i = 0; i < dir.length; i++) {
            if (i != 0) {
                prevString = prevString + "!" + dir[i];
            } else {
                prevString = dir[0];
            }
            if (m.containsKey(prevString)) {
                m.put(prevString, m.get(prevString) + Integer.parseInt(input));
            } else {
                m.put(prevString, Integer.parseInt(input));
            }
        }
        return m;
    }
    public static String drawDigitsFromString(String strValue){
        String str = strValue.trim();
        String digits="";
        for (int i = 0; i < str.length(); i++) {
            char chrs = str.charAt(i);              
            if (Character.isDigit(chrs))
                digits = digits+chrs;
        }
        return digits;
    }
}