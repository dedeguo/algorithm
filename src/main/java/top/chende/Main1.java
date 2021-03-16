package top.chende;



import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int m=in.nextInt();
      //  Set<Integer> nums=new HashSet<>();
        List<Integer> nums=new ArrayList<>();
        for (int i=0;i<m;i++){
            int num=in.nextInt();
                nums.add(num);
        }
        int n = in.nextInt();

        PriorityQueue<Integer> minHeap=new PriorityQueue<>(n);

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //最大 最小堆

        int count=0;
        for (Integer e:nums
             ) {
            if (count<n){
                minHeap.add(e);
                maxHeap.add(e);
            }else {
                int change=0;
            int minE =  minHeap.peek();
            int maxE= maxHeap.peek();
            if (e>minE){
                minHeap.poll();
                minHeap.add(e);
                change++;
            }
            if (e< maxE){
                maxHeap.poll();
                maxHeap.add(e);
                change++;
            }
            if (change==2){
                //必有相同元素
                System.out.println("-1");
                return;
            }else {
                change=0;
            }
            }
            count++;
        }
        //计算总和
        Object[] min=minHeap.toArray();
        Object[] max=maxHeap.toArray();
        int sum=0;
        for (int i=0;i<min.length;i++) {
            int mine= (int) min[i];
            int maxe= (int) max[i];
            sum = sum + mine+ maxe;
        }
        System.out.println(sum);
    }
}
