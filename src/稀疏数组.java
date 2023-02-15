public class 稀疏数组 {
    public static void main(String[] args) {
        /*
        二维数组转稀疏数组
        1、遍历 原始的二维数组，得到有效数据的个数sum
        2、根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
        3、将二维数组的有效数据存入到稀疏数组

        比如：   row   col    val
            0    11    11     2  (共有11行11列，共有两个数）
            1    1     2      1  （每个数的坐标）
            2    2     3      2

        稀疏数组转二维数组
        1、先读取稀疏数组的第一行，创建原始的二维数组，比如上面就是chessArr2=int[11][11];
        2、在读取稀疏数组后几行的数据，并赋给原始的二维数组上即可。

         */
        int chessArr1[][]= new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        for (int[] row : chessArr1
             ) {
            for (int data: row
                 ) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        int sparseArr[][]= new int[sum+3][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        int count= 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("得到的稀疏数组为：  ");
        for (int i = 0; i < sum+1; i++) {
            System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
        }
        System.out.println();

        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sum+1; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] row: chessArr2
             ) {
            for (int data: row
                 ) {
                System.out.printf("%d\t" , data);
            }
            System.out.println();
        }

    }
}
