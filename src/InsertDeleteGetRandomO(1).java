import java.util.Random;
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    int index;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        index = -1;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        else {
            map.put(val, ++index);
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int ind = map.get(val);
            int lastElement  = list.remove(index);
            if(lastElement != val) {
                list.set(ind, lastElement);
                map.put(lastElement, ind);
            }
            map.remove(val);
            index--;
            return true;
        }
        else return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int randNum = random.nextInt(index+1);
        return list.get(randNum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
