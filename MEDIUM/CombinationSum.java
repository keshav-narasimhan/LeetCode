class Solution {
    HashSet<ArrayList<Integer>> allCombos = new HashSet<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> sums = new ArrayList<>();
        helper(candidates, target, 0, results, sums);
        return results;
    }
    
    private void helper(int[] c, int t, int i, List<List<Integer>> CS, ArrayList<Integer> s) {
        if (t < 0 || i >= c.length) {
            return;
        } else if (t == 0) {
            if (!allCombos.contains(s)) {
                ArrayList<Integer> copy = (ArrayList<Integer>)s.clone();
                CS.add(copy);
                allCombos.add(copy);
            }
            return;
        } else {
            s.add(c[i]);
            helper(c, t - c[i], i, CS, s);
            helper(c, t - c[i], i + 1, CS, s);
            s.remove(s.size() - 1);
            helper(c, t, i + 1, CS, s);
        }
    } 
}
