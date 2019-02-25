/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (30.96%)
 * Total Accepted:    11K
 * Total Submissions: 35.6K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 
 * 
 */
class Solution {
    public double myPow(double base, int n) {
        // double ans = 1;
        // int p=n;
        // if(x==1){
        //     return 1;
        // }
        // if (n < 0) {
        //     p = -n;
        //     x = 1 / x;
        // } else {
        //     p = n;
        // }
        // while (p!=0) {
        //     if( (p & 1)==1)
        //         ans *= x;
        //     x *= x;
        //     p >>= 1;
        // }
        // return ans;
    double res = 1,curr = base;
    int exponent;
    if(n == Integer.MIN_VALUE){
        double result = 1.0/(powerWithUnsigned(base,Integer.MAX_VALUE) * base);
        return result;
    }

    if(n>0){
        exponent = n;
    }else if(n<0){
        if(base==0)
            throw new RuntimeException("分母不能为0"); 
        exponent = -n;
    }else{// n==0
        return 1;// 0的0次方
    }
    while(exponent!=0){
        if((exponent&1)==1)
            res*=curr;
        curr*=curr;// 翻倍
        exponent>>=1;// 右移一位
    }
    return n>=0?res:(1/res);    
    }

    double powerWithUnsigned(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        double result = powerWithUnsigned(x,n>>1);
        result *= result;
        if((n & 1) == 1){
            result *= x;
        }
        return result;
    }
}

/*首先，快速幂的目的就是做到快速求幂，假设我们要求a^b,按照朴素算法就是把a连乘b次，这样一来时间复杂度是O(b)也即是O(n)级别，快速幂能做到O(logn)，快了好多好多。它的原理如下：
  假设我们要求a^b，那么其实b是可以拆成二进制的，该二进制数第i位的权为2^(i-1)，例如当b==11　　　　　　　　　　　　　　　　　　　　　　　　   
  a11=a(2^0+2^1+2^3)
  11的二进制是1011，11 = 2³×1 + 2²×0 + 2¹×1 + 2º×1，因此，我们将a¹¹转化为算 a2^0*a2^1*a2^3，也就是a1*a2*a8 ，看出来快的多了吧原来算11次，现在算三次，但是这三项貌似不好求的样子....不急，下面会有详细解释。 
由于是二进制，很自然地想到用位运算这个强大的工具：&和>>     &运算通常用于二进制取位操作，例如一个数 & 1 的结果就是取二进制的最末位。还可以判断奇偶x&1==0为偶，x&1==1为奇。 */
