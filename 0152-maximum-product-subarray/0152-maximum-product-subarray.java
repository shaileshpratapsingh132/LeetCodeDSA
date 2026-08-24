class Solution {
    public int maxProduct(int[] nums) {
        int max =nums[0];
        int min =nums[0];
        int answer=nums[0];
        for(int i=1; i< nums.length;i++){
            int current =nums[i];
            int newMax= Math.max(current, Math.max(max*current, min*current));
            int newMin =Math.min(current, Math.min(max*current,min*current));
            max = newMax;
            min = newMin;
            answer=Math.max(answer,max);
        }
        return answer;
    }
}