import java.util.Scanner;

public class lab0二 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Dealer = scanner.next();
        String Dealer1 = Dealer.substring(0,1);
        String Dealer2 = Dealer.substring(1,2);
        String Paul1 = scanner.next();
        String Paul2 = scanner.next();
        String Paul3 = scanner.next();
        String Paul4 = scanner.next();
        String Paul5 = scanner.next();
        String Paul11 = Paul1.substring(0,1);
        String Paul12 = Paul1.substring(1,2);
        String Paul21 = Paul2.substring(0,1);
        String Paul22 = Paul2.substring(1,2);
        String Paul31 = Paul3.substring(0,1);
        String Paul32 = Paul3.substring(1,2);
        String Paul41 = Paul4.substring(0,1);
        String Paul42 = Paul4.substring(1,2);
        String Paul51 = Paul5.substring(0,1);
        String Paul52 = Paul5.substring(1,2);
        if((Dealer1.equals(Paul11))||(Dealer1.equals(Paul21))||(Dealer1.equals(Paul31))||(Dealer1.equals(Paul41))||(Dealer1.equals(Paul51))||(Dealer2.equals(Paul12))||(Dealer2.equals(Paul22))||(Dealer2.equals(Paul32))||(Dealer2.equals(Paul42))||((Dealer2.equals(Paul52)))){

            System.out.println("All in");
        }
        else{
            System.out.println("Fold");
        }
    }

}

