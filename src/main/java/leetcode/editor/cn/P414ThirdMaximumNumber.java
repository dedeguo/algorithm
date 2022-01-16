
package leetcode.editor.cn;
//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组 排序 
// 👍 281 👎 0


//date: 2021-10-06 15:16:03

import java.util.*;

public class P414ThirdMaximumNumber{
    public static void main(String[] args) {
        Solution solution = new P414ThirdMaximumNumber().new Solution();
        int[] nums={ 2, 3, 1};
        // TO TEST
        int res=solution.thirdMax(nums);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        //维护3个数的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(3);

        //todo 去除重复的元素
        Set<Integer> data=new HashSet<>();
        for (int i=0;i<3;i++){
            if (!data.contains(nums[i])){
                minHeap.offer(nums[i]);
                data.add(nums[i]);
            }

        }
        for (int i=3;i<nums.length;i++){
            int head=minHeap.peek();
            if (!data.contains(nums[i])){
                data.add(nums[i]);
                if (minHeap.size()<3){
                    minHeap.offer(nums[i]);
                }else {
                    if (nums[i]>head){
                        minHeap.poll();
                        minHeap.offer(nums[i]);
                    }
                }

            }
        }
        if (minHeap.size()==3) {
          //  System.out.println("dfsfds");
            return minHeap.peek();
        }
        else {
           int max=Integer.MIN_VALUE;
           while (minHeap.peek()!=null){
               max=Math.max(max,minHeap.poll());
           }
            return max;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}