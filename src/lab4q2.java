import java.util.Scanner;

public class lab4q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[] = new int[100001];
        int front = 0;
        int rear = 0;
        int n;
        n = in.nextInt();
        for (int i = 0; i < n; i++) {

            String b=in.next();
            int h =in.nextInt();
            if (b.equals("E")) {

                a[rear]=h;
                rear++;
            }
            if (b.equals("D")){
                front+=h;
                System.out.println(a[front]);
            }

        }
    }
}
