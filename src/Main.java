import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt()-1;
        ifpre[] pre = new ifpre[n];
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            pre[i] = new ifpre();
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            graph.get(x).add(y);
        }
        Tarjan t = new Tarjan(graph, n);
        List<ArrayList<Integer>> result = t.run();

        for (int i = 0; i < n; i++) {
            pre[i].isvisit = false;
        }

        for (int i = 0; i < result.size(); i++) {//构建pre
            int size = result.get(i).size();
            for (int j = 0; j < size; j++) {
                pre[result.get(i).get(j)] = pre[result.get(i).get(0)];
            }
        }
        //判断剩下有多少连在一起
        pre[s].isvisit =true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                if (pre[i]!=pre[graph.get(i).get(j)])
                    pre[graph.get(i).get(j)].isvisit = true;
            }
        }
        int count3 = 0;
        for (int i = 0; i < result.size(); i++) {
            if (!pre[result.get(i).get(0)].isvisit){
                count3++;
            }
        }
        out.println(count3);
        out.close();
    }
}
class ifpre{
    boolean isvisit;
}

class Tarjan{
    int n;
    List<ArrayList<Integer>> graph;
    List<ArrayList<Integer>> result;
    boolean[] inStack;
    Stack<Integer> stack;
    int[] dfn;
    int[] low;
    int time;

    public Tarjan(List<ArrayList<Integer>> graph, int n) {
        this.graph = graph;
        this.n = n;
        this.inStack = new boolean[n];
        this.stack = new Stack<>();
        dfn = new int[n];
        low = new int[n];
        Arrays.fill(dfn, -1);
        Arrays.fill(low, -1);
        result = new ArrayList<>();
    }

    public List<ArrayList<Integer>> run() {
        for (int i = 0; i < n; i++) {
            if (dfn[i] == -1) {
                tarjan(i);
            }
        }
        return result;
    }

    public void tarjan(int current) {
        dfn[current] = low[current] = time++;
        inStack[current] = true;
        stack.push(current);
        for (int i = 0; i < graph.get(current).size(); i++) {
            int next = graph.get(current).get(i);
            if (dfn[next] == -1) {
                tarjan(next);
                low[current] = Math.min(low[current], low[next]);
            } else if (inStack[next]) {
                low[current] = Math.min(low[current], dfn[next]);
            }
        }
        if (low[current] == dfn[current]) {
            ArrayList<Integer> temp = new ArrayList<>();
            int j = -1;
            while (current != j) {
                j = stack.pop();
                inStack[j] = false;
                temp.add(j);
            }
            result.add(temp);
        }
    }
}




