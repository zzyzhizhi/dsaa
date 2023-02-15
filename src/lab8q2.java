import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab8q2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        graph1[] a = new graph1[n+1];
        for (int i = 0; i <=n ; i++) {
            a[i] = new graph1();
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[y].directpath.add(a[x]);
        }
        for (int i = 1; i <=n ; i++) {
            a[i].key =i;
            a[i].key2 = i;
        }
        for (int i = n; i >=1 ; i--) {
            dfs(a[i]);
        }

        for (int i = 1; i <=n ; i++) {
            out.print(a[i].key+" ");
        }
        out.close();
    }
    public static void dfs(graph1 a){
        while (a.isvisit==false){
            a.isvisit=true;
            for (int i = 0; i < a.directpath.size(); i++) {
                if (a.directpath.get(i).isvisit==false){
                    //a.directpath.get(i).isvisit=true;
                    a.directpath.get(i).key = a.key;
                    dfs(a.directpath.get(i));
                }
            }
        }
    }

}
 class graph1{
    int key;
    int key2;
    boolean isvisit;
     ArrayList<graph1> directpath = new ArrayList<>();
}




