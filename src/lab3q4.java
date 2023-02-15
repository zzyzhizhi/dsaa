import java.io.*;
import java.util.*;

public class lab3q4 {
    static int n,m,q;
    static node a[] = new node[1200*1200];
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
     n= in.nextInt();
     m = in.nextInt();
     q = in.nextInt();

        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                a[change(i,j)]= new node();
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                a[change(i,j)].val = in.nextInt();
            }
        }
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                a[change(i,j)].r= change(i,j+1);
                a[change(i,j)].d= change(i+1,j);
            }
        }

        while (q>0) {
            q--;
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            int h=in.nextInt();
            int w=in.nextInt();
            trans(x1,y1,x2,y2,h,w);
        }

        int t=0;
        for (int i = 1; i <=n ; i++) {
            t = a[t].d;
            int p=t;
            for (int j = 1; j <=m ; j++) {
                p = a[p].r;
                out.print(a[p].val+" ");
            }
            out.println("");
        }
        out.close();
}


    public static void trans(int x1,int y1,int x2,int y2,int h,int w){
        int t1=0;
        int t2=0;
        for (int i = 1; i < x1; i++) {
            t1 = a[t1].d;
        }
        for (int i = 1; i < y1; i++) {
            t1 = a[t1].r;
        }
        for (int i = 1; i < x2; i++) {
            t2 = a[t2].d;
        }
        for (int i = 1; i < y2; i++) {
            t2 = a[t2].r;
        }
        int p1=t1;
        int p2=t2;
        for (int i = 1; i <=w ; i++) {
            p1=a[p1].r; p2=a[p2].r;
            int mid = 0;
            mid = a[p1].d;
            a[p1].d = a[p2].d;
            a[p2].d=mid;
        }
        for (int i = 1; i <=h ; i++) {
            p1=a[p1].d; p2=a[p2].d;
            int mid = 0;
            mid = a[p1].r;
            a[p1].r = a[p2].r;
            a[p2].r=mid;
        }
        p1=t1;p2=t2;
        for (int i = 1; i <=h ; i++) {
            p1=a[p1].d; p2=a[p2].d;
            int mid = 0;
            mid = a[p1].r;
            a[p1].r = a[p2].r;
            a[p2].r=mid;
        }
        for (int i = 1; i <=w ; i++) {
            p1=a[p1].r; p2=a[p2].r;
            int mid = 0;
            mid = a[p1].d;
            a[p1].d = a[p2].d;
            a[p2].d=mid;
        }
        return;
    }



    public static int change(int x, int y){
        return x*(m+1)+y;
    }
}
class node{
    int val;
    int r;
    int d;

    public node() {
    }
}