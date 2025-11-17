package com.oneby.leetcode.cn.tulingxueyuan.tree;

/**
 * @author ：Mark老师
 * @description ：树结点的定义
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val)
     { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
