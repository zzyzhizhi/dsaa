import java.util.Scanner;

public class lab1二回溯组合 {
    public static long num =0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int S = scanner.nextInt();
        int arr[] = new int[n];
        int much=0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <n ; j++) {
                int left = S - arr[i] - arr[j];
               if (left < arr[j]) break;
                if (left>arr[n-1]) continue;;
                int a = Search1(0,n-1,left,arr);
                int b = Search2(0,n-1,left,arr);
                much = a-b+1;
               // System.out.println(a);
               // System.out.println(b);
               // System.out.println(much);
               // System.out.println();

                 if (much<=0) continue;
                 if (much == 1&&arr[j]==left) {
                    break;
                }
                if (much == 2&&arr[j]==left&&arr[i]==left) {
                    break;
                }
                if (much>=1&&left!=arr[j]) {
                    num+=much;
                }
                //if (much==2&&left==arr[j]){
                //    num++;
                //}
                if (much>=3&&arr[j]==left&&arr[i]==left){
                    num+=((long)much*(long)(much-1)*(long)(much-2))/6;
                    if (a==n-1) {
                        i=n-1;
                        break;
                    }
                    else  {
                        i=a+1;
                        j=i;
                    }
                }
                if (much>=1&&arr[j]==left&&arr[i]!=left){
                    num+=(much*(much-1))/2;
                    if (a==n-1) j=n-1;
                    else j=a;
                }
            }
        }
        System.out.println(num);

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
