import java.io.*;
import java.util.*;

public class Attempt1 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        int n = 0;
        ArrayList<String> input = new ArrayList<String>();
        
        String next = sc.nextLine();
        search(next, sc, n, input);
        
        sc.close();
    }
    public static void search(String next, Scanner sc, int n, ArrayList<String> input) {
        while (sc.hasNextLine()) {
            next = sc.nextLine();
            if (next.substring(0, 1).equals("$")) {
                if (next.substring(2, 4).equals("ls")) {

                    input.add("->");

                } else if (next.substring(2, 4).equals("cd")) {
                    if (next.substring(5, 6).equals(".")) {

                        input.add("<-");

                    } else {

                        input.add(next.substring(5, next.length()));

                    }
                }
            } else if (next.substring(0, 3).equals("dir")) {
                
                input.add(next.substring(4, next.length()));
            } else {

                input.add(String.valueOf(drawDigitsFromString(next)));

            }
        }
        input.remove(0);
        // System.out.println(input);
        process(input, 0);
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
    public static void process(ArrayList<String> input, int i) {
        for ( ; i < input.size()/2; ++i) {
            //size is too big to process all data, make it smaller or break it up
            String value = input.get(i);
            if (!drawDigitsFromString(value).equals("")) {
                for (int j = 1; j < input.size() - i; j++) {
                    String value1 = input.get(i + j);
                    if (!drawDigitsFromString(value1).equals("")) {
                        input.set(i, String.valueOf(Integer.parseInt(input.get(i)) + Integer.parseInt(input.get(i + j))));
                        input.remove(i + j);
                        process(input, i-1);
                        return;
                    } else if (input.get(i + j).equals("->") || input.get(i + j).equals("<-")) {
                        process(input, ++i);
                        return;
                    } else {
                        continue;
                    }
                }
            }
        }
        // System.out.println(input);
        process2(input, 524);
        return;
    }
    public static void process2(ArrayList<String> input, int j) {
        for ( ; j < input.size(); j++) {
            String value = input.get(j);
            if (!drawDigitsFromString(value).equals("")) {
                for (int j2 = 1; j2 < input.size() - j; j2++) {
                    String value1 = input.get(j + j2);
                    if (!drawDigitsFromString(value1).equals("")) {
                        input.set(j, String.valueOf(Integer.parseInt(input.get(j)) + Integer.parseInt(input.get(j + j2))));
                        input.remove(j + j2);
                        process2(input, j-1);
                        return;
                    } else if (input.get(j + j2).equals("->") || input.get(j + j2).equals("<-")) {
                        process2(input, ++j);
                        return;
                    } else {
                        continue;
                    }
                }
            }
        }
        // System.out.println(input);
        remove(input, 0);
    }
    public static void remove(ArrayList<String> input, int i) {
        for ( ; i < input.size(); i++) {
            String value = input.get(i);
            if (!drawDigitsFromString(value).equals("")) {
                if (Integer.parseInt(drawDigitsFromString(value)) > 100000) {
                    input.set(i, "!");
                    for (int j = 1; j < i; j++) {
                        if (input.get(i - j).equals("->")) {
                            String bad = input.get(i - j - 1);
                            for (int k = 0; k < input.size(); k++) {
                                if (input.get(k).equals(bad)) {
                                    input.set(k, "!");
                                }
                            }
                            remove(input, 0);
                                    return;
                        }
                    }
                }
            }
        }
        System.out.println(input);
        remove1(input);
    }
    public static void remove1(ArrayList<String> input) {
        for (int j = 0; j < input.size(); j++) {
            if (input.get(j).equals("!")) {
                for (int i = j; i > 0; i--) {
                    if (i != 0) {
                        if (input.get(i).equals("->")) {
                            input.set(i, "|");
                            String bad = input.get(i - 1);
                            for (int k = 0; k < input.size(); k++) {
                                if (input.get(k).equals(bad)) {
                                    input.set(k, "!");
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(input);
        nextStep(input, 0);
    }
    public static void nextStep(ArrayList<String> input, int i) {
        for ( ; i < input.size() - 1; i++) {
            int value1 = 0;
            if (!drawDigitsFromString(input.get(i)).equals("")) {
                if (i != input.size() - 1) {
                    if (input.get(i-1).equals("->")) {
                        if (drawDigitsFromString(input.get(i-2)).equals("") && !(input.get(i-2).equals("->") || input.get(i-2).equals("<-"))) {
                            for (int k = 0; k < input.size() - i; k++) {
                                if (i + k <= input.size() - 1) {
                                    if (!drawDigitsFromString(input.get(i + k)).equals("")) {
                                        value1 += Integer.parseInt(input.get(i + k));
                                    } else if (input.get(i + k).equals("<-") || input.get(i + k).equals("->")) {
                                        String value = input.get(i - 2);
                                        // System.out.println(value);
                                        input.set(i - 2, "-");
                                        input.set(i - 1, "-");
                                        for (int j = 0; j < input.size() - 1; j++) {
                                            if (input.get(j).equals(value)) {
                                                input.set(j, String.valueOf(value1));
                                            }
                                        }
                                        nextStep(input, ++i);
                                        return;
                                    } else {
                                        nextStep(input, ++i);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(input);
        remove2(input);
    }
    public static void remove2(ArrayList<String> input) {
        for (int j = 0; j < input.size(); j++) {
            if (input.get(j).equals("!")) {
                if (j != 0) {
                    if (input.get(j - 1).equals("->")) {
                        input.remove(j);
                        input.remove(j - 1);
                    } else {
                        input.remove(j);
                    }
                    remove2(input);
                    return;
                } else {
                    input.remove(j);
                }
            }
        }
        // System.out.println(input);
        nextStep2(input, 0);
    }
    public static void nextStep2(ArrayList<String> input, int i) {
        for ( ; i < input.size() - 1; i++) {
            int value1 = 0;
            if (!drawDigitsFromString(input.get(i)).equals("")) {
                if (i != input.size() - 1) {
                    if (input.get(i-1).equals("->")) {
                        if (drawDigitsFromString(input.get(i-2)).equals("") && !(input.get(i-2).equals("->") || input.get(i-2).equals("<-"))) {
                            for (int k = 0; k < input.size() - i; k++) {
                                if (i + k <= input.size() - 1) {
                                    if (!drawDigitsFromString(input.get(i + k)).equals("")) {
                                        value1 += Integer.parseInt(input.get(i + k));
                                    } else if (input.get(i + k).equals("<-") || input.get(i + k).equals("->")) {
                                        String value = input.get(i - 2);
                                        // System.out.println(value);
                                        input.set(i - 2, "-");
                                        input.set(i - 1, "-");
                                        for (int j = 0; j < input.size() - 1; j++) {
                                            if (input.get(j).equals(value)) {
                                                input.set(j, String.valueOf(value1));
                                            }
                                        }
                                        nextStep2(input, ++i);
                                        return;
                                    } else {
                                        nextStep2(input, ++i);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // System.out.println(input);
        finalPrint(input);
    }
    public static void finalPrint(ArrayList<String> input) {
        int total = 0;
        for (int i = 0; i < input.size(); i++) {
            if (!drawDigitsFromString(input.get(i)).equals("")) {
                total += Integer.parseInt(drawDigitsFromString(input.get(i)));
            }
        }
        System.out.println(total);
    }
}