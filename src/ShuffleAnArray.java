import java.util.Random;
class Solution {
    int[] arr;

    public Solution(int[] nums) {
        arr = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int[] shuffledarr = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            list.add(arr[i]);
        }
        for(int i=0; i<arr.length; i++) {
            int index = random.nextInt(list.size());
            shuffledarr[i] = list.remove(index);
        }
        return shuffledarr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
