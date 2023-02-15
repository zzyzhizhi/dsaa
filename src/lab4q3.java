import java.util.Scanner;
import java.util.Arrays;
public class lab4q3 {
        public static void main(String[] args) {
            Scanner in =new Scanner(System.in);
            int n=in.nextInt();
            int k=in.nextInt();
            int q=in.nextInt();
            sign a[] = new sign[n];
            sign b[] = new sign[n];
            int c[] = new int[q];
            for (int i = 0; i < n; i++) {
                a[i].val = in.nextInt();
                a[i].position = i;
                b[i].val = a[i].val;
                b[i].position = a[i].position;
            }
            quicksort(a,0,n-1);
            for (int i = 0; i < q; i++) {
                 c[i] = in.nextInt();
            }

            for (int i = n-1; i >=0 ; i--) {

            }
        }

        private static void quicksort(sign[] a, int low, int high) {
            int i,j;
            if (low>high) {
                return;
            }
            i=low;
            j=high;
            int temp=a[low].val;//基准位,low=length时，会报异常，java.lang.ArrayIndexOutOfBoundsException: 4 ，所以必须在if判断后面,就跳出方法。
            while(i<j){
                //先从右边开始往左递减，找到比temp小的值才停止
                while ( temp<=a[j].val && i<j) {
                    j--;
                }
                //再看左边开始往右递增，找到比temp大的值才停止
                while ( temp>=a[i].val && i<j) {
                    i++;
                }
                //满足 i<j 就交换,继续循环while(i<j)
                if (i<j) {
                    int t=a[i].val;
                    int m =a[i].position;
                    a[i].val=a[j].val;
                    a[i].position=a[j].position;
                    a[j].val=t;
                    a[j].position=m;
                }
            }
            //最后将基准位跟  a[i]与a[j]相等的位置，进行交换,此时i=j
            int k =a[low].position;
            a[low].val=a[i].val;
            a[low].position = a[i].position;
            a[i].val=temp;
            a[i].position = k;
            //左递归
            quicksort(a, low, j-1);
            //右递归
            quicksort(a, j+1, high);
        }
    }
    class sign{
    int val;
    int position;
    }



