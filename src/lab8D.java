import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lab8D {
    public static int[] t =new int[100000+1];
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        long[] sum = new long[n+1];
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        divide(a,1,n);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+(long) a[i];
        }

//        Arrays.sort(a);
//        for (int i = 1; i <= n/2; i++) {
//            int temp = a[i];
//            a[i] = a[n-i+1];
//            a[n-i+1] = temp;
//        }

        //undirected graph
        if (sum[n]%2==0) out.println("YES");
        else out.println("NO");
        //undirected simply graph
        int position = n;
        boolean pd = true;
        for (int k = 1; k <=n ; k++) {
            long leftsum=0; long rightsum=0;
            leftsum = sum[k];
            while (a[position]<k&&position>0) position--;
            if (k<position) rightsum = (long) k *(k-1)+((long) k *(position-(k))+sum[n]-sum[position]);
            else rightsum = (long) k *(k-1)+(sum[n] - sum[k]);
            if (leftsum>rightsum) {
                pd = false;
                break;
            }
        }
        if (pd&&sum[n]%2==0) out.println("YES");
        else out.println("NO");
        //tree
        if (a[n]==0) out.println("NO");
        else {
            if ((sum[n]) == ((long)(n - 1)* 2)) out.println("YES");
            else out.println("NO");
        }
        out.close();
    }



    public static void mergerSort( int[] a, int left, int mid, int right) {

        //int[] t = new int[a.length];
        int m = left;
        int n = mid + 1;
        int k = left;


        while (m <= mid && n <= right) {
            if (a[m] >= a[n]) {
                t[k++] = a[m++];
            } else {
                t[k++] = a[n++];
            }
        }

        while (m <= mid) {
            t[k++] = a[m++];
        }
        while (n <= right) {
            t[k++] = a[n++];
        }
        while (left < k) {
            a[left] = t[left];
            left++;
        }
    }

    public static void divide( int[] a, int first, int last) {
        int mid = 0;
        if (first < last) {
            mid = (first + last) / 2;
            divide( a, first, mid);
            divide( a, mid + 1, last);
            mergerSort( a, first, mid, last);
        }
    }
}
