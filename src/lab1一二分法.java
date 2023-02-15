import java.util.Scanner;

public class lab1一二分法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=scanner.nextInt();
        }
        for (int i = 0; i < Q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int a = Search1(0,N-1,x,arr);
            int b = Search2(0,N-1,y,arr);
            if ((a==b)||(b-a-1)==0||x==y) System.out.println("NO");
            else System.out.println("YES "+(b-a-1));
        }
    }
    public static int Search2(int l, int r,int target,int a[]){
        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]>=target){
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return l;
    }
    public static int Search1(int l, int r,int target,int a[]){
        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]>target){
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return r;
    }
}

