class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long currWindowSum = 0;
        long globalMax = 0;

        HashSet<Integer> st = new HashSet<>();
        int i=0;
        int j=0;

        while(j<n){
            //Ensure only unique elements are present in set

            while(st.contains(nums[j])){
                st.remove(nums[i]);
                currWindowSum -= nums[i];
                i++;
            }

            st.add(nums[j]);
            currWindowSum += nums[j];

            if(j-i+1 == k){  //window size == k
               globalMax = Math.max(globalMax,currWindowSum);
               st.remove(nums[i]);
               currWindowSum -= nums[i];
               i++;
            }
            j++;
        }

        return globalMax;
    }
}
