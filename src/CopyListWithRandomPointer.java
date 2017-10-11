/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode ptr = new RandomListNode(head.label);
        RandomListNode newhead = ptr;
        HashMap<Integer, RandomListNode> map = new HashMap<>();
        map.put(ptr.label, ptr);
        while(head != null){
            if(head.random == null)
                ptr.random = null;
            else if(map.containsKey(head.random.label)){
                RandomListNode randomNode = map.get(head.random.label);
                ptr.random = randomNode;
            }
            else{
                RandomListNode newNode = new RandomListNode(head.random.label);
                map.put(head.random.label, newNode);
                ptr.random = newNode;
            }
            if(head.next == null)
                ptr.next = null;
            else if(map.containsKey(head.next.label)){
                RandomListNode nextNode = map.get(head.next.label);
                ptr.next = nextNode;
                ptr = nextNode;
            }
            else{
                RandomListNode newNode = new RandomListNode(head.next.label);
                ptr.next = newNode;
                map.put(newNode.label, newNode);
                ptr = newNode;
            }
            head = head.next;
        }
        return newhead;

        /* METHOD 1: NAIVE SOLUTION O(n square)
        HashMap<RandomListNode, Integer> map = new HashMap<>();
        if(head == null)
            return null;
        RandomListNode ptr = new RandomListNode(0);
        RandomListNode newhead = ptr;
        while(head != null){
            ptr.label = head.label;
            if(head.random == null)
                map.put(ptr, null);
            else
                map.put(ptr, head.random.label);
            if(head.next != null){
                RandomListNode newNode = new RandomListNode(0);
                ptr.next = newNode;
                ptr = newNode;
            }
            else{
                ptr.next = null;
            }
            head = head.next;
        }
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            RandomListNode temp = newhead;
            ptr = (RandomListNode)pair.getKey();
            if(pair.getValue() == null){
                ptr.random = null;
                continue;
            }
            int val = (int)pair.getValue();
            while(temp != null){
                if(temp.label == val){
                    ptr.random = temp;
                    break;
                }
                temp = temp.next;
            }
        }
        return newhead;
        */
    }
}
