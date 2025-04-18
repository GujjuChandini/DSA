class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        int k = nums.length - 1;
        for (int j = 1; j < nums.length - 1; j++) {
            int maxleft = maximum(0, j - 1, nums);
            int maxright = maximum(j + 1, k, nums);
            long sum = (long)(maxleft - nums[j]) * maxright;
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maximum(int i, int j, int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            ans = Math.max(nums[k], ans);
        }
        return ans;
    }
}
