package top.chende;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int count=0;
        for (int i=1;i<=n;i++){
            count+=fen(m-1,n-i,i);
        }
        System.out.println(count);

    }

   static int fen(int m,int n,int preNum){
        if (m<0 || n< 0) return  0;
        if( m==0  && n>0  || n==0 && m>0){
            return 0;
        } else if( m==0 && n==0)
            return 1;
        int count=0;
        for(int i=preNum;i<=preNum+3;i++){
            count += fen(m-1,n-i,i);
        }
        return count;
    }
}
