class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        if (numRows == 1) {
            rows.add(new ArrayList<>());
            rows.get(0).add(1);
            return rows;
        } 
        
        if (numRows == 2) {
            rows.add(new ArrayList<>());
            rows.add(new ArrayList<>());
            rows.get(0).add(1);
            rows.get(1).add(1);
            rows.get(1).add(1);
            return rows;
        }
        
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }
        
        rows.get(0).add(1);
        rows.get(1).add(1);
        rows.get(1).add(1);
        
        for (int i = 2; i < numRows; i++) {
            rows.get(i).add(1);
            for (int j = 1; j < rows.get(i - 1).size(); j++) {
                rows.get(i).add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
            }
            rows.get(i).add(1);
        }
        
        return rows;
    }
}
