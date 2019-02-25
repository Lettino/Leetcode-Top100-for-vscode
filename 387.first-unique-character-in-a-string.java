import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (35.11%)
 * Total Accepted:    19.4K
 * Total Submissions: 55.2K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */
class Solution {
    public int firstUniqChar(String s) {
      
        char[] chars= s.toCharArray();
        Character c;
        Map<Character,Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            c=chars[i];
            if(!hashMap.containsKey(c)){
                hashMap.put(c, i);
            }else{
                hashMap.put(c, -1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            c=chars[i];
            
            if(hashMap.containsKey(c)&&hashMap.get(c)!=-1){
                return hashMap.get(c);
            }
        }


        return -1;


        
    }
}
