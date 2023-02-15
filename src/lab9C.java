import java.io.*;
import java.util.*;

public class lab9C {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        Queue<stone> temp = new LinkedList<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int c = in.nextInt();
        int count = 0;
        //int[] value = new int[n+1];
        stone[] stones = new stone[n+1];
        for (int i = 0; i <=n ; i++) {
            stones[i] = new stone();
        }
        for (int i = 1; i <=n ; i++) {
            stones[i].color = in.nextInt();
            stones[i].position = i;
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            stones[x].child.add(stones[y]);
            stones[y].child.add(stones[x]);
        }
        for (int i = 1; i <=k ; i++) {
            for (int j = 1; j <=n; j++) {
                if (stones[j].color==i){
                    temp.add(stones[j]);
                    //stones[j].val.add(0);
                    stones[j].val[count] = 0;
                    //stones[j].count++;
                    stones[j].isvisit = true;
                }
            }
            while (!temp.isEmpty()){
                stone a = temp.remove();
                for (int j = 0; j < a.child.size(); j++) {
                    if (!a.child.get(j).isvisit){
                        //value[a.child.get(j).position]=value[a.position]+1;
                        a.child.get(j).val[count]=a.val[count]+1;
                        a.child.get(j).isvisit=true;
                        temp.add(a.child.get(j));
                    }
                }
            }
            count++;
            renew(stones);
        }
        for (int i = 1; i <=n ; i++) {
            Arrays.sort(stones[i].val,0,count);
            for (int j = 0; j < c; j++) {
                stones[i].totalval+=stones[i].val[j];
            }
            out.println(stones[i].totalval);
        }
        out.close();
    }
    public static  void renew(stone[] a){
        for (int i = 0; i < a.length; i++) {
            a[i].isvisit=false;
        }
    }
}

class stone{
    int color;
    //int count;
    int position;
    boolean isvisit;
    long totalval;
    ArrayList<stone> child = new ArrayList<>();
    int[] val = new int[101];
}

