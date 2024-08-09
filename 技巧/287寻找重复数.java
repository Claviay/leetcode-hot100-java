/*
快慢指针
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // 初始化 slow 和 fast 指针，slow 一次走一步，fast 一次走两步
        slow = nums[slow];
        fast = nums[nums[fast]];

        // 快慢指针循环，直到它们相遇
        while(slow != fast){
            slow = nums[slow]; // slow 每次走一步
            fast = nums[nums[fast]]; // fast 每次走两步
        }

        // 快慢指针相遇后，重置一个指针到起点，两个指针每次都走一步
        int pre1 = 0;
        int pre2 = slow;

        while(pre1 != pre2){
            pre1 = nums[pre1]; // pre1 每次走一步
            pre2 = nums[pre2]; // pre2 每次走一步
        }

        // 当两个指针再次相遇时，它们在环的起点，即重复的数字
        return pre1;
    }

    
}
