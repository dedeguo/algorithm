
package leetcode.editor.cn;
//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 
// 👍 220 👎 0


//date: 2021-10-08 08:53:54

import com.alibaba.fastjson.JSON;

import java.util.*;

public class P187RepeatedDnaSequences{
    public static void main(String[] args) {
        Solution solution = new P187RepeatedDnaSequences().new Solution();
        //解答失败: 测试用例:"AAAAAAAAAAA" 测试结果:[] 期望结果:["AAAAAAAAAA"] stdout:
        String s = "AAAAAAAAAAA";
        List<String> res= solution.findRepeatedDnaSequences(s);
        System.out.println(JSON.toJSONString(res));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res=new HashSet<>();
        Map<String,Integer> hash=new HashMap<>();
        if (s.length()<10) return new ArrayList<>();
        for (int i=10;i<=s.length();i++){
            String ss=s.substring(i-10,i);
            System.out.println(ss);

           int num= hash.getOrDefault(ss,0);
           if (num>0) res.add(ss);
           hash.put(ss,num+1);
        }
        return new ArrayList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}