
package leetcode.editor.cn;
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1090 👎 0


//date: 2021-06-01 06:47:37

public class P41FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new P41FirstMissingPositive().new Solution();
        // TO TEST
        //[-3,9,16,4,5,16,-4,9,26,2,1,19,-1,25,7,22,2,-7,14,2,5,-6,1,17,3,24,-4,17,15]
        int[] nums={-3,9,16,4,5,16,-4,9,26,2,1,19,-1,25,7,22,2,-7,14,2,5,-6,1,17,3,24,-4,17,15};

        //[7,8,9,11,12]
        int[] nums2={7,8,9,11,12};
        int res=solution.firstMissingPositive(nums2);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {

        int len=nums.length;
        for (int i=0;i<nums.length;i++){
            while( nums[i]<len  && nums[i]>0 && nums[i]!= i+1 &&  nums[ nums[i]-1]!=nums[i] ){
                int temp=   nums[ nums[i]-1];
                nums[ nums[i]-1]= nums[i];
                nums[i]=temp;
            }
        }

        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1 ){
               return i+1;
            }
        }

        return len+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//solution 类似于投票机制 
}