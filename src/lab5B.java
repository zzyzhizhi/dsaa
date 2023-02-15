import java.io.*;
import java.util.StringTokenizer;

public class lab5B {
    public static Node9[] a = new Node9[300010];
    public static Node9[] b = new Node9[300010];
    static int ans = 0;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        String A = in.next();
        String B = in.next();
        for (int i = 0; i < 300010; i++) {
            a[i] = new Node9();
            b[i] = new Node9();
        }
        a[0].len = -1;
        a[1].len = 0;
        a[0].fail = 0;
        a[1].fail = 0;
        b[0].len = -1;
        b[1].len = 0;
        b[0].fail = 0;
        b[1].fail = 0;
        build(A, a);
        build(B, b);
        dfs(1, 1, 0);
        dfs(0, 0, -1);
        if (ans>=1) out.println(ans);
        else out.println(-1);

        out.close();
    }

    public static void dfs(int x1, int x2, int len) {
        ans = Math.max(ans, len);
        for (int i = 0; i < 26; i++) {
            if (a[x1].next[i] > 0 && b[x2].next[i] > 0) {
                dfs(a[x1].next[i], b[x2].next[i], len + 2);
            }
        }
    }

    public static void build(String M, Node9[] s) {
        int present = 1;
        int count = 1;
        for (int i = 0; i < M.length(); i++) {
            int x = M.charAt(i) - 'a';
            /*if (i - s[present].len - 1 == -1) {
                count++;
                present = s[present].fail;
                int y = present;
                while (M.charAt(i - s[y].len - 1) != M.charAt(i)) {
                    y = s[y].fail;
                }
                s[y].next[x] = count;
                s[count].len = s[y].len+2;
                s[count].fail = 1;
                present = count;
                continue;
            }*/

            int y = present;
            while (i - s[y].len - 1 == -1 || M.charAt(i - s[y].len - 1) != M.charAt(i)) {
                y = s[y].fail;
            }
            present = y;
            if (s[present].next[x] == 0) {
                count++;
                s[present].next[x] = count;
                s[count].len = s[present].len + 2;
                y = s[present].fail;
                if (present == 0) {
                    s[count].fail = 1;
                } else {
                    while (M.charAt(i - s[y].len - 1) != M.charAt(i)) {
                        y = s[y].fail;
                    }
                    s[count].fail = s[y].next[x];
                }
            }
            present = s[present].next[x];
        }
    }


}


class Node9 {
    int len;
    int[] next = new int[26];
    int fail;
}


