import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab6C {
    static boolean legal = true;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n= in.nextInt();
        treenode5[] tree = new treenode5[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new treenode5();
        }

        for (int i = 0; i < n-1; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            tree[a].child.add(tree[b]);
            tree[b].child.add(tree[a]);
        }
        tree[0].isvisit=true;
        dfs(tree[0]);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            int c = in.nextInt();
            if (tree[a].depth>tree[b].depth){
                tree[a].b=c;
            }
            else tree[b].a =c;
        }
        int l=0;int r=n-1;
        int mid=0;
        while (l<=r){
            mid = l+(r-l)/2;
            legal=true;
            dfs1(tree[0],mid);
            if (legal){
                r = mid-1;
                initial(tree[0]);
            }
            if (!legal){
                l=mid+1;
                initial(tree[0]);
            }
        }
        if (l+1>n) out.println(-1);
        if (r<0) out.println(0);
        if (r>=0&&l+1<=n) out.println(l+1);
        out.close();
    }

    public static void initial(treenode5 a){
        a.a=0;
        a.b=0;
        a.max=0;
        a.min=0;
        a.sumofsonmax=0;
        a.sumofsonmin=0;
        for (int i = 0; i < a.child.size(); i++) {
            if (a.child.get(i).depth==a.depth+1){
                a.child.get(i).b=0;
                a.child.get(i).a=0;
                a.child.get(i).min=0;
                a.child.get(i).max=0;
                a.child.get(i).sumofsonmax=0;
                a.child.get(i).sumofsonmin=0;
                initial(a.child.get(i));
            }
        }
    }

    public static void dfs(treenode5 a){//求深度
        for (int i = 0; i < a.child.size(); i++) {
            if (a.child.get(i).isvisit==false) {
                a.child.get(i).isvisit = true;
                a.child.get(i).depth = a.depth+1;
                dfs(a.child.get(i));
            }
        }
    }

    public static void dfs1(treenode5 a, int k){
        for (int i = 0; i < a.child.size(); i++){
            if (a.child.get(i).depth==a.depth+1){
                dfs1(a.child.get(i),k);
            }
        }
        for (int i = 0; i < a.child.size(); i++) {
            if (a.child.get(i).depth==a.depth+1){
                a.sumofsonmax+=a.child.get(i).max;
                a.sumofsonmin+=a.child.get(i).min;
            }
        }
        a.min=Math.max(a.b,a.sumofsonmin);
        a.max = Math.min(k-a.a,a.sumofsonmax+1);

        if (a.min>a.max) {
            legal=false;
        }
        if (a.depth==0){
            if (k<a.min||k>a.max){
                legal=false;
            }
        }
    }
}
class treenode4{
    boolean isvisit;
    int a;
    int b;
    int min;
    int max;
    int depth;
    int sumofsonmin;
    int sumofsonmax;
    ArrayList<treenode5> child = new ArrayList<>();
}


