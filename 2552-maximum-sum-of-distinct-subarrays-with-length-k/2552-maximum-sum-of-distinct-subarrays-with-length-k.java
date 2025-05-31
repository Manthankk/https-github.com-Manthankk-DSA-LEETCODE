class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        Set<Integer> set=new HashSet<>();
        long max=0,windowSum=0;
        int left=0;
        for(int right=0;right<arr.length;right++){
            while(set.contains(arr[right])){
                set.remove(arr[left]);
                windowSum-=arr[left];
                left++;
            }

            set.add(arr[right]);
            windowSum+=arr[right];

            if(right-left+1==k){
                max=Math.max(max,windowSum);
                set.remove(arr[left]);
                windowSum-=arr[left];
                left++;
            }

        }
        return max;
       

    }
}