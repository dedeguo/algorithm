
package leetcode.editor.cn;
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 564 👎 0


//date: 2021-04-26 06:57:38

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<Integer> temp=new ArrayList<>();
        travel(candidates,temp,target,0);
        return result;
    }

    public void travel(int[] candidates,List<Integer> temp, int target,int start){

        if (target<0) return;
        if (target==0){
            result.add(new ArrayList<>(temp));
        }else {
            for (int i=start;i<candidates.length;i++){
                if(i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
                temp.add(candidates[i]);
                travel(candidates,temp,target-candidates[i],i+1);
                temp.remove(temp.size()-1);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}