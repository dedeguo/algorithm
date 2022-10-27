
package leetcode.editor.cn;
//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 933 👎 0


//date: 2021-04-21 21:21:32

import java.awt.font.FontRenderContext;

public class P45JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        // TO TEST
        int[] nums={2,3,1,1,4};
       // int[] nums={0};
        System.out.println(solution.jump(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int count=0;
        int pos=0;
        while(pos<nums.length-1){
            int currentStep=nums[pos];
            int max=Integer.MIN_VALUE;
            int maxPos=0;
            // int end=Math.min(nums.length-1,pos+)
            for(int i=1;i<=currentStep ;i++){
                if (pos+i>=nums.length-1){
                    count++;
                    return count;
                }
                if (nums[pos+i]+i>max){
                    max=nums[pos+i]+i;
                    maxPos=i;
                }
            }
            count++;
            pos=pos+maxPos;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}