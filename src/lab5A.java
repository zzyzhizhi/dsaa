import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
1
abcdef
3
abcd
bc
cdefg
*/
public class lab5A {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        String t;
        node7 []a = new node7[100001];

        int T = in.nextInt();
        int n;

        for (int i = 0; i < T; i++) {
            for (int j = 0; j <100001 ; j++) {
                a[j] = new node7();
                a[j].left = 101;
            }
            int count = 0;
            t=in.next();
            n=in.nextInt();
            String sub[] = new String[n];
            for (int j = 0; j < n; j++) {
                sub[j] = in.next();
            }
            Boolean flag = false;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= t.length()-sub[j].length(); k++) {
                    for (int l = 0; l < sub[j].length(); l++) {
                        if (t.charAt(k+l)==sub[j].charAt(l)){
                            flag=true;
                        }
                        else{
                            flag=false;
                            break;
                        }
                    }
                    if (flag==true){
                        a[count].num = j+1;
                        a[count].left = k;
                        a[count].right= k+sub[j].length()-1;
                        count++;
                    }
                }
            }
            Arrays.sort(a, new Comparator<node7>() {
                @Override
                public int compare(node7 o1, node7 o2) {
                    if ((o1.left<o2.left)){
                        return -1;
                    }
                    else return 1;
                }
            });
            int num[] = new int[1001];
            int left[] = new int[1001];
            int l = 0;
            int r = 0;
            //num[0] = a[0].num;
            //left[0] = 1;
            int ans=0;
            int count1 = 0;
    while(r<t.length()){
        int max =r;
        l =0;
        Boolean hasmax = false;
        while(a[l].left<=max){
            if (a[l].right>=r){
                hasmax = true;
                num[count1] = a[l].num;
                left[count1] = a[l].left+1;
                r = a[l].right+1;

            }
            l++;
        }

        if (hasmax==true){
            ans++;
            count1++;
        }

        if (r==t.length()) break;

        if (hasmax==false) {
            out.println(-1);
            break;
        }
    }
    if (r==t.length()){
        out.println(ans);
        for (int j = 0; j <count1 ; j++) {
            out.println(num[j]+" "+left[j]);
        }
    }
        }
        out.close();
    }
}

class node7{
    int num,left,right;
}



