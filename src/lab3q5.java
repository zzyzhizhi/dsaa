import sun.misc.Unsafe;

import java.io.*;
import java.util.StringTokenizer;

public class lab3q5 {
    static int maxn = 80005;
    static int n,big,num,st=1,m;
    static Block b[] = new Block[605];
    static int pos[] = new int[maxn];
    static int tmpcnt[] = new int[305];
    static int tmpsum[] = new int[maxn];
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        n= in.nextInt();
        m = in.nextInt();
        big=300;
        num = n/big+1;
        for (int i = 0; i <=80000 ; i++) {
            pos[i]=i/big+1;
        }
        for (int i = 0; i < 605; i++) {
            b[i] = new Block();
        }
        for (int i = 1; i <=n ; i++) {
            int x;
            x=in.nextInt();
            b[pos[i]].a[b[pos[i]].sz]=x;
        }
        for (int i = 1; i <=num ; i++) {
            if (i>1) b[i].l=i-1;
            if (i<num) b[i].r=i+1;
            for (int j = 1; j <=b[i].sz ; j++) {
                b[i].cnt[pos[b[i].a[j]]]++;
                b[i].sum[j]+=b[i-1].sum[j];
            }
        }
        int ans=0,x,y,k;
        String s;
        for (int i = 1; i <=m ; i++) {
            s =in.next();
            if (s.equals("Q")){
                x=in.nextInt();
                y=in.nextInt();
                k=in.nextInt();
                x^=ans;
                y^=ans;
                k^=ans;
                out.println(ans=Kth(x,y,k));
            }
            if (s.equals("M")){
                x=in.nextInt();
                y=in.nextInt();
                x^=ans;
                y^=ans;
                update(x,y);
            }
            if (s.equals("I")){
                x=in.nextInt();
                y=in.nextInt();
                x^=ans;
                y^=ans;
                ins(x,y);
            }
        }
    }

    public static void ins(int x,int val){
        int now =st;
        while (b[now].sz<x){
            if (b[now].r!=0){
                x-=b[now].sz;
                now=b[now].r;
            }
            else break;
        }
        for (int i = b[now].sz; i >=x ; i--) {
            b[now].a[i+1]=b[now].a[i];
        }
        b[now].a[x]=val;
        b[now].sz++;
        int on=now;
        while (now!=0){
            b[now].cnt[pos[val]]++;
            b[now].sum[val]++;
            now = b[now].r;
        }
        if (b[on].sz>=big*2) split(on);
    }

    public static void update(int x,int y){
        int now =st;
        while (b[now].sz<x){
            x-=b[now].sz;
            now=b[now].r;
        }
        int fi = b[now].a[x];
        if (fi ==y) return;
        b[now].a[x] = y;
        while(now!=0){
            b[now].cnt[pos[fi]]--;
            b[now].cnt[pos[y]]++;
            b[now].sum[fi]--;
            b[now].sum[y]++;
            now = b[now].r;
        }
    }

    public static void split(int x){
        int newp =num++;
        b[newp].r=b[x].r;
        b[b[x].r].l=newp;
        b[x].r=newp;
        b[newp].l =x;
        b[newp].sz = b[x].sz/2;
        int del =b[x].sz-b[newp].sz;
        for (int i = 0; i < b[x].cnt.length; i++) {
            b[newp].cnt[i] = b[x].cnt[i];
        }
        for (int i = 0; i < b[x].sum.length; i++) {
            b[newp].sum[i] = b[x].sum[i];
        }
        for (int i = del+1; i <=b[x].sz ; i++) {
            b[newp].a[i-del]=b[x].a[i];
            b[x].cnt[pos[b[x].a[i]]]--;
            b[x].sum[b[x].a[i]]--;
            b[x].a[i]=0;
        }
        b[x].sz=del;
    }

    public static int Kth(int l,int r,int k){
        int now = st;
        int pl=0,pr=0;
        while (b[now].sz<l) {
            l-=b[now].sz;
            now = b[now].r;
            pl = now;
            now =st;
        }
        while (b[now].sz<r) {
            r-=b[now].sz;
            now = b[now].r;
            pr = now;
        }
        if (pl==pr){
            for (int i = l; i <=r ; i++) {
                tmpcnt[pos[b[pl].a[i]]]++;
                tmpsum[b[pl].a[i]]++;
            }
            now=1;
            while(tmpcnt[now]<k) {
                k-=tmpcnt[now];
                now++;
            }
            now = (now-1)*big;
            while (tmpsum[now]<k) {
                k-=tmpsum[now];
                now++;
            }
            for (int i = l; i <=r ; i++) {
                tmpcnt[pos[b[pl].a[i]]]--;
                tmpsum[b[pl].a[i]]--;
            }
            return now;
        }
        else {
            for (int i = l; i <=b[pl].sz ; i++) {
                tmpcnt[pos[b[pl].a[i]]]++;
                tmpsum[b[pl].a[i]]++;
            }
            for (int i = 1; i <=r ; i++) {
                tmpcnt[pos[b[pr].a[i]]]++;
                tmpsum[b[pr].a[i]]++;
            }
            now =1;
            while (tmpcnt[now]+b[b[pr].l].cnt[now]-b[pl].cnt[now]<k){
                k-=tmpcnt[now]+b[b[pr].l].cnt[now]-b[pl].cnt[now];
                now++;
            }
            now=(now-1)*big;
            while (tmpsum[now]+b[b[pr].l].sum[now]-b[pl].sum[now]<k){
                k-=tmpsum[now]+b[b[pr].l].sum[now]-b[pl].sum[now];
                now++;
            }
            for (int i = l; i <=b[pl].sz ; i++) {
                tmpcnt[pos[b[pl].a[i]]]--;
                tmpsum[b[pl].a[i]]--;
            }
            for (int i = 1; i <=r ; i++) {
                tmpcnt[pos[b[pr].a[i]]]--;
                tmpsum[b[pr].a[i]]--;
            }
            return now;
        }
    }
}
class Block{
    int l,r,sz;
    int cnt[]= new int[305];
    int sum[] = new int[80005];
    int a[] = new int[605];


}
