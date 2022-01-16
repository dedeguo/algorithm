
package leetcode.editor.cn;
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 578 👎 0


//date: 2021-10-17 16:53:50

import java.util.*;

public class P350IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new P350IntersectionOfTwoArraysIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> rs=new ArrayList<>();

        Map<Integer,Integer> map=new HashMap<>();
        for (int num:nums1){
            int count=map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        for (int num:nums2){
            int count=map.getOrDefault(num,0);
            if (count>0 ) rs.add(num);
            map.put(num,count-1);
        }

        return  rs.stream().mapToInt(i->i).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}