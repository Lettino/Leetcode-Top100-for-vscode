/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (37.25%)
 * Total Accepted:    5.7K
 * Total Submissions: 15.3K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode pHead) {
        if(pHead==null){
            return null;
        }
    ListNode currentHead=pHead.next;//当前节点
    ListNode preHead=pHead;//上一个节点
    ListNode prepreHead=pHead;//上上个节点
    boolean isRepeat=false;
    while(currentHead!=null){
        
        if(preHead==pHead)//如果pre是头节点
        {
            
           if(preHead.val==currentHead.val){
            //如果节点相同 则删除重复的
            preHead.next=currentHead.next;
            currentHead=currentHead.next;
            isRepeat=true;
            
        }else{//如果节点不同
            if(isRepeat){
                //如果之前是重复的 把当前节点删除
                isRepeat=false;
                 preHead=currentHead;
                prepreHead=preHead;
                currentHead=currentHead.next;
                pHead=preHead;
            }else{
                
                 preHead=currentHead;
                prepreHead.next=preHead;
                currentHead=currentHead.next;
                
            }
           
        }
            
            
            
            
        }else{//如果pre不是头节点
            
            if(preHead.val==currentHead.val){
            //如果节点相同 则删除重复的
            preHead.next=currentHead.next;
            currentHead=currentHead.next;
            isRepeat=true;
            prepreHead.next=preHead;
        }else{//如果节点不同
            if(isRepeat){
                //如果之前是重复的 把当前节点删除
                isRepeat=false;
                 preHead=currentHead;
                prepreHead.next=preHead;
                currentHead=currentHead.next;
                
            }else{
                prepreHead=preHead;
                 preHead=currentHead;
                currentHead=currentHead.next;
                
            }
           
        }
            
        }
      
    }
    if(pHead==preHead&&isRepeat==true){
            return null;
        }
    if(pHead!=preHead&&isRepeat==true){
            prepreHead.next=null;
        return pHead;
        }
    
    return pHead;
    }
}
