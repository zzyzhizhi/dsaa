import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*7 12
        1 2 23
        2 3 20
        3 4 15
        2 7 1
        3 7 4
        1 7 36
        4 7 9
        1 6 28
        6 7 25
        6 5 17
        5 7 16
        4 5 3*/
public class lab9B {
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
            totallen += w;
            if (w<0) result+=w;
        }
        for (int i = 1; i <=n ; i++) {
            a[i].totalpath = Long.MAX_VALUE;
        }
        a[1].isvisit =true;
        a[1].totalpath =0;
        a[1].ifinheap = true;
        for (int i = 0; i < a[1].child.size(); i++) {
            a[1].child.get(i).totalpath = a[1].pathlen.get(i);
            insert(a[1].child.get(i),b);
            a[1].child.get(i).ifinheap = true;
        }
        boolean isempty = false;
        for (int i = 2; i <=n ; i++) {
            graph4 temp = new graph4();
            temp.isvisit =true;
            if (size!=0)
            temp = delete(b);
            else {
                isempty = true;
                break;
            }
            if (temp.totalpath>0)
            result += temp.totalpath;
            temp.isvisit = true;
            for (int j = 0; j < temp.child.size(); j++) {
                if (!temp.child.get(j).isvisit&&temp.child.get(j).totalpath>temp.pathlen.get(j)){
                    temp.child.get(j).totalpath=temp.pathlen.get(j);
                    if (!temp.child.get(j).ifinheap)
                    {
                        temp.child.get(j).ifinheap = true;
                        insert(temp.child.get(j),b);
                    }
                    else check(temp.child.get(j),b);
                }
            }
        }
        if (isempty) out.println("orz");
        else
            out.println(result);
        //out.println(totallen-result);
        out.close();
    }

    public static void check(graph4 a,graph4[] heap) {
        int cur = a.position;
        while (cur > 1 && ((heap[cur].totalpath < heap[cur / 2].totalpath))) {
            changepos(heap[cur],heap[cur/2]);
            graph4 temp = heap[cur];
            heap[cur] = heap[cur / 2];
            heap[cur / 2] = temp;
            cur = cur / 2;
        }
    }

    public static void insert(graph4 n, graph4[] heap) {
        size++;
        n.position = size;
        heap[size] = n;
        int cur = size;
        while (cur > 1 && ((heap[cur].totalpath < heap[cur / 2].totalpath))) {
            changepos(heap[cur],heap[cur/2]);
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
        heap[size].position = 1;
        size--;
        int cur = 1;
        while (2 * cur <= size) {
            isswap = false;
            if (2 * cur == size) {
                if (heap[cur].totalpath > heap[cur * 2].totalpath) {
                    changepos(heap[cur],heap[cur*2]);
                    graph4 temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur * 2;
                    isswap = true;
                }
            } else {
                if (heap[2 * cur].totalpath <= heap[2 * cur + 1].totalpath && (heap[cur].totalpath > heap[2 * cur].totalpath)) {
                    changepos(heap[cur],heap[cur*2]);
                    graph4 temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur * 2;
                    isswap = true;
                }
                if (isswap == false && heap[2 * cur].totalpath > heap[2 * cur + 1].totalpath && (heap[cur].totalpath > heap[2 * cur + 1].totalpath)) {
                    changepos(heap[cur],heap[cur*2+1]);
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

    public static void changepos(graph4 a,graph4 b){
        int t = b.position;
        b.position = a.position;
        a.position = t;
    }

}

class graph4{
    int position;
    boolean isvisit;
    boolean ifinheap;
    ArrayList<graph4> child = new ArrayList<>();
    ArrayList<Long> pathlen = new ArrayList<>();
    long totalpath;
}

