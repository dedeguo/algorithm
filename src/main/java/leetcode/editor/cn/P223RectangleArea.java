
package leetcode.editor.cn;
//在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。 
//
// 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。 
//
// 
//
// 示例: 
//
// 输入: -3, 0, 3, 4, 0, -1, 9, 2
//输出: 45 
//
// 说明: 假设矩形面积不会超出 int 的范围。 
// Related Topics 数学 
// 👍 106 👎 0


//date: 2021-03-27 09:39:14

public class P223RectangleArea{
    public static void main(String[] args) {
        Solution solution = new P223RectangleArea().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaA=(C-A)*(D-B);
        int areaB=(G-E)*(H-F);


        int xLen=calCommonLength(A,C,E,G);
        int yLen=calCommonLength(B,D,F,H);
        return areaA+areaB-xLen*yLen;
    }



    public int calCommonLength(int a1,int a2, int b1,int b2){
        int maxA=Math.max(a1,a2);
        int minA=Math.min(a1,a2);

        int maxB=Math.max(b1,b2);
        int minB=Math.min(b1,b2);

        if (maxA<=minB) return 0;
        if (maxB<=minA)  return 0;

        int newMax=Math.min(maxA,maxB);
        int newMin=Math.max(minA,minB);

        return newMax-newMin;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}