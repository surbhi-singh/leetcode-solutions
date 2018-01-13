/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> queue;

    private void fillqueue(List<NestedInteger> nestedList) {
        if(nestedList.size() != 0) {
            for(int i=0; i<nestedList.size(); i++) {
                if(nestedList.get(i).isInteger() == true) {
                    queue.offer(nestedList.get(i).getInteger());
                }
                else {
                    List<NestedInteger> templist = nestedList.get(i).getList();
                    fillqueue(templist);
                }
            }
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        this.queue = new LinkedList<>();
        fillqueue(nestedList);
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        if(queue.isEmpty()) return false;
        else return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
