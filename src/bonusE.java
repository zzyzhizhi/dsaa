import java.io.*;
import java.util.StringTokenizer;

public class bonusE {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String a = in.next();
            int len = a.length();
            char[] s = new char[len];
            char[] s1 = new char[len];
            int[] next = new int[len];
            int[] next1 = new int[len];
            for (int j = 0; j < len; j++) {
                s[j] = a.charAt(j);
                s1[len-1-j] = s[j];
            }
            int j = 0;
            for (int k = 1; k < len; k++) {
                while (j>0&&s[j]!=s[k])
                    j = next[j-1];
                if (s[j]==s[k]) j++;
                next[k] = j;
            }
            j = 0;
            for (int k = 1; k < len; k++) {
                while (j>0&&s1[j]!=s1[k])
                    j = next1[j-1];
                if (s1[j]==s1[k]) j++;
                next1[k] = j;
            }
            int re = next[len-1];
            int re1 = next1[len-1];
            int re2 = Math.max(re,re1);
            if (2*re2>=len) {
                int circle = len - re2;
                if (len%circle==0) out.println(0);
                else out.println(circle-len%circle);
            }
            else {
                int result = len-re2-re2%(len - re2);
                out.println(result);
            }


        }
        out.close();
    }
}




