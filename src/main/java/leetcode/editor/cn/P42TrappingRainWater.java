
package leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2383 👎 0


//date: 2021-06-02 21:39:47

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
        //[0,1,0,2,1,0,1,3,2,1,2,1]
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int res=solution.trap(height);
        System.out.println(res);

    }
    //找极大值 在算极大值之间的雨水
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        List<Integer> maxPos=getMaxPos( height);
        int sum=0;
        for (int i=0;i<maxPos.size()-1;i++){
            int pos1=maxPos.get(i);
            int pos2=maxPos.get(i+1);
            int min=Math.min(height[pos1],height[pos2]);
            System.out.println("pos1 :"+pos1+ "  pos2:"+pos2);
            for (int j=pos1+1;j<pos2;j++){
                System.out.println(min-height[j]);
                sum=sum+min-height[j];
            }
        }
        return sum;
    }
    //比左右两边都大的点称为极大值点
    public List<Integer> getMaxPos(int[] height){
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<height.length;i++){
            if (i==0 &&  i+1<height.length && height[i]>height[i+1] ){
                res.add(i);
            }else if (i-1>=0 && i+1 <=height.length-1
                    && height[i]>height[i-1] && height[i]>height[i+1]){
                res.add(i);
            }
            else if (i==height.length-1  && i-1>=0 && height[i]>height[i-1] ){
                res.add(i);
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}