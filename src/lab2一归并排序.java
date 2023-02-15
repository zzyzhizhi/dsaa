import java.util.Scanner;

public class lab2一归并排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        long result = 0;
        Guibing(arr,0,n-1);
        for (int i = 0; i < n/2; i++) {
            result+=((long)arr[i]*(long)arr[n-1-i]);
        }
        System.out.println(result);
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
