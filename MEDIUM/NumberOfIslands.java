class Solution {
    boolean [][] grid_visited;
    char [][] input_grid;
    
    public int numIslands(char[][] grid) {
        // initialize a visited 2D array for DFS
        grid_visited = new boolean[grid.length][grid[0].length];
        input_grid = grid;
        
        // number of islands => to be returned
        int numIslands = 0;
        
        // main algorithm loop
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !grid_visited[i][j]) {
                    DFS(i, j);
                    numIslands++;
                }
            }
        }
        
        // return the number of islands
        return numIslands;
    }
    
    // run DFS
    public void DFS(int startX, int startY) {
        if (checkValidPos(startX, startY) && input_grid[startX][startY] == '1' && !grid_visited[startX][startY]) {
            grid_visited[startX][startY] = true;
            DFS(startX - 1, startY);
            DFS(startX + 1, startY);
            DFS(startX, startY - 1);
            DFS(startX, startY + 1);
        } else {
            return;
        }
    }
    
    // checking if the positions are valid matrix locations
    public boolean checkValidPos(int posX, int posY) {
        if (posX < 0 || posX >= input_grid.length) {
            return false;
        }
        
        if (posY < 0 || posY >= input_grid[0].length) {
            return false;
        }
        
        return true;
    }
}
