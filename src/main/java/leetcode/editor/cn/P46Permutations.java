
package leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1573 👎 0


//date: 2021-10-03 22:32:53

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
        //输入：nums = [0,1]
//输出：[[0,1],[1,0]]

        int[] nums={1};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(JSON.toJSON(result));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        int n=nums.length;
        int[] visited=new  int[n];
        travel(nums,visited,new ArrayList<>());
        return result;
    }

    public void travel(int[] nums , int[] visited, List<Integer> res){
        if (res.size()==nums.length) {
            List<Integer> temp=new ArrayList<>(res);
            result.add(temp);
        }else {
            for (int i=0;i<nums.length;i++){
                if (visited[i]==0){
                    visited[i]=1;
                    res.add(nums[i]);
                    travel(nums,visited,res);
                    res.remove(new Integer(nums[i]));
                    visited[i]=0;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}