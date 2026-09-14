// class Solution {
//     public int rob(int[] nums) {
//        int n= nums.length;
//        if(n==1)
//        return nums[0];
//        int[] a= new int[n];
//        a[0] = nums[0];
//        a[1] = Math.max(nums[0] , nums[1]);
//        for (int i =2; i<n; i++){
//         a[i] = Math.max(a[i-1] , nums[i] + a[i-2]);
//        } 
//        return a[n-1];
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int p = 0;
        int c = 0;

        for (int x : nums) {
            int cur = Math.max(c, p + x);

            p = c;
            c = cur;
        }

        return c;
    }
}
