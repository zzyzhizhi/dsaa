import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab9A {
    static int size=0;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        graph3[] a = new graph3[n+2];
        graph3[] b = new graph3[n+2];
         for (int i = 0; i <=n+1 ; i++) {
            a[i] = new graph3();
            b[i] = new graph3();
        }
        for (int i = 1; i <=m ; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            a[u].child.add(a[v]);
            a[u].pathlen.add(w);
            //a[i].totalpath = 9*(long) Math.pow(10,18);
           // a[i].position = i;
        }
        for (int i = 1; i <=n ; i++) {
            a[i].totalpath = 9*(long) Math.pow(10,18);
        }
        a[1].isvisit=true;
        a[1].totalpath = 0;
        for (int i = 0; i <a[1].child.size() ; i++) {
            a[1].child.get(i).totalpath = a[1].pathlen.get(i);
            insert( a[1].child.get(i),b);
        }
        //DJ(a[1],a);
        for (int i = 2; i <=n ; i++) {
            long min = 9*(long) Math.pow(10,18);
            int pos = 1;
//            for (int j =2; j <a.length; j++) {
//                if (a[j].totalpath<min&& !a[j].isvisit){
//                    min = a[j].totalpath;
//                    pos = j;
//                }
//            }
            graph3 temp = new graph3();
            temp = delete(b);
            temp.isvisit = true;
            for (int j = 0; j < temp.child.size(); j++) {
                if (!temp.child.get(j).isvisit &&temp.child.get(j).totalpath > temp.totalpath + temp.pathlen.get(j))
                {
                    temp.child.get(j).totalpath =temp.totalpath + temp.pathlen.get(j);
                    insert( temp.child.get(j),b);
                }
            }

        }
        if (a[n].totalpath!=9*(long) Math.pow(10,18))
        out.println(a[n].totalpath);
        else out.println(-1);
        out.close();
    }
//    public static void DJ(graph3 temp,graph3[] a){
//        temp.isvisit = true;
//        long min = (long) Math.pow(10,18);
//        int position = 1;
//        if (a.length>=3){
//            for (int i =2; i <a.length; i++) {
//                if (a[i].totalpath<min&& !a[i].isvisit){
//                    min = a[i].totalpath;
//                    position = i;
//                }
//            }
//        }
//        if (position==1) return;
//        else {
//            for (int i = 0; i < a[position].child.size(); i++) {
//                if (!a[position].child.get(i).isvisit &&a[position].child.get(i).totalpath > a[position].totalpath + a[position].pathlen.get(i))
//                    a[position].child.get(i).totalpath = a[position].totalpath + a[position].pathlen.get(i);
//            }
//            DJ(a[position],a);
//        }
//
//    }
public static void insert(graph3 n, graph3[] heap) {
    size++;
    heap[size] = n;
    int cur = size;
    while (cur > 1 && ((heap[cur].totalpath < heap[cur / 2].totalpath)||(heap[cur].totalpath==heap[cur/2].totalpath&&heap[cur].position<heap[cur/2].position))) {
        graph3 temp = heap[cur];
        heap[cur] = heap[cur / 2];
        heap[cur / 2] = temp;
        cur = cur / 2;
    }
}

    public static graph3 delete(graph3[] heap) {
        graph3 result =new graph3();
        result = heap[1];

        boolean isswap = false;
        heap[1] = heap[size];
        size--;
        int cur = 1;
        while (2 * cur <= size) {
            isswap = false;
            if (2 * cur == size) {
                if (heap[cur].totalpath > heap[cur * 2].totalpath||(heap[cur].totalpath == heap[cur * 2].totalpath&&heap[cur].position > heap[cur * 2].position)) {
                    graph3 temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur * 2;
                    isswap = true;
                }
            } else {
                if (heap[2 * cur].totalpath <= heap[2 * cur + 1].totalpath && (heap[cur].totalpath > heap[2 * cur].totalpath||(heap[cur].totalpath == heap[cur * 2].totalpath&&heap[cur].position > heap[cur * 2].position))) {
                    graph3 temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur * 2;
                    isswap = true;
                }
                if (isswap == false && heap[2 * cur].totalpath > heap[2 * cur + 1].totalpath && (heap[cur].totalpath > heap[2 * cur + 1].totalpath||(heap[cur].totalpath == heap[cur * 2+1].totalpath&&heap[cur].position > heap[cur * 2+1].position))) {
                    graph3 temp = heap[cur];
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

class graph3{
    int position;
    boolean isvisit;
    ArrayList<graph3> child = new ArrayList<>();
    ArrayList<Long> pathlen = new ArrayList<>();
    long totalpath;
}






