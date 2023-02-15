import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab9B1 {
    static int size=0;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        long result =0 ;
        long totallen = 0;
        graph4[] a = new graph4[n+1];
        graph4[] b = new graph4[n+1];
        for (int i = 0; i <=n ; i++) {
            a[i] = new graph4();
        }
        for (int i = 0; i <=n ; i++) {
            b[i] = new graph4();
        }
        for (int i = 1; i <=m ; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            a[u].child.add(a[v]);
            a[v].child.add(a[u]);
            a[u].pathlen.add(w);
            a[v].pathlen.add(w);
            totallen +=w;
//            b[i].left = a[u];
//            b[i].right = a[v];
//            b[i].len = w;
        }
        for (int i = 1; i <=n ; i++) {
            a[i].totalpath = 9*(long) Math.pow(10,18);
        }
        a[1].isvisit =true;
        a[1].totalpath =0;
        for (int i = 0; i < a[1].child.size(); i++) {
            a[1].child.get(i).totalpath = a[1].pathlen.get(i);
            insert(a[1].child.get(i),b);
        }
        for (int i = 2; i <=n ; i++) {
            graph4 temp = new graph4();
            temp.isvisit =true;
            while (temp.isvisit){
                temp = delete(b);
            }

            temp.isvisit = true;
            for (int j = 0; j < temp.child.size(); j++) {
                if (!temp.child.get(j).isvisit&&temp.child.get(j).totalpath>temp.pathlen.get(j)){
                    temp.child.get(j).totalpath=temp.pathlen.get(j);
                    insert(temp.child.get(j),b);
                }
            }
        }
        for (int i = 1; i <=n ; i++) {
            result += a[i].totalpath;
        }
        out.println(totallen-result);
        out.close();
    }

    public static void insert(graph4 n, graph4[] heap) {
        size++;
        heap[size] = n;
        int cur = size;
        while (cur > 1 && ((heap[cur].totalpath < heap[cur / 2].totalpath)||(heap[cur].totalpath==heap[cur/2].totalpath&&heap[cur].position<heap[cur/2].position))) {
            graph4 temp = heap[cur];
            heap[cur] = heap[cur / 2];
            heap[cur / 2] = temp;
            cur = cur / 2;
        }
    }

    public static graph4 delete(graph4[] heap) {
        graph4 result =new graph4();
        result = heap[1];

        boolean isswap = false;
        heap[1] = heap[size];
        size--;
        int cur = 1;
        while (2 * cur < size) {
            isswap = false;
            if (2 * cur == size) {
                if (heap[cur].totalpath > heap[cur * 2].totalpath||(heap[cur].totalpath == heap[cur * 2].totalpath&&heap[cur].position > heap[cur * 2].position)) {
                    graph4 temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur * 2;
                    isswap = true;
                }
            } else {
                if (heap[2 * cur].totalpath <= heap[2 * cur + 1].totalpath && (heap[cur].totalpath > heap[2 * cur].totalpath||(heap[cur].totalpath == heap[cur * 2].totalpath&&heap[cur].position > heap[cur * 2].position))) {
                    graph4 temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur * 2;
                    isswap = true;
                }
                if (isswap == false && heap[2 * cur].totalpath > heap[2 * cur + 1].totalpath && (heap[cur].totalpath > heap[2 * cur + 1].totalpath||(heap[cur].totalpath == heap[cur * 2+1].totalpath&&heap[cur].position > heap[cur * 2+1].position))) {
                    graph4 temp = heap[cur];
                    heap[cur] = heap[cur * 2 + 1];
                    heap[cur * 2 + 1] = temp;
                    cur = cur * 2 + 1;
                    isswap = true;
                }
            }
            if (isswap == false) break;
        }
        return result;
    }

}

class graph5{
    int position;
    boolean isvisit;
    ArrayList<graph5> child = new ArrayList<>();
    ArrayList<Long> pathlen = new ArrayList<>();
    long totalpath;
}

class bian{
    long len;
    graph4 left;
    graph4 right;
}



