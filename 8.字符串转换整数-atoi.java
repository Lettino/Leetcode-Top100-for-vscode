/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        int n = str.length();
        int i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++; // 如果有空格的话就跳过
        }
        if (i == n || !((str.charAt(i) == '+') || (str.charAt(i) == '-')
                || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {
            // 如果第i个字符不是最后一个 或者该字符不是+ - 或者数字
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        if (str.charAt(i) == '-') {
            sb.append('-');
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        if (i == n || !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            return 0;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            sb.append(str.charAt(i));
            i++;
        }
     
        try {
            return Integer.valueOf(sb.toString());
        } catch (Exception e) {
            if (sb.substring(0, 1).equals("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
       
    }
}
// @lc code=end
