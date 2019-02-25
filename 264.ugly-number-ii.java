import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (37.56%)
 * Total Accepted:    2.7K
 * Total Submissions: 7.1K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */
class Solution {
    public int nthUglyNumber(int num) {
        int a[] = new int[num];
        // list.add(1);
        int m1 = 0, m2 = 0, m3 = 0, i2 = 0, i3 = 0, i5 = 0, min = 0;// i记录成的次数
        a[0]=1;
        int count=1;
        while (count < num) {
            m1 = a[i2] * 2;
            m2 = a[i3] * 3;
            m3 = a[i5] * 5;
            min = Math.min(m1, Math.min(m2, m3));
            if (min == m1) {
                i2++;
            } if(min == m2) {
                i3++;
            } if(min == m3) {
                i5++;
            }
            a[count++]=min;
           
       

        }

        return a[num - 1];
    }
}
