
package leetcode.editor.cn;
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 962 👎 0


//date: 2021-04-18 13:48:52

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P239SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] res = solution.maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(res));
        LinkedList list;
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int elementNum=nums.length-k+1;
        int[] res=new int[elementNum];
        int resCount=0;

        PriorityQueue priorityQueue=new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
//            @Override
//            public boolean equals(Object obj) {
//                if (obj instanceof Integer){
//
//                    compare(this,obj);
//                }
//                return false;
//            }
        });
        for (int i=0;i<k;i++){
            priorityQueue.add(nums[i]);
        }

        res[resCount]=(Integer) priorityQueue.element();
        for (int j=k;j<nums.length;j++){
            //移除窗口第一个元素 后面加一个元素
            priorityQueue.remove(nums[j-k]);
            priorityQueue.add(nums[j]);
           // System.out.println(Arrays.toString(priorityQueue.toArray()));
           // priorityQueue.
            resCount++;
            res[resCount]=(Integer) priorityQueue.element();
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}