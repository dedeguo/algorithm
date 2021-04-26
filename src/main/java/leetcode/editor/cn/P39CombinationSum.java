
package leetcode.editor.cn;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1315 👎 0


//date: 2021-04-26 06:21:01

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P39CombinationSum{
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> result=new ArrayList<>();
        HashSet<String> resultStr=new HashSet<>();


        //类似硬币问题
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        travel(candidates,target,new ArrayList<>(),0);

        return result;
    }

    public void travel(int[] candidates, int target,List<Integer> temp,int tatal){

        if (tatal==target){
            //去掉重复的
            Object[] sorted=temp.toArray();
            Arrays.sort(sorted);
            String s=Arrays.toString(sorted);
            if (!resultStr.contains(s)){
                resultStr.add(s);
            }else {
                return;
            }
            List<Integer> res=new ArrayList<>(temp);
            result.add(res);
        }else if (tatal>target){
            return;
        }else {
            for (int num:candidates){
                if (num+tatal<=target){
                    temp.add(num);
                    travel(candidates,target,temp,tatal+num);
                    //temp.remove(num);
                    temp.remove(new Integer(num));
                }
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}