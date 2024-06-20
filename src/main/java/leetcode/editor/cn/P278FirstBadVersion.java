
package leetcode.editor.cn;
//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。 
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。 
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。 
//
// 示例 1： 
//
// 
//输入：n = 5, bad = 4
//输出：4
//解释：
//调用 isBadVersion(3) -> false 
//调用 isBadVersion(5) -> true 
//调用 isBadVersion(4) -> true
//所以，4 是第一个错误的版本。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, bad = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bad <= n <= 2³¹ - 1 
// 
//
// Related Topics 二分查找 交互 👍 817 👎 0


//date: 2022-11-07 16:12:50

public class P278FirstBadVersion{
    public static void main(String[] args) {
        Solution solution = new P278FirstBadVersion().new Solution();
        // TO TEST
        System.out.println(solution.firstBadVersion(2126753390));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class VersionControl{
       int bad=1702766719;
        public boolean isBadVersion(int n){
            System.out.println("isBadVersion(%d)"+n);
            return n>=bad;
        }
    }

    class Solution2 {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            char[]  charArray=s.toCharArray();
            for(char ch:charArray){
                if(ch==' '){
                    sb.append("%20");
                }else{
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
public class Solution extends VersionControl {
    //二分查找
    public int firstBadVersion(int n) {
        int low=1;
        int high=n;

        while (high>low && low>0 && high>0){
        //    int mid=(low+high)/2;
            int mid = low + (high - low) / 2; // 防止计算时溢出

            if (!isBadVersion(mid)){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        return low;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}