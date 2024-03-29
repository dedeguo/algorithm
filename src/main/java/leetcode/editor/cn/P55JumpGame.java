
package leetcode.editor.cn;
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1405 👎 0


//date: 2021-10-03 21:41:01

public class P55JumpGame{
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        // TO TEST
       int[] nums = {2,3,1,1,4};
       boolean res=solution.canJump(nums);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean canJump(int[] nums) {
            int max=0;
            for (int i=0;i<nums.length;i++){
                if (max<i) return false;
                max=Math.max(max,i+nums[i]);
                if (max>=nums.length-1) return true;
            }
            return true;
        }
    public boolean canJumpVold(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        for (int i=0;i<n;i++){
            if (dp[i]!=1) return false;
            else {
                int k=nums[i];
                int pos=i+1;
                while (k>0 && pos<n){
                    dp[pos]=1;
                    pos++;
                    k--;
                }
            }
        }
        return dp[n-1]==1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}