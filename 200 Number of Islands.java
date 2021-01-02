// Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands horizontally 
// or vertically. You may assume all four edges of the grid are all surrounded by water.

class Solution {
    public int numIslands(char[][] grid) {
    	int rows = grid.length;
    	int cols = grid[0].length;
    	int islands = 0;


        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (grid[i][j] == '1') {
        			dfs(i, j, grid);
        			islands++;
        		}
        	}
        }

        return islands;
    }

    public void dfs(int row, int col, char[][] grid) {
    	if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
    		return;
    	}
    	
    	grid[row][col] = '0';
    	dfs(row+1, col, grid);
    	dfs(row-1, col, grid);
    	dfs(row, col+1, grid);
    	dfs(row, col-1, grid);
    }
}