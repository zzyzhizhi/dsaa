public class test {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        testnode a = new testnode();
        testnode b =new testnode();
        a = b;
        a.key = 2;
        a.isvisit =true;
        out.println(b.key);
        out.println(b.isvisit);
        out.close();
    }
}
class testnode{
    int key;
    boolean isvisit;
}
