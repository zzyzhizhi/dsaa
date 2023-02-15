import java.util.Scanner;

public class lab2三归并排序2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Guibing(arr,0,n-1);
        int result = n/3 +1;
        int answer = arr[result-1];
        int x = 0;
        int y = result-1;
        System.out.println(answer);
        while(x<result-1){
            System.out.print(arr[x]+" ");
            x++;
            System.out.print(arr[y]+" ");
            System.out.print(arr[y+1]+" ");
            y+=2;
        }
        while (y<=n-1){
            System.out.print(arr[y]+" ");
            y++;
        }
    }
    public static void Guibing(int a[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            Guibing(a, l, mid);
            Guibing(a, mid + 1, r);
            sort(a, l, r, mid );
        }
    }

    public static void sort(int a[], int l, int r, int mid) {
        int b[] = new int[r - l + 1];
        int i = l;
        int j = mid+1;
        int x = 0;
        while (i <= mid && j <= r) {
            if (a[i]<=a[j]){
                b[x++] = a[i++];
            }
            else {
                b[x++] = a[j++];
            }
        }
        while(i<=mid){
            b[x++] = a[i++];
        }
        while(j<=r){
            b[x++] = a[j++];
        }
        for (int k = 0; k < b.length; k++) {
            a[l+k] = b [k];
        }
    }
}

