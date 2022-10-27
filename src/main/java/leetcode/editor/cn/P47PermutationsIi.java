
package leetcode.editor.cn;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 821 👎 0


//date: 2021-10-03 22:32:55

import com.alibaba.fastjson.JSON;

import java.util.*;

public class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
        //输入：nums = [1,1,2]
//输出：
     //   解答失败: 测试用例:[2,2,1,1]
        //   测试结果:[[2,2,1,1],[2,1,2,1],[2,1,1,2],[1,2,2,1],[1,1,2,2]]
        //           [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,2,1,1]]
        //   期望结果:[[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]] stdout:
        int[] nums={2,2,1,1};
        List<Integer> rr=new ArrayList<>();
        rr.add(2);
        rr.add(2);
        rr.add(1);
        rr.add(1);
        rr.remove(new Integer(2));
        System.out.println(JSON.toJSONString(rr));

        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(JSON.toJSONString(res));
    }

    class SolutionV2{
        public List<List<Integer>> permuteUnique(int[] nums) {

            return null;
        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> result=new ArrayList<>();

        Set<String> set=new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        int[] visited=new  int[n];
        Arrays.fill(visited,0);
        Arrays.sort(nums);
        travel(nums,visited,new ArrayList<>());
        return result;
    }

    public String resultToString(List<Integer> res){
        StringBuilder sb=new StringBuilder();
        for (Integer i:res){
            sb.append(i).append('#');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public boolean isSame(List<Integer> res){

        return set.contains(resultToString(res));
    }
        public void travel(int[] nums , int[] visited, List<Integer> res){
            if (res.size()==nums.length) {
                //判断重复
//                System.out.println(JSON.toJSONString(res));
                if (!isSame(res)){
                    List<Integer> temp=new ArrayList<>(res);
                    result.add(temp);
                    set.add(resultToString(temp));
                }else {
//                    System.out.println("res:"+JSON.toJSONString(res));
//                    System.out.println("set:"+JSON.toJSONString(set));
                }
            }else {
                for (int i=0;i<nums.length;i++){
                    if (visited[i]==0){
                        visited[i]=1;
                        res.add(nums[i]);
                        travel(nums,visited,res);
                        res.remove(res.size()-1);
                        visited[i]=0;
                    }
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}