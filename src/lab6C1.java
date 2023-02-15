import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab6C1 {
    static boolean legal = true;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n= in.nextInt();
        treenode5[] tree = new treenode5[n+1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new treenode5();
        }

        for (int i = 0; i < n-1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            tree[a].child.add(tree[b]);
            tree[b].child.add(tree[a]);
        }
        tree[1].isvisit=true;
        dfs(tree[1]);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (tree[a].depth>tree[b].depth){
                tree[a].b=Math.max(c,tree[a].b);
            }
            else tree[b].a =Math.max(c,tree[b].a);
        }
        int l=0;int r=n;
        int mid;
        while (l<=r){
            mid = l+(r-l)/2;
            legal=true;
            dfs1(tree[1],mid);
            if (legal){
                r = mid-1;
                initial(tree[1]);
            }
            if (!legal){
                l=mid+1;
                initial(tree[1]);
            }
        }
        if (l>n) out.println(-1);
        else out.println(l);
        out.close();
    }

    public static void initial(treenode5 a){
        a.max=0;
        a.min=0;
        a.sumofsonmax=0;
        a.sumofsonmin=0;
        for (int i = 0; i < a.child.size(); i++) {
            if (a.child.get(i).depth==a.depth+1){
                a.child.get(i).min=0;
                a.child.get(i).sumofsonmax=0;
                a.child.get(i).sumofsonmin=0;
                a.child.get(i).max=0;
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
class treenode5 {
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



