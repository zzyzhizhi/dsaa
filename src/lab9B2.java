import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class lab9B2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        long totallen = 0;
        long result = 0;
        int[] pre = new int[n+1];
        edge[] a = new edge[m];
        for (int i = 0; i < m; i++) {
            a[i] = new edge();
        }
        for (int i = 0; i <m ; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            a[i].x = u;
            a[i].y = v;
            a[i].length = w;
            totallen+=w;
            if (w<0) result+=w;
        }
        for (int i = 1; i <=n ; i++) {
            pre[i] = i;
        }
        Arrays.sort(a ,new Comparator<edge>() {
            @Override
            public int compare(edge o1, edge o2) {
                if (o1.length<o2.length) return -1;
                else return 1;
            }
        });
        int cou=1;
        for (int i = 0; i <m ; i++) {
            if (find(a[i].x,pre)==find(a[i].y,pre)) continue;
            else {
                if (a[i].length>0) result+=a[i].length;
                join(a[i].x,a[i].y,pre);
                cou++;
            }
        }
//        if (cou < n) out.println("orz");
//        else out.println(result);
        out.println(totallen-result);
        out.close();
    }
    public static int find(int x , int[] pre){
        if (pre[x] == x) return x;
        return pre[x] = find(pre[x],pre);
    }
    public static void join(int x,int y,int[] pre){
         x = find(x,pre);
        y = find(y,pre);
        pre[y] = x;
    }

}

class edge{
    int x;
    int y;
    long length;
}


