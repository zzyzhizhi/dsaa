import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lab7A {
    static int size = 0;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[m + 1];
        heap[] h = new heap[2*m];//
        long[] result = new long[k];
        for (int i = 0; i < m * 2; i++) {
            h[i] = new heap();
        }
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        for (int i = 1; i <= m; i++) {
            heap temp = new heap();
            temp.key = (long) a[1] * b[i];
            temp.i = 1;
            temp.j = i;
            insert(temp, h);
        }

        int pointer = 0;
        while (pointer < k) {
            heap temp = delete(h);
            result[pointer]=temp.key;
            pointer++;
            if (temp.i+1<=n){
                heap x = new heap();
                x.i=temp.i+1;
                x.j = temp.j;
                x.key = (long) a[x.i] *b[x.j];
                insert(x,h);
            }
        }


        for (int i = 0; i < k; i++) {
            out.print(result[i]+" ");
        }
        out.close();
    }

    public static void insert(heap n, heap[] heap) {
        size++;
        heap[size] = n;
        int cur = size;
        while (cur > 1 && heap[cur].key < heap[cur / 2].key) {
            heap temp = heap[cur];
            heap[cur] = heap[cur / 2];
            heap[cur / 2] = temp;
            cur = cur / 2;
        }
    }

    public static heap delete(heap[] heap) {
        heap result =new heap();
         result = heap[1];

        boolean isswap = false;
        heap[1] = heap[size];
        size--;
        int cur = 1;
        while (2 * cur <= size) {
            isswap = false;
            if (2 * cur == size) {
                if (heap[cur].key > heap[cur * 2].key) {
                    heap temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur * 2;
                    isswap = true;
                }
            } else {
                if (heap[2 * cur].key <= heap[2 * cur + 1].key && heap[cur].key > heap[2 * cur].key) {
                    heap temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur * 2;
                    isswap = true;
                }
                if (isswap == false && heap[2 * cur].key > heap[2 * cur + 1].key && heap[cur].key > heap[2 * cur + 1].key) {
                    heap temp = heap[cur];
                    heap[cur] = heap[cur * 2 + 1];
                    heap[cur * 2 + 1] = temp;
                    cur = cur * 2 + 1;
                    isswap = true;
                }
            }
            if (isswap == false) break;
        }
        return result;
    }

}

class heap {
    long key;
    int i;
    int j;

}

