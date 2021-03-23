
package leetcode.editor.cn;
//给定一个无重复元素的有序整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 num
//s 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 示例 3： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：["-1"]
// 
//
// 示例 5： 
//
// 
//输入：nums = [0]
//输出：["0"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -231 <= nums[i] <= 231 - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
// Related Topics 数组 
// 👍 151 👎 0


//date: 2021-03-19 21:43:51



import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P228SummaryRanges{
    public static void main(String[] args) {
        Solution solution = new P228SummaryRanges().new Solution();
        // TO TEST
        //int[] nums={0,1,2,4,5,7};
        int[] nums={0,2,3,4,6,8,9};
        List<String> res=solution.summaryRanges(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> result=new ArrayList<>();
        int startPos=0;
        int endPos=0;

        while (endPos<nums.length){
            if (endPos+1 < nums.length && nums[endPos]+1==nums[endPos+1]){
                endPos++;
            }else {
                if (startPos==endPos){
                    result.add(nums[startPos]+"");
                }else {
                    result.add(nums[startPos]+"->"+nums[endPos]);
                }
                startPos=endPos+1;
                endPos=startPos;
            }
        }

//        for (int i=0;i<nums.length;i++){
//            while((endPos+1)<nums.length &&  nums[endPos]+1==nums[endPos+1]){
//                endPos++;
//                System.out.println(startPos+"   "+endPos+"");
//            }
//            if (startPos==endPos){
//                result.add(nums[startPos]+"");
//            }else {
//                result.add(nums[startPos]+"->"+nums[endPos]);
//            }
//            startPos=endPos+1;
//            endPos=startPos;
//            i=endPos;
//        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}