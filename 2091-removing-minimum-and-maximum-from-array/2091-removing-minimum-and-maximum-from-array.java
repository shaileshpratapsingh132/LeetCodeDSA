class Solution {
    public int minimumDeletions(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);
        int n = nums.length;
        int fromFront = right + 1;
        int fromBack = n - left;
        int bothSides = left + 1 + n - right;
        return Math.min(fromFront, Math.min(fromBack, bothSides));
    }
}