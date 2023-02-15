import java.io.*;
import java.util.StringTokenizer;

public class lab2二归并排序找逆序对 {
    public static long result = 0;
    public static long sum = 0;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T;
        T = in.nextInt();
        for (int i = 0; i < T; i++) {
            sum = 0;
            int n = in.nextInt();
            int arr[] = new int[n+1];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            Guibing(arr, 0, n - 1);
            out.println(sum);
        }
        out.close();
    }

    public static void Guibing(int a[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            Guibing(a, l, mid);
            Guibing(a, mid + 1, r);
            result += sort(a, l, r, mid );
        }
    }

    public static long sort(int a[], int l, int r, int mid) {
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
                sum+=mid-i+1;
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
        return sum;
    }
}



