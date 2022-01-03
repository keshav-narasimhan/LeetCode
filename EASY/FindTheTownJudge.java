class Solution {
    public int findJudge(int n, int[][] trust) {
        // instantiate a HashSet with all numbers 1 - n
        HashSet<Integer> allNums = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            allNums.add(i);
        }
        
        // go through trust array, remove those who trust someone
        for (int i = 0; i < trust.length; i++) {
            if (allNums.contains(trust[i][0])) {
                allNums.remove(trust[i][0]);
            }
        }
        
        // if everyone trusts someone, no judge possible
        if (allNums.isEmpty()) {
            return -1;
        }
        
        // for all potential judges, ensure they meet both criteria
        int cntTrusts = 0;
        int cntNum = 0;
        int judge = 0;
        for(Integer possJudge : allNums) {
            for (int i = 0; i < trust.length; i++) {
                if (trust[i][1] == possJudge) {
                    cntTrusts++;
                }
            }
            
            if (cntTrusts == n - 1) {
                cntNum++;
                if (cntNum > 1) {
                    return -1;
                }
                judge = possJudge;
            }
            
            cntTrusts = 0;
        }
        
        // return the results
        if (cntNum == 1) {
            return judge;
        } else {
            return -1;
        }
    }
}
