import java.util.Scanner;

public class lab0三 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  route[][] = new int[1008][1008];
        int x1= scanner.nextInt();
        int y1= scanner.nextInt();
        int x2= scanner.nextInt();
        int y2= scanner.nextInt();
        int X2= x2-x1;
        int Y2= y2-y1;
        int m=scanner.nextInt();
        for (int i = 0; i <= Y2; i++) {
            route[i][0]=1;
        }
        for (int i = 0; i <= X2; i++) {
            route[0][i]=1;
        }
        //if (X2==0&&Y2==0) System.out.println(1);
        //else {
            for (int i = 1; i <= Y2; i++) {
                for (int j = 1; j <= X2; j++) {
                    route[i][j] = route[i - 1][j] + route[i][j - 1];
                    route[i][j] = route[i][j] % m;
                }
            }
            System.out.println(route[Y2][X2]);
        //}
    }
}
