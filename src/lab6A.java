import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab6A {
    public static int count =0;
    public static int num;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
         num = in.nextInt();
         count = 0;
        treenode1[] tree = new treenode1[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new treenode1();
            tree[i].isvisited = false;
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int val = in.nextInt();
            tree[a].child.add(tree[b]);
            tree[a].wight.add(val);
            tree[b].child.add(tree[a]);
            tree[b].wight.add(val);
        }
        tree[0].isvisited = true;
        tree[0].path = 0;
        treenode1[] q = new treenode1[n];
        int front = 0;
        int rear = 0;
        q[rear++] = tree[0];

        while (front != rear) {
            treenode1 head = q[front++];
            if (head.child.size()==1){
                if (head.path==num) count++;
            }

           for (int i = 0; i < head.child.size(); i++) {
                if (head.child.get(i).isvisited ==false) {
                    q[rear++] = head.child.get(i);
                    head.child.get(i).path = head.path+head.wight.get(i);
                    head.child.get(i).isvisited = true;
                }
            }
        }
        dfs(tree[0]);
        out.println(count);
        out.close();
    }

    static void dfs(treenode1 temp) {
        if (temp.child.size()==1){
            if (temp.path==num) count++;
        }
        for (int i = 0; i < temp.child.size(); i++) {
            if (temp.child.get(i).isvisited ==false) {
                temp.child.get(i).path = temp.path+temp.wight.get(i);
                temp.isvisited = true;
                dfs(temp.child.get(i));
            }
        }
    }
}


class treenode1 {
    boolean isvisited;
    int path;
    ArrayList<Integer> wight = new ArrayList<>();
    ArrayList<treenode1> child = new ArrayList<>();

}


