public class lab3一列表使用 {
    public static void main(String[] args) {
        node2 a = new node2();
        a.val=1;
        node2 b = new node2();
        b.val=2;
        a.next = b;
        //b=null 无用；
        a.next.val=3;
        node2 c = new node2();
        c.next =a.next;
        a.next =c;
        c=null;
        //要将c删除
        a.next = a.next.next;
    }
}

class node2{
    int val;
    node2 next;
    node2 prev;//双向指针
    //单向和双向插入删除的操作有不同。

}
