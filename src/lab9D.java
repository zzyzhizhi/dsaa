import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lab9D {
    static  List<ArrayList<Integer>> result = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static  int time = 0;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int[] dfn = new int[n+1];
        int[] low = new int[n+1];
        boolean[] instack = new boolean[n+1];



        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i <m ; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph.get(x).add(y);
        }
        for (int i = 1; i <=n ; i++) {
            if (dfn[i]==0){
                tarjan(i,dfn,low,instack);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                out.print(result.get(i).get(j));
            }
            out.println("");
        }
        out.close();
    }
    public static void tarjan(int current,int[] dfn,int[] low,boolean[] instack){
        dfn[current] = low[current] = time++;
        instack[current]=true;
        stack.push(current);
        for (int i = 0; i < graph.get(current).size(); i++) {
            int next = graph.get(current).get(i);
            if (dfn[next]==-1){
                tarjan(next,dfn,low,instack);
                low[current] = Math.min(low[current],low[next]);
            }else if(instack[next]){
                low[current] = Math.min(low[current],dfn[next]);
            }
        }

        if (low[current]==dfn[current]){
            ArrayList<Integer> temp = new ArrayList<>();
            int j = 0;
            while (current!=j){
                j = stack.pop();
                instack[j] = false;
                temp.add(j);
            }
            result.add(temp);
        }
    }


}
