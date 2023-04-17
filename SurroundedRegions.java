package StriverGraph;

public class SurroundedRegions {
    public void solve(char[][] board) {
        help(board);
    }

    boolean visited[][];

    public void help(char[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];
        // 1st & last row.
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 'O')
                dfs(matrix, 0, i);
            if (matrix[matrix.length - 1][i] == 'O')
                dfs(matrix, matrix.length - 1, i);

        }

        // 1st & last col.
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 'O')
                dfs(matrix, i, 0);
            if (matrix[i][matrix[0].length - 1] == 'O')
                dfs(matrix, i, matrix[0].length - 1);

        }

        // internal matrix

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'O' && visited[i][j] == false) {
                    matrix[i][j] = 'X';
                }
            }
        }
    }

    int xdir[] = { 0, 0, 1, -1 };
    int ydir[] = { 1, -1, 0, 0 };

    private void dfs(char matrix[][], int i, int j) {
        if (visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        for (int a = 0; a < xdir.length; a++) {
            int x = xdir[a] + i;
            int y = ydir[a] + j;
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == 'O') {
                dfs(matrix, x, y);
            }
        }
    }
}