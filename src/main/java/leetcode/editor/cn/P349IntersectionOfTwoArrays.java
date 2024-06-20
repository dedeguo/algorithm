
package leetcode.editor.cn;
//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 662 👎 0


//date: 2022-11-10 11:07:43

import com.alibaba.fastjson.JSON;

import java.awt.font.FontRenderContext;
import java.util.*;

public class P349IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        System.out.println(JSON.toJSONString(solution.intersection(nums1,nums2)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> map=new HashSet<>();
        Set<Integer> result=new HashSet<>();
        for (int num:nums1){
            map.add(num);
        }
        for (int num:nums2){
            if (map.contains(num)){
                result.add(num);
            }
        }
        int[] array=new int[result.size()];
        int count=0;
        for (Integer num:result){
            array[count++]=num;
        }

        return array;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}