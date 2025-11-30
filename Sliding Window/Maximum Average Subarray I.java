class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int currSum = 0;
        int maxGlobal = Integer.MIN_VALUE;

        for(int i=0;i<k;i++){
            currSum += nums[i];
        }
        maxGlobal = Math.max(maxGlobal,currSum);

        for(int i=k;i<n;i++){
            currSum = currSum + nums[i] - nums[i-k];
            maxGlobal = Math.max(maxGlobal,currSum);
        }

        return (double) maxGlobal/k;
    }
}
