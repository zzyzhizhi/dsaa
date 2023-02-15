import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bonusC {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            node1 head=new node1(1000000001,1000000001);
            node1 cur = head;
            for (int j = 0; j < n; j++) {
                node1 temp = new node1(in.nextInt(),in.nextInt());
                cur.next = temp;
                cur= cur.next;
            }
            node1 tail = new node1(1000000001,1000000001);
            cur.next=tail;
            cur=head;
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int coe = in.nextInt();
                int exp = in.nextInt();
                while(true){
                    if(exp<cur.next.exp) break;
                    cur = cur.next;
                }
                if (exp==cur.exp) {
                    cur.coe+=coe;
                }
                else{
                    node1 temp = new node1(coe,exp);
                    temp.next = cur.next;
                    cur.next = temp;
                }
            }
            cur=head.next;
            while (cur!=tail){
                if (cur!=head.next){
                    if (cur.coe==1&&cur.exp==1)
                        out.print("+x");
                    if (cur.coe==1&&cur.exp!=1)
                        out.print("+x^"+cur.exp);
                    if (cur.coe==-1&&cur.exp==1)
                        out.print("-x");
                    if (cur.coe==-1&&cur.exp!=1)
                        out.print("-x^"+cur.exp);
                    if (cur.coe<0&&cur.exp==0&&cur.exp!=1)
                        out.print("-"+Math.abs(cur.coe));
                    if (cur.coe>0&&cur.exp==0&&cur.coe!=1)
                        out.print("+"+Math.abs(cur.coe));
                    if (cur.coe<0&&cur.exp!=1&&cur.exp!=0&&cur.exp!=1)
                        out.print("-"+Math.abs(cur.coe)+"x^"+cur.exp);
                    if (cur.coe>0&&cur.exp!=1&&cur.exp!=0&&cur.coe!=1)
                        out.print("+"+Math.abs(cur.coe)+"x^"+cur.exp);
                    if (cur.coe<0&&cur.exp==1&&cur.exp!=1)
                        out.print("-"+Math.abs(cur.coe)+"x");
                    if (cur.coe>0&&cur.exp==1&&cur.coe!=1)
                        out.print("+"+Math.abs(cur.coe)+"x");
                }
                else {
                    if (cur.coe==-1&&cur.exp==1)
                        out.print("-x");
                    if (cur.coe==-1&&cur.exp!=1)
                        out.print("-x^"+cur.exp);
                    if (cur.coe==1&&cur.exp==1)
                        out.print("x");
                    if (cur.coe==1&&cur.exp!=1)
                        out.print("x^"+cur.exp);
                    if (cur.coe<0&&cur.exp==0&&cur.exp!=1)
                        out.print("-"+Math.abs(cur.coe));
                    if (cur.coe>0&&cur.exp==0&&cur.coe!=1)
                        out.print(Math.abs(cur.coe));
                    if (cur.coe<0&&cur.exp!=1&&cur.exp!=0&&cur.exp!=1)
                        out.print("-"+Math.abs(cur.coe)+"x^"+cur.exp);
                    if (cur.coe>0&&cur.exp!=1&&cur.exp!=0&&cur.coe!=1)
                        out.print(Math.abs(cur.coe)+"x^"+cur.exp);
                    if (cur.coe<0&&cur.exp==1&&cur.exp!=1)
                        out.print("-"+Math.abs(cur.coe)+"x");
                    if (cur.coe>0&&cur.exp==1&&cur.coe!=1)
                        out.print(Math.abs(cur.coe)+"x");
                }
                    //out.println(cur.coe+" "+cur.exp);
                cur=cur.next;
            }
            out.println("");
        }
        out.close();
    }
}

class node1 {
    int coe;
    int exp;
    node1 next;

    public node1(int cop, int exp) {
        this.coe = cop;
        this.exp = exp;
    }
}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }


    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
