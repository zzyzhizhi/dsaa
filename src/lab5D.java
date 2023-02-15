import java.io.*;
import java.util.StringTokenizer;

public class lab5D {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n =in.nextInt();
        String A = in.next();
        String B=in.next();
        char[] a = new char[2*n];
        int[] next = new int[2*n];
        for (int i = 0; i <B.length(); i++) {
            a[i] = B.charAt(B.length()-i-1);
            a[B.length()+i+1]=A.charAt(i);
        }
        a[B.length()] = '#';
        a[2*n-1] = '&';
        for (int i = 0; i < B.length(); i++) {
            if (a[i]=='S') {
                a[i]='N';
                continue;
            }
            if (a[i]=='N') {
                a[i]='S';
                continue;
            }
            if (a[i]=='W') {
                a[i]='E';
                continue;
            }

            if (a[i]=='E') {
                a[i]='W';

            }
        }
     //  for (int i = 0; i <= 2*n-1; i++) {
      //      out.print(a[i]+" ");
      ///  }
        int j,k;
        j=0;k=-1;
        next[0]=-1;

        while (j<2*n-1){
            if (k==-1||a[j]==a[k]){
                j++;
                k++;
                next[j]=k;
            }
            else k = next[k];
        }

    //  for (int i = 0; i <= 2*n-1; i++) {
     //       out.print(next[i]+" ");
     //         }
        if (next[2*n-1]>0) out.println("NO");
        else out.println("YES");
        out.close();

    }
}



