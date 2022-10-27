
package leetcode.editor.cn;
//假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ： 
//
// 
// perm[i] 能够被 i 整除 
// i 能够被 perm[i] 整除 
// 
//
// 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：
//第 1 个优美的排列是 [1,2]：
//    - perm[1] = 1 能被 i = 1 整除
//    - perm[2] = 2 能被 i = 2 整除
//第 2 个优美的排列是 [2,1]:
//    - perm[1] = 2 能被 i = 1 整除
//    - i = 2 能被 perm[2] = 1 整除
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 15 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 326 👎 0


//date: 2022-09-08 16:05:33

import java.util.*;

public class P526BeautifulArrangement{
    public static void main(String[] args) {
        Solution solution = new P526BeautifulArrangement().new Solution();
        // TO TEST
        int res = solution.countArrangement(2);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     int count = 0;
        //回溯法
    public int countArrangement(int n) {

        //map consist of <num,visited>
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=1;i<=n;i++){
            map.put(i,0);
        }
        backTrace(map,1,n);
        return count;
    }

    private void backTrace(Map<Integer,Integer> map, int i,int n){
       for (Integer num : map.keySet()){
           Integer v = map.get(num);
           if (v==0 && (num%i==0  || i%num==0)){
               map.put(num,1);
               if (i==n) count++;
               else {
                   backTrace(map,i+1,n);
               }
               map.put(num,0);
           }
       }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}