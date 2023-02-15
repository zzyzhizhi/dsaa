import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bonusG {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] c = new int[n+1];
            Gnode[] a = new Gnode[n+1];
            int pos = 0;
            for (int j = 0; j <=n; j++) {
                a[j] = new Gnode();
            }

            for (int j = 1; j <= n; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                a[j].leftchild = a[x];
                a[j].rightchild = a[y];
                c[x]++;
                c[y]++;
            }
            for (int j = 1; j <=n ; j++) {
                if (c[j]==0) pos = j;
            }
            int count = 0;
                boolean iscomplete = true;
                Queue<Gnode> temp = new LinkedList<>();
                boolean begin = false;
                temp.add(a[pos]);
                while (!temp.isEmpty()){
                    Gnode m = temp.remove();
                    if (begin){
                        if (m.leftchild!=a[0]||m.rightchild!=a[0]){
                            iscomplete = false;
                            count++;
                            break;
                        }
                    }
                    if (m.rightchild!=a[0]&&m.leftchild!=a[0]&&begin==false){
                        temp.add(m.leftchild);
                        temp.add(m.rightchild);
                    }
                    if (m.leftchild==a[0]&&m.rightchild!=a[0]){
                        count++;
                        iscomplete = false;
                        break;
                    }
                    if ((m.leftchild!=a[0]&&m.rightchild==a[0]&&begin==false)){
                        temp.add(m.leftchild);
                        begin = true;
                    }
                    if (m.leftchild==a[0]&&m.rightchild==a[0]&&begin==false){
                        begin = true;
                    }

                }


            if (iscomplete) out.println("Yes");
            else out.println("No");
        }
        out.close();
    }
}

class Gnode{

    Gnode leftchild;
    Gnode rightchild;
}


