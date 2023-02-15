import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab6B {
    static boolean stillhasgiant = true;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        treenode2 tree[] = new treenode2[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new treenode2();
        }

        for (int i = 0; i < n-1; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            tree[a].child.add(tree[b]);
            tree[b].child.add(tree[a]);
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt()-1;
            tree[a].hasgiant = true;
        }
        tree[0].isvisited=true;
        tree[0].number=0;
        treenode2[] que = new treenode2[n];
        int[] count = new int[m];
        int max = 0;
        for (int j = 0; j < tree[0].child.size(); j++) {
            int front = 0;
            int rear = 0;
            int countpos = 0;
            tree[0].child.get(j).isvisited = true;
            tree[0].child.get(j).number = 1;
            que[rear++] = tree[0].child.get(j);
            while (front!=rear){
                treenode2 head = que[front++];
                for (int i = 0; i < head.child.size(); i++) {
                    if (head.child.get(i).isvisited==false){
                        que[rear++] = head.child.get(i);
                        head.child.get(i).isvisited=true;
                        head.child.get(i).number = head.number+1;
                        if (head.child.get(i).hasgiant==true){
                            count[countpos] = head.child.get(i).number;
                            countpos++;
                        }
                    }
                }
            }
            for (int i = 1; i < countpos; i++) {
                if (count[i]<=count[i-1]&&(count[i]!=1&&count[i-1]!=1)){
                    count[i] = count[i-1]+1;
                }
            }
            if (countpos!=0&&count[countpos-1]>max) max = count[countpos-1];

        }






        out.println(max);
        out.close();
    }

}
class treenode2 {
    boolean isvisited;
    boolean hasgiant;
    int number;
    //int path;
    //ArrayList<Integer> wight = new ArrayList<>();
    ArrayList<treenode2> child = new ArrayList<>();

}



