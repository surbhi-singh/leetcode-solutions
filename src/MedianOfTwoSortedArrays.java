class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i =0, j=0;
        int[] arr = new int[length1+length2];
        int min = (length1<=length2)?length1:length2;
        for(int k = 0;k<length1+length2;k++){
            if(i+1<=length1 && j+1<=length2){
                if(nums1[i]<=nums2[j]){
                    arr[k] = nums1[i];
                    i++;
                }
                else{
                    arr[k] = nums2[j];
                    j++;
                }
            }
            else if(i+1 <=length1){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k] = nums2[j];
                j++;
            }
        }
        int temp = (length1+length2)/2;
        if((length1+length2) % 2 != 0){
            return arr[temp];
        }
        else{
            double answer = (double)arr[temp-1]+arr[temp]+0.0;
            System.out.println(answer);
            return answer/2.0;
        }
    }
}