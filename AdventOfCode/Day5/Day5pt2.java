import java.io.*;
import java.util.*;

public class Day5pt2 {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(new File("data.dat"));
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        Stack<String> s3 = new Stack<>();
        Stack<String> s4 = new Stack<>();
        Stack<String> s5 = new Stack<>();
        Stack<String> s6 = new Stack<>();
        Stack<String> s7 = new Stack<>();
        Stack<String> s8 = new Stack<>();
        Stack<String> s9 = new Stack<>();
        Stack<String> m = new Stack<>();
        int n = 0;
        int num;
        int start;
        int finish;

        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            if (next.substring(0,3).equals(" 1 ")) {
                break;
            }
            for (int i = 0; i < 33; i++) {
                String n3 = next.substring(i, i+3);
                if (!n3.equals("   ")) {
                    switch(n) {
                        case 0: s1.add(0, n3);
                                break;
                        case 1: s2.add(0, n3);
                                break;
                        case 2: s3.add(0, n3);
                                break;
                        case 3: s4.add(0, n3);
                                break;
                        case 4: s5.add(0, n3);
                                break;
                        case 5: s6.add(0, n3);
                                break;
                        case 6: s7.add(0, n3);
                                break;
                        case 7: s8.add(0, n3);
                                break;
                        case 8: s9.add(0, n3);
                                break;
                    }
                }
                n++;
                i += 3;
            }
            n = 0;
        }
        sc.nextLine();
        while (sc.hasNextLine()) {
            String next1 = sc.nextLine();

            if (next1.length() == 18) {
                num = Integer.parseInt(next1.substring(5,6));
                start = Integer.parseInt(next1.substring(12,13));
                finish = Integer.parseInt(next1.substring(17));
            } else {
                num = Integer.parseInt(next1.substring(5,7));
                start = Integer.parseInt(next1.substring(13,14));
                finish = Integer.parseInt(next1.substring(18));
            }

            for (int i = 0; i < num; i++) {
                switch(start) {
                    case 1: m = s1;
                            break;
                    case 2: m = s2;
                            break;
                    case 3: m = s3;
                            break;
                    case 4: m = s4;
                            break;
                    case 5: m = s5;
                            break;
                    case 6: m = s6;
                            break;
                    case 7: m = s7;
                            break;
                    case 8: m = s8;
                            break;
                    case 9: m = s9;
                            break;
                }

                switch(finish) {
                    case 1: s1.add(s1.size() - i,m.pop());
                            break;
                    case 2: s2.add(s2.size() - i,m.pop());
                            break;
                    case 3: s3.add(s3.size() - i,m.pop());
                            break;
                    case 4: s4.add(s4.size() - i,m.pop());
                            break;
                    case 5: s5.add(s5.size() - i,m.pop());
                            break;
                    case 6: s6.add(s6.size() - i,m.pop());
                            break;
                    case 7: s7.add(s7.size() - i,m.pop());
                            break;
                    case 8: s8.add(s8.size() - i,m.pop());
                            break;
                    case 9: s9.add(s9.size() - i,m.pop());
                            break;
                }
                
                switch(start) {
                    case 1: s1 = m;
                            break;
                    case 2: s2 = m;
                            break;
                    case 3: s3 = m;
                            break;
                    case 4: s4 = m;
                            break;
                    case 5: s5 = m;
                            break;
                    case 6: s6 = m;
                            break;
                    case 7: s7 = m;
                            break;
                    case 8: s8 = m;
                            break;
                    case 9: s9 = m;
                            break;
                }
            }
        }
        System.out.println(s1.pop() + s2.pop() + s3.pop() + s4.pop() + s5.pop() + s6.pop() + s7.pop() + s8.pop() + s9.pop());
        sc.close();
    }
}