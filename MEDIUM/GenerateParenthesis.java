class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> allParenthesis = new ArrayList<>();
        HashSet<String> completedCombos = new HashSet<>();
        getStrings(allParenthesis, completedCombos, "", 0, n);
        return allParenthesis;
    }
    
    private void getStrings(List<String> list, HashSet<String> combos, String curr, int toClose, int num) {
        if (num == 0) {
            if (toClose == 0) {
                if (!combos.contains(curr)) {
                    list.add(curr);
                    combos.add(curr);
                }
            } else {
                while (toClose > 0) {
                    curr += ")";
                    toClose--;
                }
                if (!combos.contains(curr)) {
                    list.add(curr);
                    combos.add(curr);
                }
            }
        } else {
            String twoPath = curr + "(";
            getStrings(list, combos, twoPath, toClose + 1, num - 1);
            
            String onePath = curr + "()";
            getStrings(list, combos, onePath, toClose, num - 1);
            while (toClose > 0) {
                toClose--;
                onePath += ")";
                getStrings(list, combos, onePath, toClose, num - 1);
            }
            
        }
    }
}
