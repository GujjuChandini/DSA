class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] arr = new int[nums1.length+nums2.length];
        int count = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[count]=nums1[i];
                i++;
            }
            else{
                arr[count]=nums2[j];
                j++;
            }
            count++;
        }
        while(i<nums1.length){
            arr[count]=nums1[i];
            i++;
            count++;
        }
        while(j<nums2.length){
            arr[count]=nums2[j];
            j++;
            count++;
        }
        double mid = 0.0;
        if(arr.length%2==0){
            int one = arr.length/2;
            int two = arr.length/2 - 1;
            mid = (arr[one]+arr[two])/2.0;
        }else{
            mid = arr[arr.length/2];
        }
        return mid;
    }
}