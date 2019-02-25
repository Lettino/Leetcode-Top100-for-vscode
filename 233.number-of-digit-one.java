/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字1的个数
 *
 * https://leetcode-cn.com/problems/number-of-digit-one/description/
 *
 * algorithms
 * Hard (24.28%)
 * Total Accepted:    961
 * Total Submissions: 4K
 * Testcase Example:  '13'
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 
 * 示例:
 * 
 * 输入: 13
 * 输出: 6 
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * 
 */
class Solution {
    public int countDigitOne(int n) {
        
            int ones = 0;
              for (long m = 1; m <= n; m *= 10)
                  ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
              return ones;
         
    }
}
