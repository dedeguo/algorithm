package leetcode.editor.cn;

import leetcode.editor.definedata.TreeNode;

public class p101SymTree {

    //Java：对称二叉树
    public boolean isSymmetricV2(TreeNode root) {
        //思路：递归遍历左右子树 进行比较
        if(root==null) return true;
        if (  root.left==null && root.right==null) return true;
        if (!(root.left!=null && root.right!=null)) return false;
        //递归遍历左右子树 进行比较
        return isSubTreeSymV2(root.left, root.right);
    }


    public boolean isSubTreeSymV2(TreeNode left , TreeNode right){
        if (left==null && right==null) return true;
        if (left==null || right==null) return false;
        if (left.val != right.val) return false;
        return isSubTreeSymV2(left.left,right.right) && isSubTreeSymV2(left.right,right.left);
    }



    //遍历左右子树
    public boolean isSymmetric(TreeNode root) {

        if(root==null) return true;
        if (  root.left==null && root.right==null) return true;
        if (!(root.left!=null && root.right!=null)) return false;

        return isSubTreeSym(root.left, root.right);
    }

    //递归遍历左右子树 进行比较
    private boolean isSubTreeSym(TreeNode left, TreeNode right){
        if (left!=null && right!=null){
            if (left.val != right.val) return false;
         return    isSubTreeSym(left.right,right.left) && isSubTreeSym(left.left,right.right);
        }else if (left==null && right==null){
            return true;
        }
        else {
            return false;
        }

    }
}
