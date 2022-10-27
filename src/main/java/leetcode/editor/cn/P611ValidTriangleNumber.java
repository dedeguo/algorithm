
package leetcode.editor.cn;
//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 194 👎 0


//date: 2021-08-04 07:57:19

import java.util.Arrays;

public class P611ValidTriangleNumber{
    public static void main(String[] args) {
        Solution solution = new P611ValidTriangleNumber().new Solution();
        // TO TEST ; {0,1,1,1}
        int[] nums={7,0,0,0};
        int res=solution.triangleNumber(nums);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int count=0;
            for (int i=0;i<nums.length-2;i++){
                if ( nums[i]<=0) continue;
                int k=i+2;
                for (int j=i+1;j<nums.length-1;j++){
                    while (k<nums.length && nums[i]+nums[j]>nums[k]  ){
                        k++;
                    }
                    count+=k-j-1;
                }
            }
            return count;
        }
        /**
         * 暴力枚举法,超时
         * @param nums
         * @return
         */
    public int triangleNumberV1(int[] nums) {

        int total=0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                for (int k=0;k<nums.length;k++){
                    if (i!=j && j!=k && i!=k){
                        if (canBeTriangel(nums[i],nums[j],nums[k]))
                            total++;
                    }
                }
            }
        }
        return total/6;
    }
    //判断三个数是否能组成三角形
        public boolean canBeTriangel(int a,int b,int c){
            if ((a+b)>c&&(a+c)>b&&(b+c)>a)
                return true;
            return false;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}