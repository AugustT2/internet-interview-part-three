package com.oneby.leetcode.cn.tulingxueyuan.tree;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-110) 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点
 * 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class BalancedBinTree_110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return depth(root) != -1;
    }
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}
