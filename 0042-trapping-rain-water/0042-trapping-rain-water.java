class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if (n==0) return 0;
        int[] left=getLeftMaxArray(height,n);
        int[] right=getRightMaxArray(height,n);
        int sum=0;
        for(int i=0;i<n;i++){
            int h=Math.min(left[i],right[i])-height[i];
            sum+=h;
        }
        return sum;
    }
    private int[] getLeftMaxArray(int[] height,int n){
        int[] left=new int[n];
        left[0]=height[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        return left;
    }

private int[] getRightMaxArray(int[] height,int n){
        int[] right=new int[n];
        right[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        return right;
    }
}












        
    //     int[] left=new int[n];
    //     int[] right=new int[n];

    //     left[0]=height[0];
    //     right[n-1]=height[n-1];

    //     for(int i=1;i<n;i++){
    //         if(height[i]>left[i-1]){
    //             left[i]=height[i];
    //         }else
    //         left[i]=left[i-1];
    //     }
    //     for(int i=n-2;i>=0;i--){
    //        if( height[i]>right[i+1]){
    //         right[i]=height[i];
    //        }else
    //        right[i]=right[i+1];
    //     }
    //     int water=0;
    //     for(int i=0;i<n;i++){
    //         int x=Math.min(left[i],right[i]);
        
    //     water+=x-height[i];
    // }
    // return water;
//     }

// }