class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum = i + j;
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(mat[i][j]);
            }
        }
        int[] res = new int[m*n];
        int k = 0;
        for(int i=0;i<map.size();i++){
            if(i%2!=0){
                for(int j=0;j<map.get(i).size();j++){
                    res[k++] = map.get(i).get(j);
                }
            }else{
                for(int j=map.get(i).size()-1;j>=0;j--){
                    res[k++] = map.get(i).get(j);
                }
            }
        }
        return res;
    }
}