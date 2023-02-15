import java.io.*;
import java.util.StringTokenizer;

public class lab7B {
    static int size = 0;

    public static void main(String[] args) {

        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int sum=0;
            int n = in.nextInt();
            int[] heap = new int[n + 1];
            size = 0;
            for (int j = 0; j < n; j++) {
                int x = in.nextInt();
                insert(x, heap);
            }
            for (int j = 1; j <= n - 1; j++) {
                int result = 0;
                result+=delete(heap);
                result+=delete(heap);
                sum+=result;
                insert(result,heap);
            }
            out.println(sum);
        }

        out.close();

    }

    public static void insert(int x, int[] heap) {
        size++;
        heap[size] = x;
        int cur = size;
        while (cur > 1 && heap[cur] < heap[cur / 2]) {
            int temp = heap[cur];
            heap[cur] = heap[cur / 2];
            heap[cur / 2] = temp;
            cur = cur / 2;
        }
    }

    public static int delete(int[] heap) {
        int result = heap[1];
        boolean isswap = false;
        heap[1] = heap[size];
        size--;
        int cur = 1;
        while (2 * cur <= size) {
            isswap =false;
            if (2 * cur == size) {
                if (heap[cur] > heap[cur * 2]) {
                    int temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur=cur*2;
                    isswap =true;
                }
            } else {
                if (heap[2 * cur] <= heap[2 * cur + 1] && heap[cur] > heap[2 * cur]) {
                    int temp = heap[cur];
                    heap[cur] = heap[cur * 2];
                    heap[cur * 2] = temp;
                    cur = cur*2;
                    isswap =true;
                }
                if (isswap==false&&heap[2 * cur] > heap[2 * cur + 1] && heap[cur] > heap[2 * cur + 1]) {
                    int temp = heap[cur];
                    heap[cur] = heap[cur * 2 + 1];
                    heap[cur * 2 + 1] = temp;
                    cur = cur*2+1;
                    isswap =true;
                }
            }
            if (isswap==false) break;
        }
        return result;
    }
}



