import java.util.Arrays;

public class mergesort {
    public static void mergerSort(boolean flag, int[] a, int left, int mid, int right) {

        int[] t = new int[a.length];
        int m = left;   //记录第一个序列首编号
        int n = mid + 1;  //记录第二个序列首编号
        int k = left;


        while (m <= mid && n <= right) {
            if (a[m] >= a[n]) {
                t[k++] = a[m++];  //这种形式与升序中的 t[k]=a[m]; k++; m++;的效果是一样的
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

    public static void divide(boolean flag, int[] a, int first, int last) {
        int mid = 0;
        if (first < last) {
            mid = (first + last) / 2;
            divide(flag, a, first, mid);  //对第一序列进行递归排序
            divide(flag, a, mid + 1, last);  //对第二序列进行递归排序
            mergerSort(flag, a, first, mid, last);  //进行合并
        }
    }

    public static void main(String[] args) {
        int[] a1 = {44, 33, 12, 66, 45, 66, 88, 99, 23};
        int[] a2 = {66, 33, 5, 2, 8, 6, 999, 55, 44, 16};
        //进行升序
        divide(true, a1, 0, a1.length - 1);
        //进行降序
        divide(false, a2, 0, a2.length - 1);
        System.out.println("升序：" + Arrays.toString(a1));
        System.out.println("降序：" + Arrays.toString(a2));
//        Arrays.stream(a1).forEach(word -> System.out.print(word+"   "));
//        System.out.println();
//        Arrays.stream(a2).forEach(word -> System.out.print(word+"   "));
    }
}





