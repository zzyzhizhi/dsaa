import java.util.Scanner;

public class lab2四 {
    public static int targetlength=0;
    public static int f=1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String cost = scanner.next();
        long totalresult = 0;
        int []costnum = new int[11];
        int []value = new int[2000000];
        int costlength = cost.length();
        int kfirst = (cost.charAt(0)-'0');
        int costsum = 0;
        int x = 0;
        for (int i = 0; i < costlength; i++) {
            costnum[i] = cost.charAt(i)-'0';
            costsum+=(int)Math.pow(10,costlength-i-1)*costnum[i];
        }

        for (int i = 0; i < n; i++) {
            int a[] = new int[11];
            f=1;
            String target = scanner.next();
            if (target.charAt(0)=='-') {
                targetlength = target.length()-1;
                for (int j = 0; j < targetlength; j++) {
                    a[j] = target.charAt(j+1) - '0';
                }
                f=-1;
            }
            else {
                targetlength = target.length();
                for (int j = 0; j < targetlength; j++) {
                    a[j] = target.charAt(j) - '0';
                }
            }
            for (int h = 0; h < targetlength; h++) {
                totalresult+= (long) (int) Math.pow(10, targetlength - h - 1) *a[h]*f;
            }

                for (int j = 0; j <= targetlength-costlength; j++) {
                    boolean ifswap = false;
                    int max = a[j];
                    int flag = j;
                    for (int k = j + 1; k < targetlength; k++) {
                        if (a[k]*f > max*f) {
                            max = a[k];
                            flag = k;
                            ifswap = true;
                        }
                    }
                    if (!ifswap) continue;
                    if (j != targetlength-costlength ) {
                        value[x] = jisuan(a,j,flag,costsum);
                        a[flag] = a[j];
                        a[j] = max;

                        x++;
                    }
                   /* if (j == targetlength-costlength&&max-a[j]>kfirst){
                        value[x] = jisuan(a,j,flag,costsum);
                        a[flag] = a[j];
                        a[j] = max;

                        x++;
                    }*/
                    if (j == targetlength-costlength){
                        if (pd(a,j,flag,costsum)){
                            value[x] = jisuan(a,j,flag,costsum);
                            a[flag] = a[j];
                            a[j] = max;

                            x++;
                        }
                    }
            }
        }
        Guibing(value,0,x-1);
        int count1 = x-1;
        int count2 = 0;
        while (count1>=0&&count2<m){
            totalresult+= value[count1];
            //System.out.println(value[count1]);
            count2++;
            count1--;

        }
        System.out.println(totalresult);
    }

    public static boolean pd(int []arr,int x,int y,int cost){
        int result1=0;
        int b[] = new int[11];
        for (int i = x; i < targetlength; i++) {
            b[i] = arr[i];
        }
        for (int i = x; i < targetlength; i++) {
            result1+=(int)Math.pow(10,targetlength-i-1)*b[i]*f;
        }
        int result2 = 0;
        int middle = 0;
        middle = b[x];
        b[x] = b[y];
        b[y] = middle;
        for (int i = x; i < targetlength; i++) {
            result2+=(int)Math.pow(10,targetlength-i-1)*b[i]*f;
        }
        if (result2-result1>cost) return true;
        else return false;

    }

    public static int jisuan(int arr[],int x,int y,int cost){
        int result1=0;
        int b[] = new int[11];
        for (int i = x; i < targetlength; i++) {
            b[i] = arr[i];
        }
        for (int i = x; i < targetlength; i++) {
            result1+=(int)Math.pow(10,targetlength-i-1)*b[i]*f;
        }
        int result2 = 0;
        int middle = 0;
        middle = b[x];
        b[x] = b[y];
        b[y] = middle;
        for (int i = x; i < targetlength; i++) {
            result2+=(int)Math.pow(10,targetlength-i-1)*b[i]*f;
        }
        return result2-result1-cost;

    }

    public static void Guibing(int a[] , int l, int r){
        if (l>=r) return;
        int mid = (l + r) / 2;
        Guibing(a,l,mid);
        Guibing(a,mid+1,r);
        sort(a,l,r,mid);

    }
    public static void sort(int a[], int l,int r,int mid){
        int b[] = new int[r-l+1];
        int i,j;
        for (int k = l; k <=r ; k++) {
            b[k-l] = a[k];
        }
        i = l;
        j = mid+1;
        for (int k = l; k <=r ; k++) {
            if (i>mid){
                a[k] = b[j-l];
                j++;
            }
            else if (j>r){
                a[k] = b[i-l];
                i++;
            }
            else if (b[i-l]>b[j-l]){
                a[k] = b[j-l];
                j++;
            }
            else {
                a[k] = b[i-l];
                i++;
            }
        }
    }
}
