class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1 || n == 2) {
            return 0;
        }
        else {
            int count=0;
            int[] nums = new int[n+1];
            Boolean[] visited = new Boolean[n+1];
            for(int i=2; i<=n; i++) {
                nums[i] = i;
                visited[i] = false;
            }
            for(int i=2; i<n; i++) {
                if(visited[i] == false) {
                    count++;
                    //System.out.println(i);
                    int j = 2*i;
                    while(j<=n) {
                        visited[j] = true;
                        j = j + i;
                    }
                }
            }
            return count;
        }
    }
}
