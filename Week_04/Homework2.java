

public class Homework2 {
    
}

class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int enable = nums.length - 1;
        for (int i = enable; i >= 0; i--) {
            if (nums[i] + i >= enable) {
                enable = i;
            }
        }
        return enable == 0;
    }
}