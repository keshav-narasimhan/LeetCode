class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int r = 0; r < board.length; r++) {
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] != '.') {
                    int a = Integer.valueOf(board[r][c]) - 48;
                    if (count.containsKey(a)) {
                        return false;
                    } else {
                        count.put(a, 1);
                    }
                }
                
                if (r % 3 == 0 && c % 3 == 0) {
                    boolean box = checkBox(board, r, c);
                    if (!box) {
                        return false;
                    }
                }
            }
        }
        
        for (int c = 0; c < board[0].length; c++) {
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int r = 0; r < board.length; r++) {
                if (board[r][c] != '.') {
                    int a = Integer.valueOf(board[r][c]) - 48;
                    if (count.containsKey(a)) {
                        return false;
                    } else {
                        count.put(a, 1);
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean checkBox(char[][] board, int r, int c) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] != '.') {
                    int a = Integer.valueOf(board[i][j]) - 48;
                    if (count.containsKey(a)) {
                        return false;
                    } else {
                        count.put(a, 1);
                    }
                }
            }
        }
        
        return true;
    }
}
