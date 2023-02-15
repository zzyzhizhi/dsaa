import java.io.*;
import java.util.StringTokenizer;

public class lab8q1 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[][] a = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x][y] = 1;
            a[y][x] = 1;
        }
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (a[x][y]==1) out.println("Yes");
            else out.println("No");
        }
        out.close();
    }
}


