/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (65.87%)
 * Total Accepted:    9.4K
 * Total Submissions: 14.3K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * 翻转一棵二叉树。
 * 
 * 示例：
 * 
 * 输入：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * 输出：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode node=null;
        if (root ==null) {
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }else if(root.left==null&&root.right!=null){
            root.left=root.right;
            root.right=null;
            invertTree(root.left);
            return root;

        }else if(root.left!=null&&root.right==null){
            root.right=root.left;
            root.left=null;
            invertTree(root.right);
            return root;
        } else if(root.left!=null&&root.right!=null){
            node=root.left;
            root.left=root.right;
            root.right=node;
            node=null;
            invertTree(root.right);
            invertTree(root.left);
            return root;
        }
        return root;
    }
}
