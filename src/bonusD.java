import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class bonusD {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            String s = in.next();
            Stack<Integer> a = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='{') a.push(1);
                if (s.charAt(j)=='}') {
                    if (a.empty()||a.peek()!=1) a.push(2);
                    else a.pop();
                }
                if (s.charAt(j)=='(') a.push(3);
                if (s.charAt(j)==')') {
                    if (a.empty()||a.peek()!=3) a.push(4);
                    else a.pop();
                }
                if (s.charAt(j)=='[') a.push(5);
                if (s.charAt(j)==']') {
                    if (a.empty()||a.peek()!=5) a.push(6);
                    else a.pop();
                }
            }
            if (a.empty()) out.println("YES");
            else out.println("NO");

        }
        out.close();
    }
}


