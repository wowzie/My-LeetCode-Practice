class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + dfs(grid, row-1, col) + dfs(grid, row+1, col) + dfs(grid, row, col-1) + dfs(grid, row, col+1);
        }
        
        return 0;
    }
}

/**
Key Insights

Use dfs to find area. Simple DFS. 
Tricky calculating area, check notes below: 

    public int dfs(int[][] grid, int row, int col, int count, boolean[][] visited) { 
        if (//conditions to return false/0) { 
            return 0; 
        } 

        visited[row][col] = true; 

        int up = dfs(grid, row-1, col, count, visited); 
        int down = dfs(grid, row+1, col, count, visited); 
        int left = dfs(grid, row, col-1, count, visited); 
        int right = dfs(grid, row, col+1, count, visited); 

        if (grid[row][col] == 1) { 
            return 1 + up + down + left + right; 
        } else 
            return up + down + left + right; 
    }

This code^ above is logically identical to the one coded in the solution.
Intuition:
    -> if current cell is a '0', return back.
    -> if current cell is a '1', increase the area by one and do a recursive call in all 4 directions.
    -> ultimately return the final sum.

*/