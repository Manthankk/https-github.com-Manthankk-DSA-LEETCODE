class Solution {
        public void nextPermutation(int[] nums) {
    // Step1: Find the first decreasing element from the end
    int i = nums.length - 2; // Start from the second last element
    // Move left while the current element is greater or equal to the next
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--; // Decrement i
    }
    // If such an element exists (not the entire array is descending)
    if (i >= 0) {
        // Step 2: Find the next larger element to swap with from the right
        int j = nums.length - 1; // Start from the end
        // Find the first element greater than nums[i]
        while (nums[j] <= nums[i]) {
            j--; // Decrement j
        }
        // Swap nums[i] and nums[j]
        swap(nums, i, j); // Swap to make the permutation larger
    }
    // Step 3: Reverse the subarray from i+1 till the end to get the next permutation
    reverse(nums, i +1, nums.length - 1); // This ensures minimal increment
}

// Helper function to swap two elements in the array
private void swap(int[] nums, int i, int j) {
    int temp = nums[i]; // Store nums[i] in temp
    nums[i] = nums[j]; // Assign nums[j] to nums[i]
    nums[j] = temp; // Assign temp to nums[j]
}

// Helper function to reverse a subarray in place
private void reverse(int[] nums, int start, int end) {
    // Reverse elements between start and end
    while (start < end) {
        swap(nums, start, end); // Swap start and end
        start++; // Move start right
        end--; // Move end left
    }
}

    
}