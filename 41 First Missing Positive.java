class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        
        if (nums.length == 1) {
            return nums[0] == 1? 2 : 1; 
        }
        
        boolean foundOne = false;
        for (int num : nums) {
           if (num == 1) {
               foundOne = true;
               break;
           } 
        }
        
        if (!foundOne) {
            return 1;
        }
        
        int replaceVal = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = replaceVal;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])-1] < 0) {
                continue;
            }
            
            nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        
        return nums.length+1;
    }
}