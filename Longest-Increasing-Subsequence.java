class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int pos = Collections.binarySearch(list, arr[i]);
            if(pos<0){
                pos = -(pos+1);
            }
            if(pos<list.size()){
                list.set(pos,arr[i]);
            }else{
                list.add(arr[i]);
            }
        }
        return list.size();
    }
}