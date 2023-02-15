
import java.io.*;
import java.util.*;

public class lab3q1 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        node1 head=new node1(1000000001,1000000001);
        node1 cur = head;
        for (int i = 0; i < n; i++) {
            node1 temp = new node1(in.nextInt(),in.nextInt());
            cur.next = temp;
            cur= cur.next;
        }
        node1 tail = new node1(1000000001,1000000001);
        cur.next=tail;
        cur=head;

        for (int i = 0; i < m; i++) {
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

        int count = 0;
        cur = head.next;
        while(cur!=tail){
            if(cur.coe!=0) count++;
            cur = cur.next;
        }
        out.println(count);

        cur=head.next;
        while (cur!=tail){
            if (cur.coe!=0) out.println(cur.coe+" "+cur.exp);
            cur=cur.next;
        }
        out.close();
    }
}

