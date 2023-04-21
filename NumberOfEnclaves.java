package StriverGraph;

public class NumberOfEnclaves {

    static boolean visited[][];

    public int numEnclaves(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1 && visited[i][0] == false) {
                dfs(grid, i, 0);
            }
        }
        // traversing the bottom
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[grid.length - 1][j] == 1 && visited[grid.length - 1][j] == false) {
                dfs(grid, grid.length - 1, j);
            }
        }
        // traversing the right
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid[0].length - 1] == 1 && visited[i][grid[0].length - 1] == false) {
                dfs(grid, i, grid[0].length - 1);
            }
        }
        // traversing the top
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1 && visited[0][j] == false) {
                dfs(grid, 0, j);
            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false && grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    int row[] = { 0, 0, 1, -1 };
    int col[] = { 1, -1, 0, 0 };

    private void dfs(int matrix[][], int i, int j) {
        if (visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        for (int a = 0; a < row.length; a++) {
            int x = row[a] + i;
            int y = col[a] + j;
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == 1) {
                dfs(matrix, x, y);
            }
        }
    }
}