package com.oneby.leetcode.cn.tulingxueyuan.tree;

import java.util.*;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-94) 二叉树的后序遍历
 */
public class BinTreePostOrderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        accessTree(root, res);
        return res;
    }

    public void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        accessTree(root.left, res);
        accessTree(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversalWithLoop(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prevAccess = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prevAccess) {
                res.add(root.val);
                prevAccess = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /*双栈实现*/
    public List<Integer> postorderTraversalTwoStack(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> markStack = new Stack<>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            while(!markStack.isEmpty()&&markStack.peek()==stack.peek()){
                markStack.pop();
                res.add(stack.pop().val);
            }
            if(!stack.isEmpty()){
                node = stack.peek();
                markStack.push(node);
                node = node.right;
            }
        }
        return res;
    }


}
