class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> m=new LinkedHashMap<>();
        int[] res=new int[2];
        int i,num;
        for(i=0;i<nums.length;i++){
           
    
          if(  m.containsKey(target-nums[i]) ){
            num=m.get(target-nums[i]);
           
                res[0]=num;
                res[1]=i;
                return res;
            
            }
             m.put(nums[i],i);
        }
        return res;
    }
}