
package leetcode.editor.cn;
//A 和 B 在一个 3 x 3 的网格上玩井字棋。 
//
// 井字棋游戏的规则如下： 
//
// 
// 玩家轮流将棋子放在空方格 (" ") 上。 
// 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。 
// "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。 
// 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。 
// 如果所有方块都放满棋子（不为空），游戏也会结束。 
// 游戏结束后，棋子无法再进行任何移动。 
// 
//
// 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各
//自的棋子位置。 
//
// 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"
//。 
//
// 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。 
//
// 
//
// 示例 1： 
//
// 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
//输出："A"
//解释："A" 获胜，他总是先走。
//"X  "    "X  "    "X  "    "X  "    "X  "
//"   " -> "   " -> " X " -> " X " -> " X "
//"   "    "O  "    "O  "    "OO "    "OOX"
// 
//
// 示例 2： 
//
// 输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
//输出："B"
//解释："B" 获胜。
//"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
//"   " -> " O " -> " O " -> " O " -> "XO " -> "XO " 
//"   "    "   "    "   "    "   "    "   "    "O  "
// 
//
// 示例 3： 
//
// 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
//输出："Draw"
//输出：由于没有办法再行动，游戏以平局结束。
//"XXO"
//"OOX"
//"XOX"
// 
//
// 示例 4： 
//
// 输入：moves = [[0,0],[1,1]]
//输出："Pending"
//解释：游戏还没有结束。
//"X  "
//" O "
//"   "
// 
//
// 
//
// 提示： 
//
// 
// 1 <= moves.length <= 9 
// moves[i].length == 2 
// 0 <= moves[i][j] <= 2 
// moves 里没有重复的元素。 
// moves 遵循井字棋的规则。 
// 
// Related Topics 数组 哈希表 矩阵 模拟 
// 👍 41 👎 0


//date: 2021-09-20 23:33:35

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

public class P1275FindWinnerOnATicTacToeGame{
    public static void main(String[] args) {
        Solution solution = new P1275FindWinnerOnATicTacToeGame().new Solution();
        // TO TEST

        // 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
//输出："Draw"


// 示例 4：
//
// 输入：moves =
//输出："Pending"

       // String s="[[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]";
        String s="[[2,2],[0,2],[1,0],[0,1],[2,0],[0,0]]";
        String s1=s.replace("[","{").replace("]","}");
     //   解答失败: 测试用例:[[0,0],[2,0],[1,1],[2,1],[2,2]]
        //   测试结果:"Pending" 期望结果:"A" stdout:

        System.out.println(s1);

    //    解答失败: 测试用例:[[2,2],[0,2],[1,0],[0,1],[2,0],[0,0]]
        //    测试结果:"Pending" 期望结果:"B" stdout:
        int[][] moves={{2,2},{0,2},{1,0},{0,1},{2,0},{0,0}};
        String res=solution.tictactoe(moves);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String tictactoe(int[][] moves) {

        if (moves.length<5) {
      //      System.out.println("Pending");
            return "Pending";
        }
        //填充，A的位置 1  B填2  判断
        int count=0;
        int[][] dashBoard=new int[3][3];

        for(int i=0;i<moves.length;i++){
            int x=moves[i][0];
            int y=moves[i][1];
          //  System.out.println("x "+x+"  y:"+y);
            int r=i%2;
        //    System.out.println("r"+r);
            if (i%2==0){

                dashBoard[x][y]=1;
            }else {
                dashBoard[x][y]=6;
            }
        }


        if (moves.length<9) {

          String s=  checkResult(dashBoard);
          if (s.equals("")) return "Pending";
          return s;
        }else {
            String s=  checkResult(dashBoard);
            if (s.equals("")) return "Draw";
            return s;
        }
    }

    public String checkResult(int[][] dashboard){

      //  System.out.println(JSON.toJSON(dashboard));
        //横竖
        for (int i=0;i<3;i++){
            int rowSum=0;
            int column=0;
            for (int j=0;j<3;j++){
                rowSum=rowSum+dashboard[i][j];
                column=column+dashboard[j][i];
            }
            if (rowSum==3 || column==3) return "A";
            if (rowSum==18 || column==18) return "B";
        }
        // 斜方向检查
        int angle1=0;
        int angle2=0;

        for (int i=0;i<3;i++){
            angle1=angle1+dashboard[i][i];
            angle2=angle2+dashboard[i][2-i];
        }
        if (angle1==3 || angle2==3) return "A";
        if (angle1==18 || angle2==18) return "B";

        return "";
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}