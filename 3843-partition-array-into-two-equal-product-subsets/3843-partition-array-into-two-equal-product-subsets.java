class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;
        int all =  1<<n;
        for(int a=0;a<all-1;a++){
            long totalA=1;
            long totalB=1;
            for(int i=0;i<n;i++){
                if((a & (1<<i)) !=0){
                    totalA*=nums[i];
                }else{
                    totalB*=nums[i];
                }
                }
            if(totalA==target && totalB==target){
                return true;
            }
            }
        return false;
        }
        
    }
