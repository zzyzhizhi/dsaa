import java.security.PublicKey;
import java.util.Scanner;

public class lab0四回溯 {
    static int  card[][]= new int[5][16];

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        
        int T= scanner.nextInt();
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k <= 15; k++) {
                    card[j][k]=0;
                }
            }
            String a = scanner.next();
            for (int j = 1; j < 28; j+=2) {
                if (a.charAt(j)=='w'){
                    card[0][a.charAt(j-1)-'0']++;
                }
                if (a.charAt(j)=='b'){
                    card[1][a.charAt(j-1)-'0']++;
                }
                if (a.charAt(j)=='s'){
                    card[2][a.charAt(j-1)-'0']++;
                }
                if (a.charAt(j)=='z'){
                    card[3][a.charAt(j-1)-'0']++;
                }
            }
            if (Check(0,0,0)){
                System.out.println("Blessing of Heaven");
            }
            else System.out.println("Bad luck");
        }
    }
    public static boolean Check( int kezi, int shunzi,int  quetou){
        if ((kezi+shunzi==4)&&(quetou==1)) return true;
        else{
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= 7; j++) {
                    if (card[i][j]>0&&card[i][j+1]>0&&card[i][j+2]>0){
                        shunzi++;
                        card[i][j]--;
                        card[i][j+1]--;
                        card[i][j+2]--;
                        if (Check(kezi, shunzi, quetou)) return true;
                        else{
                            card[i][j]++;
                            card[i][j+1]++;
                            card[i][j+2]++;
                            shunzi--;
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <=9; j++) {
                    if (card[i][j]>=3){
                        kezi++;
                        card[i][j]-=3;
                        if (Check(kezi,shunzi,quetou)) return true;
                        else{
                            card[i][j]+=3;
                            kezi--;
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (card[i][j]>=2){
                        quetou++;
                        card[i][j]-=2;
                        if (Check(kezi,shunzi,quetou)) return true;
                        else {
                            card[i][j]+=2;
                            quetou--;
                        }
                    }
                }
            }
        }
        return false;
    }
}
