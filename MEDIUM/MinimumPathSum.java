class Solution {
    public int minPathSum(int[][] grid) {
        // dynamic programming table
        int[][] Table = new int[grid.length][grid[0].length];
        
        // base cases
        Table[0][0] = grid[0][0];
        for (int down = 1; down < grid.length; down++) {
            Table[down][0] = grid[down][0] + Table[down - 1][0];
        }
        for (int right = 1; right < grid[0].length; right++) {
            Table[0][right] = grid[0][right] + Table[0][right - 1];
        }
        
        // main dynamic programming algorithm
        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                Table[row][col] = Math.min(Table[row][col - 1], Table[row - 1][col]) + grid[row][col];
            }
        }
        
        // return optimal path length to get to bottom right of grid
        return Table[grid.length - 1][grid[0].length - 1];
    }
}
