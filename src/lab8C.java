import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab8C {
    static int count = 0;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n =in.nextInt();
        int m = in.nextInt();
        graph2[] a = new graph2[n+1];
        for (int i = 0; i <=n ; i++) {
            a[i] = new graph2();
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y =in.nextInt();
            a[x].key ++;
            a[y].key ++;
            a[x].directpath.add(a[y]);
            a[y].directpath.add(a[x]);
        }
        boolean hasdelete = true;
        while (hasdelete){
            boolean ifout = false;
            for (int i = 1; i <=n ; i++) {
                if (a[i].key<=1&&a[i].isdelete==false){
                    ifout = true;
                    count++;
                    a[i].isdelete = true;
                    for (int j = 0; j < a[i].directpath.size(); j++) {
                        a[i].directpath.get(j).key--;
                    }
                }
            }
            if (ifout==false){
                hasdelete = false;
            }
        }
        if (count<n) out.println("Bad");
        else out.println("Good");
        out.close();
    }
}
class graph2{
    int key;
    boolean isvisit1;
    boolean isdelete;
    int[] father;
   ArrayList<graph2> directpath = new ArrayList<>();
}
