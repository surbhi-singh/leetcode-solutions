class Words {
    String word;
    int count;
    Words(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<String>();
        if(words.length == 0 || words == null || k > words.length)
            return result;
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Words> queue = new PriorityQueue<Words>(new Comparator<Words>(){
            public int compare(Words a, Words b) {
                int res = a.count-b.count;
                if(res == 0) {
                    return b.word.compareTo(a.word);
                }
                else {
                    return res;
                }
            }
        });
        for(int i=0; i<words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], 1);
            }
            else {
                map.put(words[i], map.get(words[i])+1);
            }
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            Words w = new Words(entry.getKey(), entry.getValue());
            queue.offer(w);
            if(queue.size() == k+1) {
                queue.poll();
            }
        }
        while(!queue.isEmpty()) {
            Words w = queue.poll();
            result.add(0, w.word);
        }
        return result;
    }
}
