import java.util.Scanner;

public class lab3Ques2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            long m = in.nextInt();
            long Currentmoney = m;
            long amount=0;
            node3 cur;
            int b = in.nextInt();
            int min= b;
            node3 head = new node3(b);
            cur=head;
            for (int i = 1; i < n; i++) {
                int a = in.nextInt();
                if (a<min) min=a;
                node3 temp = new node3(a);
                cur.next = temp;
                cur=cur.next;
            }
            cur.next = head;
            cur=head;
            while(Currentmoney>=min){
                if (Currentmoney>=cur.price){
                    amount++;
                    Currentmoney-=cur.price;
                }
                cur=cur.next;
            }
            System.out.println(amount);
        }
    }
    class node3{
        int price;
        node3 next;

        public node3(int price) {
            this.price = price;
        }
    }


