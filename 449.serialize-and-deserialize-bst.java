/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst/description/
 *
 * algorithms
 * Medium (44.81%)
 * Total Accepted:    591
 * Total Submissions: 1.3K
 * Testcase Example:  '[2,1,3]'
 *
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 
 * 编码的字符串应尽可能紧凑。
 * 
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
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
public class Codec {
    int index=-1;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "#,";
        }
        return root.val + "," + serialize(root.left) 
            + serialize(root.right);
    }


    // public void serialize(TreeNode root,S)
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
           index++;
               int len = data.length();
                if(index >= len){
                    return null;
                }
                String[] strr = data.split(",");
                TreeNode node = null;
                if(!strr[index].equals("#")){
                    node = new TreeNode(Integer.valueOf(strr[index]));
                    node.left = deserialize(data);
                    node.right = deserialize(data);
                }
                 
                return node;
      
       
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
