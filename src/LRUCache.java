class LRUCache {

    Map<Integer, Integer> cache;
    List<Integer> ageOfElements;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity, 1);
        ageOfElements = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            ageOfElements.remove(new Integer(key));
            ageOfElements.add(key);
            return cache.get(key);
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            ageOfElements.remove(new Integer(key));
            ageOfElements.add(key);
            cache.put(key, value);
        }
        else {
            if(cache.size() < capacity) {
                cache.put(key, value);
                ageOfElements.add(key);
            }
            else {
                int delKey = ageOfElements.remove(0);
                cache.remove(delKey);
                cache.put(key, value);
                ageOfElements.add(key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
