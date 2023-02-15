import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bonusA {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            int diff =-Integer.MAX_VALUE;
            int p1 = 0;
            int p2 = 1;
            while (p2<n){
                if (diff<a[p1]-a[p2]) diff = a[p1]-a[p2];
                if (a[p2]>a[p1]) p1=p2;
                p2++;

            }
            out.println(diff);
        }
        out.close();
    }
}
