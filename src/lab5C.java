import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class lab5C {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        String s;
        s = in.next();
        int len = s.length();
        int [][]fsa = new int[len][26];
        for (int i = 0; i < 26; i++) {
            if (('a'+i)==s.charAt(0))
            fsa[0][i]=1;
            else
            fsa[0][i]=0;
        }
        int x=0;
        for (int j = 1; j < len; j++) {
            for (char k = 'a'; k <='z' ; k++) {
                if (s.charAt(j)==k){
                    fsa[j][k-'a']=j+1;
                }
                else{
                    fsa[j][k-'a']=fsa[x][k-'a'];
                }
            }
            x=fsa[x][s.charAt(j)-'a'];
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                out.print(fsa[i][j]+' ');
            }
            out.println("");
        }
        out.close();
    }
}

