
package leetcode.editor.cn;
//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 你可以假设所有输入数组都可以得到满足题目要求的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// 0 <= nums[i] <= 5000 
// 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果 
// 
//
// 
//
// 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 数组 分治 快速选择 排序 
// 👍 438 👎 0


//date: 2022-06-28 20:17:45

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class P324WiggleSortIi{
    public static void main(String[] args) {
        Solution solution = new P324WiggleSortIi().new Solution();
        // TO TEST
        int[] nums = {1,1,2,1,2,2,1};
        //[4,5,5,6]
      //  Arrays.sort(nums);
        solution.wiggleSort(nums);
        System.out.println(JSON.toJSONString(nums));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //排序后 交换位置
    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        int lagerNum=nums.length/2;
        int smallerNum=nums.length-lagerNum;
        int[] sorted=new int[nums.length];
        int  i=0;
        int j=smallerNum;
        int pos=0;
        while (j<nums.length){
            sorted[pos++]=nums[i++];
            sorted[pos++]=nums[j++];
        }
        if (nums.length%2!=0){
            sorted[pos]=nums[i];
        }
        for (int k=0;k<nums.length;k++){
            nums[k]=sorted[k];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}