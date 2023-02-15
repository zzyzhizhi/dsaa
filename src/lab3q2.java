import java.io.*;
import java.util.*;

public class lab3q2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        long m = in.nextLong();
        long Currentmoney = m;
        long amount=0;
        long onetimecost=0;
        node8 cur;
        int b = in.nextInt();
        int min= b;
        onetimecost+=b;
        node8 head = new node8(b);
        cur=head;
        for (int i = 1; i < n; i++) {
            int a = in.nextInt();
            onetimecost+=a;
            if (a<min) min=a;
            node8 temp = new node8(a);
            cur.next = temp;
            cur=cur.next;
        }
        cur.next = head;
        cur=head;
        amount+=(Currentmoney/onetimecost)*(long)n;
        Currentmoney=Currentmoney%onetimecost;
        while(Currentmoney>=min){
            if (Currentmoney>=cur.price){
                amount++;
                Currentmoney-=cur.price;
            }
            cur=cur.next;

        }
        out.println(amount);
        out.close();
    }
}
class node8 {
    int price;
    node8 next;

    public node8(int price) {
        this.price = price;
    }
}
