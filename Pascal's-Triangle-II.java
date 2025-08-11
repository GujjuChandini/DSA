class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            for (int j = 1; j < i; j++) {
                int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                row.add(val);
            }
            
            if (i > 0) {
                row.add(1);
            }
            res.add(row);
        }
        return res.get(rowIndex);
    }
}
