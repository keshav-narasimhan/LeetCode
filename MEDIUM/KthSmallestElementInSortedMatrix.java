class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        PriorityQueue<IntegerCompare> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(new IntegerCompare(matrix[i][0], i, 0));
        }
        
        for (int i = 1; i < k; i++) {
            IntegerCompare curr = q.poll();
            if (curr.index + 1 < n) {
                q.add(new IntegerCompare(matrix[curr.row][curr.index + 1], curr.row, curr.index + 1));
            }
        }
        
        return q.poll().val;
    }
}

class IntegerCompare implements Comparable<IntegerCompare> {
    public int val;
    public int row;
    public int index;
    
    public IntegerCompare(int val, int row, int index) {
        this.val = val;
        this.row = row;
        this.index = index;
    }
    
    @Override
    public int compareTo(IntegerCompare other) {
        if (this.val > other.val) {
            return 1;
        } else {
            return -1;
        }
    }
}
