import java.util.*;
class Solution {
    int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[] {i, map.get(complement)};
            else
                map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
public class TwoSum{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int arr[] = {2, 4, 1, 12, 5};
        int target = 13;
        arr = solution.twoSum(arr, target);
        System.out.println(arr[0]+" "+arr[1]);
    }
}