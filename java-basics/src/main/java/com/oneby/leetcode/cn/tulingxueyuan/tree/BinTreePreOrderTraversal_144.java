package com.oneby.leetcode.cn.tulingxueyuan.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-94) 二叉树的前序遍历
 */
public class BinTreePreOrderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        accessTree(root, res);
        return res;
    }

    public void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        accessTree(root.left, res);
        accessTree(root.right, res);
    }

    public List<Integer> preorderTraversalWithLoop(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //res.add(root.val); 前序遍历中对根结点的访问
            root = root.right;
        }
        return res;
    }


}
