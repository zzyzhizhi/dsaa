import java.util.Scanner;

public class lab1三二分答案 {
    public static int arr[] = new int[1000001];
    public static int m;
    public static int n;
    public static double flag;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
         m = scanner.nextInt();
         int max=0;
        for (int i = 0; i < m; i++) {
            arr[i]=scanner.nextInt();
            if (arr[i]>max) max=arr[i];
        }
        Search1(0,max*max);
        System.out.println(flag*Math.PI);
    }
    public static boolean Check(double mid){
        int total=0;
        for (int i = 0; i < m; i++) {
            total+=(int)((arr[i]*arr[i])/mid);
        }
        if (total>=n){
            return true;
        }
        else return false;
    }
    public static void Search1(double l, double r){
        while(l<=r){
            double mid=(l+r)/2;
            if(Check(mid)){
                l = mid + 0.000000001;
                flag=mid;
            }
            else r = mid - 0.000000001;
        }
    }
}
