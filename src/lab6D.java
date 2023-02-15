import java.util.ArrayList;

public class lab6D {
    static long count = 0;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        treenode3 tree[] = new treenode3[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new treenode3();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            tree[a].child.add(tree[b]);
            tree[b].child.add(tree[a]);
        }

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            tree[i].p = a;
        }
        int maxpoint = 0;
        for (int i = 1; i < n; i++) {
            if (tree[i].p > tree[maxpoint].p)
                maxpoint = i;
        }
        tree[maxpoint].isvisit1 = true;
        tree[maxpoint].isvisit3 = true;
        tree[maxpoint].isroot = true;
        for (int i = 0; i < n; i++) {
            if (tree[i].child.size() == 1) {
                tree[i].isvisit2 = true;
            }
        }
        dfs2(tree[maxpoint], false);
        //for (int i = 0; i < n; i++) {
        //    out.println(tree[i].p);
        //}
        dfs2(tree[maxpoint], true);
        //out.println(maxpoint);
        for (int i = 0; i < n; i++) {
            //    out.println(tree[i].p);
            if (tree[i].child.size() == 1)
                count += tree[i].p;
        }
        out.println(count);
        out.close();
    }

    public static void dfs2(treenode3 a, boolean mode) {
        if (!mode) {
            //if (a.child.size() == 1) a.child.get(0).isvisit2 = true;
            for (int i = 0; i < a.child.size(); i++) {
                if (a.child.get(i).isvisit1 == mode) {
                    a.child.get(i).isvisit1 = true;
                    dfs2(a.child.get(i), false);
                }
            }
            for (int i = 0; i < a.child.size(); i++) {
                if (a.child.get(i).isvisit2 == true)
                    a.p = Math.max(a.p, a.child.get(i).p);
            }
            a.isvisit2 = true;
        }
        if (mode) {
            if (a.isroot) {
                int max = 0;
                int maxpoint1 = -1;
                int maxpoint2 = -1;
                if (a.child.size() == 1) {
                    a.child.get(0).p = a.p;
                    a.child.get(0).isvisit3 = true;
                    dfs2(a.child.get(0), true);
                }
                if (a.child.size() >= 2) {
                    for (int i = 0; i < a.child.size(); i++) {
                        if (a.child.get(i).p > max && a.child.get(i).isvisit3 == false) {
                            maxpoint1 = i;
                            max = a.child.get(i).p;
                        }
                    }
                    a.child.get(maxpoint1).ismax = true;
                    max = 0;
                    for (int i = 0; i < a.child.size(); i++) {
                        if (a.child.get(i).p > max && a.child.get(i).ismax != true && a.child.get(i).isvisit3 == false) {
                            maxpoint2 = i;
                            max = a.child.get(i).p;
                        }
                    }

                    if (maxpoint1 != -1 && maxpoint2 != -1) {
                        a.child.get(maxpoint1).p = a.p;
                        a.child.get(maxpoint2).p = a.p;
                        //a.child.get(maxpoint1).isvisit3 = true;
                        //a.child.get(maxpoint2).isvisit3 = true;
                        //dfs(a.child.get(maxpoint1), true);
                        //dfs(a.child.get(maxpoint2), true);
                    }
                    for (int i = 0; i < a.child.size(); i++) {
                        //a.child.get(i).isvisit3=true;
                        dfs2(a.child.get(i), true);
                    }
                }
            } else {
                int max = 0;
                int maxpoint = -1;
                a.isvisit3 = true;
                for (int i = 0; i < a.child.size(); i++) {
                    if (a.child.get(i).p > max && a.child.get(i).isvisit3 == false) {
                        max = a.child.get(i).p;
                        maxpoint = i;
                    }
                }
                if (maxpoint != -1) {
                    a.child.get(maxpoint).p = a.p;
                    //a.child.get(maxpoint).isvisit3 = true;
                    //dfs(a.child.get(maxpoint), true);
                }
                for (int i = 0; i < a.child.size(); i++) {
                    if (a.child.get(i).isvisit3==false)
                    dfs2(a.child.get(i),true);
                }
            }
            //if (a.child.size() == 1) count += a.p;
        }
    }
}

class treenode3 {
    int p;
    boolean isvisit1;
    boolean isroot;
    boolean isvisit2;
    boolean isvisit3;
    boolean ismax;
    ArrayList<treenode3> child = new ArrayList<>();
}

