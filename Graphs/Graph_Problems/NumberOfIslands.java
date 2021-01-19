public class NumberOfIslands{

	public static void main(String[] args){



	}

	public static int numIsland(char[][] grid){

		if(grid.length == 0)
			return 0;

		int islands = 0;

		for(int row = 0; row < grid.length; row++){

			for(int col = 0; col < grid.length; col++){

				if(grid[row][col] == '1')
					islands += dfs(grid, row, col);

			}

		}

		return islands;

	}

	private static int dfs(char[][] grid, int row, int col){

		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
			return 0;

		grid[row][col] = '0';
		dfs(grid,row+1,col);
		dfs(grid,row,col+1);
		dfs(grid,row-1,col);
		dfs(grid,row,col-1);

		return 1;

	}

}