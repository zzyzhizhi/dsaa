import java.util.Scanner;

public class lab1四二分答案进阶 {
    public  static long N,Xr1,Yr1,Xr,Yr,Xc,Yc;
    public static String a;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         Xr = scanner.nextInt();
         Yr = scanner.nextInt();
         Xc = scanner.nextInt();
         Yc = scanner.nextInt();
         N = scanner.nextInt();
         a = scanner.next();
         long result = Search(0,(long)Math.pow(10,14)+1);
         System.out.println(result);
        }
        public static boolean Check(long mid){
        long x = mid /N;
        long y = mid % N;
            Xr1 = Xr;
            Yr1 = Yr;
        for (int j = 0; j < N; j++) {
            if (a.charAt(j)=='R') Xr1 = Xr1 +1;
            if (a.charAt(j)=='L') Xr1 = Xr1 -1;
            if (a.charAt(j)=='U') Yr1 = Yr1 +1;
            if (a.charAt(j)=='D') Yr1 = Yr1 -1;
        }
            long zy = Xr1 - Xr;
            long sx = Yr1 - Yr;
            Xr1 = Xr + x*zy;
            Yr1 = Yr + x*sx;
            for (int j = 0; j < y; j++) {
                if (a.charAt(j)=='R') Xr1 = Xr1 +1;
                if (a.charAt(j)=='L') Xr1 = Xr1 -1;
                if (a.charAt(j)=='U') Yr1 = Yr1 +1;
                if (a.charAt(j)=='D') Yr1 = Yr1 -1;
            }
            long juli = Math.abs(Xr1 - Xc) + Math.abs(Yr1 - Yc);
            if (juli<=mid) return true;
            else return false;
        }
        public static long Search(long l,long r){
        long R = r;
        while(l<=r){
            long mid = (l+r)/2;
            if (Check(mid)) {
                r=mid-1;
            }
            else {
                l = mid+1;
            }
        }
        if (l>=R) return -1;
        else return l;
        }
    }

