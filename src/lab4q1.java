import java.util.Scanner;

public class lab4q1 {
    static stack k[] = new stack[100003];
    static int flag = 0;
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String m = in.nextLine();
        for (int i = 0; i < m.length()+2; i++) {
            k[i] = new stack(0);
        }
        for (int i = 0; i < m.length(); i++) {
            push(m.charAt(i));
        }
        System.out.println(k[0].val);
    }
    public static void push( char h){
        if (h=='('){
            flag++;
            k[flag].c='(';
            return;
        }
        if (h==')'&&k[flag].val==0) {
            flag--;
            k[flag].val++;
            k[flag+1].val=0;
            return;
        }
        if (h==')'&&k[flag].val!=0){
            flag--;
                k[flag].val =k[flag].val+ k[flag+1].val*2;
                k[flag+1].val=0;
                k[flag].val %= 514329;

        }
    }
}
class stack{
    char c;
    int val;

    public stack(int val) {
        this.val = val;
    }
}
