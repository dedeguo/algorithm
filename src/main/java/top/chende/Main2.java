package top.chende;

import java.util.*;

public class Main2 {

    //最小堆
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        List<Integer> works=new ArrayList<>();
        for (int i=0;i<n;i++){
            int work=in.nextInt();
            works.add(work);
        }
        Collections.sort(works);
        if (m>=n){
            System.out.println(works.get(n-1));
        }else {
            PriorityQueue<Integer> minHeap=new PriorityQueue<>(m);
            for (int i=0;i<n;i++){
                if (i< m){
                    minHeap.add(works.get(i));
                }else {
                    //取最小元素
                    int min=minHeap.poll();
                    minHeap.add(min+works.get(i));
                }
            }
            //最大值为所求
            Object[] result =minHeap.toArray();
            System.out.println(result[result.length-1]);
        }

    }
}
