class Solution {

    public int findTotalWays(int[] nums, int i, int sum, int target) {

        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int add = findTotalWays(nums, i + 1, sum + nums[i], target);

        int subtract = findTotalWays(nums, i + 1, sum - nums[i], target);

        return add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findTotalWays(nums, 0, 0, target);
    }
}