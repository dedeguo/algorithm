
package leetcode.editor.cn;
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 481 👎 0


//date: 2021-04-11 23:18:01

import java.util.ArrayList;
import java.util.List;

public class P763PartitionLabels{
    public static void main(String[] args) {
        Solution solution = new P763PartitionLabels().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //todo
    public List<Integer> partitionLabels(String S) {
        List<Integer> res=new ArrayList<>();
        int[] next=new int[26];
        for (int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            next[ch-'a']=i;
        }
        int start=0;
        int end=next[S.charAt(0)-'a'];
        for (int  i=start;i<S.length();i++){
            end=Math.max(end,next[S.charAt(i)-'a']);
            if (i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}