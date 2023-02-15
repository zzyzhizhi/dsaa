public class 数组队列 {
    public static void main(String[] args) {

    }
}
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;//存放数组的数据

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//front是指向队列的前一个位子。
        rear = -1;//指向队列尾

    }
    public boolean isFull(){
        return rear == maxSize-1;
    }

    public  boolean isempty(){
        return rear==front;
    }

    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //获取队列的数据
    public int getQueue(){
        if (isempty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isempty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i,arr[i]);
        }
    }
    //显示数据的头部，不是取出数据
    private int headQueue(){
        if (isempty()){
            throw new RuntimeException("数组为空");
        }
        return arr[front+1];
    }

}
