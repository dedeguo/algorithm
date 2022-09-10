package leetcode.editor.topfeq;

/**
 * 剑指offer 热题
 *
 * this is <img src="../../../../"></img>
 *
 */
public class Leet14 {

    public static void main(String[] args) {

        int a=Integer.MAX_VALUE;
        int b=Integer.MIN_VALUE;
    }
    public String longestCommonPrefix(String[] strs) {

        if (strs==null || strs.length==0) return "";
        if (strs.length==1) return strs[0];
        int minLen=strs[0].length();
        for (int i=0;i<strs.length;i++){
            minLen=Math.min(minLen,strs[i].length());
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<minLen;i++){
            char ch=strs[0].charAt(i);
            for (int j=1;j<strs.length;j++){
                if (ch!=strs[j].charAt(i)) return sb.toString();
            }
            sb.append(ch);

        }
        return sb.toString();
    }

}
