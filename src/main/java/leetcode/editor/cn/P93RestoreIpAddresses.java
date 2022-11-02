
package leetcode.editor.cn;
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1061 👎 0


//date: 2022-11-02 10:31:46

import java.util.ArrayList;
import java.util.List;

public class P93RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // TO TEST
        String s="0000";
        System.out.println(solution.restoreIpAddresses(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<String> result=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        List<Integer> resultLen=new ArrayList<>();
        backtrace(s,resultLen,0);
        return result;
    }

    void backtrace(String s,List<Integer> resultLen,int depth){
        int sum = resultLen.stream().mapToInt(x->x.intValue()).sum();
        if (sum>s.length()) return;
        if (resultLen.size()==4 ){
            // add to result
            StringBuilder sb=new StringBuilder();
           if (sum==s.length()){
               int tempSum=0;
               for (Integer len:resultLen){
                   sb.append(s, tempSum, tempSum+len);
                   tempSum=tempSum+len;
                   if (tempSum!=s.length()){
                       sb.append(".");
                   }
               }
               result.add(sb.toString());
           }
        }else {
            if (sum<s.length() && s.charAt(sum) == '0') {
                resultLen.add(1);
                backtrace(s,resultLen,depth+1);
                resultLen.remove(resultLen.size()-1);
            }else {
                for (int i=1;i<=3;i++){
                    if (sum+i<=s.length()){
                        String num=s.substring(sum,sum+i);
                        int numValue= Integer.parseInt(num);
                        if (numValue<=255){
                            resultLen.add(i);
                            backtrace(s,resultLen,depth+1);
                            resultLen.remove(resultLen.size()-1);
                        }
                    }
                }
            }

        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}