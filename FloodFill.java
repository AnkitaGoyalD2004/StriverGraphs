package StriverGraph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int inicolor = image[sr][sc];
         int  ans[][] = image;
         int xdir[] = {-1,0,+1,0};
         int ydir[] = {0,+1,0,-1};
        dfs(sr,sc,ans,image,color,xdir,ydir,inicolor);
        return ans;
    }
    public void dfs(int sr, int sc,int ans[][], int[][] image, int color, int[] xdir, int[] ydir, int inicolor) {
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i =0 ; i<4;i++){
            int nrow = sr + xdir[i];
            int ncol = sc + ydir[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol] == inicolor && ans[nrow][ncol]!= color){
                dfs(nrow,ncol,ans,image,color,xdir,ydir,inicolor);
            } 
    }
    }
}

