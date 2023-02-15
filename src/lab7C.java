public class lab7C {
    static int size=0;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
//        int n = in.nextInt();
//        graph3[] a = new graph3[n + 2];
//        graph3[] b = new graph3[n + 2];
//        for (int i = 0; i < n + 2; i++) {
//            a[i] = new graph3();
//        }
//        for (int i = 0; i < n+2; i++) {
//            b[i] = new graph3();
//        }
//        a[0].key = -1;
//        a[n + 1].key = -1;
//        for (int i = 1; i <= n; i++) {
//            a[i].key = in.nextInt();
//            a[i].left = a[i - 1];
//            a[i - 1].right = a[i];
//            a[i].position = i;
//        }
//        a[n].right = a[n + 1];
//        //b[0].key = -1;
//        for (int i = 1; i <= n; i++) {
//            insert(a[i], b);
//        }
//        boolean pd = false;
//        boolean test = true;
//        graph3 temp1 = new graph3();
//        while (!pd) {
//            test = true;
//            while (test&&size>0) {
//                temp1 = delete(b);
//                if (!temp1.isdelete) test = false;
//            }
//            boolean ischange = false;
//            if (temp1.left.key == -1 || temp1.right.key == -1) {
//                if (temp1.left.key == -1 && temp1.right.key > 0) {
//                    temp1.key = (temp1.key ^ temp1.right.key) + 1;
//                    temp1.right.isdelete=true;
//                    temp1.right = temp1.right.right;
//                    temp1.right.left = temp1;
//                    //ischange = true;
//                    insert(temp1, b);
//                }
//                if (temp1.right.key == -1 && temp1.left.key > 0) {
//                    temp1.key = (temp1.left.key ^ temp1.key) + 1;
//                    temp1.left.isdelete =true;
//                    temp1.left = temp1.left.left;
//                    temp1.left.right = temp1;
//                    //ischange = true;
//                    insert(temp1, b);
//                }
//                if (temp1.left.key == -1 && temp1.right.key == -1 ) {
//                    pd = true;
//                    out.println(temp1.key);
//                }
//            } else {
//                int x = (temp1.key ^ temp1.right.key) + 1;
//                int y = (temp1.left.key ^ temp1.key) + 1;
//                if (y >= x) {
//                    temp1.left.isdelete=true;
//                    temp1.left = temp1.left.left;
//                    temp1.left.right = temp1;
//                    temp1.key = y;
//                    insert(temp1, b);
//                } else {
//                    temp1.right.isdelete=true;
//                    temp1.key = x;
//                    temp1.right = temp1.right.right;
//                    temp1.right.left = temp1;
//                    insert(temp1, b);
//                }
//            }
//        }
        out.close();
    }

//    public static void insert(graph3 n, graph3[] heap) {
//        size++;
//        heap[size] = n;
//        int cur = size;
//        while (cur > 1 && ((heap[cur].key < heap[cur / 2].key)||(heap[cur].key==heap[cur/2].key&&heap[cur].position<heap[cur/2].position))) {
//            graph3 temp = heap[cur];
//            heap[cur] = heap[cur / 2];
//            heap[cur / 2] = temp;
//            cur = cur / 2;
//        }
//    }
//
//    public static graph3 delete(graph3[] heap) {
//        graph3 result =new graph3();
//        result = heap[1];
//
//        boolean isswap = false;
//        heap[1] = heap[size];
//        size--;
//        int cur = 1;
//        while (2 * cur < size) {
//            isswap = false;
//            if (2 * cur == size) {
//                if (heap[cur].key > heap[cur * 2].key||(heap[cur].key == heap[cur * 2].key&&heap[cur].position > heap[cur * 2].position)) {
//                    graph3 temp = heap[cur];
//                    heap[cur] = heap[cur * 2];
//                    heap[cur * 2] = temp;
//                    cur = cur * 2;
//                    isswap = true;
//                }
//            } else {
//                if (heap[2 * cur].key <= heap[2 * cur + 1].key && (heap[cur].key > heap[2 * cur].key||(heap[cur].key == heap[cur * 2].key&&heap[cur].position > heap[cur * 2].position))) {
//                    graph3 temp = heap[cur];
//                    heap[cur] = heap[cur * 2];
//                    heap[cur * 2] = temp;
//                    cur = cur * 2;
//                    isswap = true;
//                }
//                if (isswap == false && heap[2 * cur].key > heap[2 * cur + 1].key && (heap[cur].key > heap[2 * cur + 1].key||(heap[cur].key == heap[cur * 2+1].key&&heap[cur].position > heap[cur * 2+1].position))) {
//                    graph3 temp = heap[cur];
//                    heap[cur] = heap[cur * 2 + 1];
//                    heap[cur * 2 + 1] = temp;
//                    cur = cur * 2 + 1;
//                    isswap = true;
//                }
//            }
//            if (isswap == false) break;
//        }
//        return result;
//    }
}

//class graph3 {
//    graph3 left;
//    graph3 right;
//    int position;
//    boolean isdelete;
//    int key;
//}


