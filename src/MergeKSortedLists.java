/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        int len = lists.length;
        TreeSet<Integer> set = new TreeSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            ListNode ptr = lists[i];
            while(ptr != null){
                if(set.contains(ptr.val)){
                    if(map.containsKey(ptr.val)){
                        map.put(ptr.val, map.get(ptr.val)+1);
                    }
                    else{
                        map.put(ptr.val, 1);
                    }
                }
                set.add(ptr.val);
                ptr = ptr.next;
            }
        }
        if(set.isEmpty())
            return null;
        Iterator it = set.iterator();
        ListNode list = new ListNode(0);
        ListNode head = list;
        while(it.hasNext()){
            list.val = (int)it.next();
            if(map.containsKey(list.val)){
                int count = map.get(list.val);
                while(count-- > 0){
                    ListNode newNode = new ListNode(list.val);
                    list.next = newNode;
                    list = newNode;
                }
            }
            if(it.hasNext()){
                ListNode newNode = new ListNode(0);
                list.next = newNode;
                list = newNode;
            }
            else{
                list.next = null;
            }
        }
        return head;
    }
}
