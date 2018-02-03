class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        else {
            int start=0, end=height.length-1, sum=0, count=0;
            while(start < end && (height[start] == 0 || height[start] <= height[start+1])) ++start;
            while(end > start && (height[end] == 0 || height[end] <= height[end-1])) --end;
            for(int i=start; i<=end; i++) {
                if(height[i] >= height[start]) {
                    count=0;
                    start = i;
                }
                else if(height[i] < height[start]) {
                    sum = sum + (height[start] - height[i]);
                    count++;
                }
            }
            if(count != 0) {
                int t = end;
                for(int i=end; i>=t-count; i--) {
                    if(height[i] >= height[end]) {
                        sum = sum - (height[start] - height[i]);
                        end = i;
                    }
                    else sum = sum - (height[start] - height[end]);
                }
            }
            return sum;
        }
    }
}
