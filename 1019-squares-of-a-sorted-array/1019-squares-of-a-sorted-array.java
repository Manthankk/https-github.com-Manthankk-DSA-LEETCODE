class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result=new int[nums.length];
        int left=0,right=nums.length-1;
        int pos=nums.length-1;
        while(left<=right){
            int leftsq=nums[left]*nums[left];
            int rightsq=nums[right]*nums[right];
            if(leftsq>rightsq)
                result[pos--]=leftsq;
                else
                result[pos--]=rightsq;

            if(leftsq>rightsq)left++;
            else right--;

        }
        return result;
    }
}