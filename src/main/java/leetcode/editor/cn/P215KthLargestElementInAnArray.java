
package leetcode.editor.cn;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1318 👎 0


//date: 2021-10-07 13:44:44

import java.util.PriorityQueue;

public class P215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        //输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4

     //   [3,2,1,5,6,4] 和 k = 2
        int[] nums={3,2,1,5,6,4};
        int k=2;
        int res= solution.findKthLargest(nums,k);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);

        for (int i=0;i<k;i++){
            minHeap.offer(nums[i]);
        }
        for (int i=k;i<nums.length;i++){
         int element=   minHeap.peek();
         if (nums[i]>element){
             minHeap.poll();
             minHeap.offer(nums[i]);
         }
        }

        return minHeap.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}