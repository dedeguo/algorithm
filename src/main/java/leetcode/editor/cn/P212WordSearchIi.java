
package leetcode.editor.cn;
//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 354 👎 0


//date: 2021-03-23 00:48:13

import java.util.List;

public class P212WordSearchIi{
    public static void main(String[] args) {
        Solution solution = new P212WordSearchIi().new Solution();
        // TO TEST
        String[][] board={{"o","a","a","n"},{"e","t","a","e"},{"i","h","k","r"}};
        System.out.println(board[0].length);
        System.out.println(board.length);
        //,["i","f","l","v"]}
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        boolean containWords=false;

        public List<String> findWords(char[][] board, String[] words) {

            int totalY=board.length;
            if (totalY<=0) return null;
            int totalX=board[0].length;


            return null;
        }

    //回溯法
        public boolean backTrace(char[][] board,String word,int travelPos){

        if (travelPos < word.length()) {


            //上下左右，判断

        }
        return true;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}