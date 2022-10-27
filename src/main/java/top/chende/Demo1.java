package top.chende;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        List list;
        Scanner in =new Scanner(System.in);
        int m=in.nextInt();
        List<Integer> nums=new ArrayList<>();
        HashSet<Integer> numkey=new HashSet<>();
        for (int i=0;i<m;i++){
            int num=in.nextInt();

            if (!numkey.contains(num)){
                nums.add(num);
                numkey.add(num);
            }

        }
        int n = in.nextInt();

        Collections.sort(nums);
        if (2*n>nums.size())
            System.out.println("-1");
        else {
            int sum=0;
            int endPos=nums.size()-1;
            System.out.println(endPos);
            for (int i=0;i<n;i++){
                sum=sum+ nums.get(i)+ nums.get(endPos-i);
            }
            System.out.println(sum);
        }

    }
}
