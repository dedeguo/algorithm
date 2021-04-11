
package leetcode.editor.cn;
//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 705 👎 0


//date: 2021-04-11 12:50:34

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P448FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        // TO TEST
    }

    class Answer{
        /**
         *
         * The idea is simple, if nums[i] != i + 1 and nums[i] != nums[nums[i] - 1],
         * then we swap nums[i] with nums[nums[i] - 1],
         * for example, nums[0] = 4 and nums[3] = 7,
         * then we swap nums[0] with nums[3].
         * So In the end the array will be sorted and if nums[i] != i + 1,
         * then i + 1 is missing.
         */
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
            List<Integer> res = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


class Solution {

        /***
         * 效率很低
         * Runtime: 6 ms, faster than 37.64% of Java online submissions for Find All Numbers Disappeared in an Array.
         * Memory Usage: 64.5 MB, less than 5.06% of Java online submissions for Find All Numbers Disappeared in an Array.
         * @param nums
         * @return
         */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n=nums.length;
        int[] fill=new int[n+1];
        Arrays.fill(fill,0);
        for (int i=0;i<n;i++){
            int num=nums[i];
            fill[num]=1;
        }
        List<Integer> res=new ArrayList<>();
        for (int i=1;i<=n;i++){
            if (fill[i]==0)
                res.add(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}