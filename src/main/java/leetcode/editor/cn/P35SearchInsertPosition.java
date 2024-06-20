
package leetcode.editor.cn;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 1775 👎 0


//date: 2022-11-08 10:48:09

public class P35SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        // TO TEST
        int[] nums={1,3,5,6};
        int target=7;
        System.out.println(solution.searchInsert(nums,target));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {

        //二分查找
        int low=0;
        int high=nums.length-1;
        int mid;
        while (high>=low && low>=0){
            mid=(low+high)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid]>target){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}