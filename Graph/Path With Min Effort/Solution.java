class Solution {
    static int minEffort;
    static boolean pathFOund;
    static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}}; // up, down, right, left
    public int minimumEffortPath(int[][] heights) {
        int max=-1, ans=-1;
        int n=heights.length-1;
        int m= heights[0].length-1;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                max=Math.max(max, heights[i][j]);
            }
        }
        minEffort=Integer.MAX_VALUE;
        
        int s=0, e=max;
        while(s<=e){
            int mid=(s+e)/2;
            boolean flag = dfs(0, 0, n, m, heights, new boolean[n+1][m+1], mid);
            if(flag){
                ans = mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
     }
    public boolean dfs(int sr, int sc, int dr, int dc, int[][] heights, boolean[][] vis, int maxDiff){
         if(sr==dr && sc==dc){
             return true;
         }
        vis[sr][sc]=true;
        for(int i=0; i<dir.length; i++){
            int x=sr+dir[i][0];
            int y=sc+dir[i][1];
            if(x>dr || x<0 || y>dc || y<0 || vis[x][y] ) continue;
            int newEffort = (Math.abs(heights[sr][sc]-heights[x][y])) ;
            if(newEffort<=maxDiff){
                boolean ans = dfs(x, y, dr, dc, heights, vis, maxDiff);
                if(ans) return ans;
            } 
        }
        return false;
    }
    /* 
    ----> beow approaches were tried earlier, but didnt lead to success case. so had to read discussion sectiona and implement 
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int absDiff;
        Pair(int r, int c, int abs){
            this.row=r;
            this.col=c;
            this.absDiff=abs;
        }
        public int compareTo(Pair o){
            return this.row-o.row;
        }
    }


    public int minimumEffortPath1(int[][] heights) {
        minEffort=Integer.MAX_VALUE;
        
        // f(0, 0, heights.length-1, heights[0].length-1, heights, 0, new boolean[heights.length][heights[0].length]);
        // return minEffort;
        // bfs(0, 0, heights.length-1, heights[0].length-1, heights, 0, new boolean[heights.length][heights[0].length]);
        // bfs
        int dr=heights.length-1;
        int dc= heights[0].length-1;
        boolean[][] vis=new boolean[dr+1][dc+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Pair p = new Pair(0,0,0);
        vis[0][0]=true;
        pq.add(p);
        while(pq.size()!=0){
            Pair rp = pq.remove();
            if(rp.row==dr && rp.col==dc){
                 minEffort=Math.min(minEffort, rp.absDiff);
                  System.out.println("rp.absDiff :: "+rp.absDiff);
                 vis[rp.row][rp.col]=false;
            }
            for(int i=0; i<dir.length; i++){
                int x=rp.row+dir[i][0];
                int y=rp.col+dir[i][1];
                //  System.out.println("x, y :: "+x+", "+ y);
                if(x>dr || x<0 || y>dc || y<0 || vis[x][y] ) continue;
                int newEffort = Math.abs(heights[rp.row][rp.col]-heights[x][y]) ;
                 System.out.println("x, y, newEff :: "+x+", "+ y+" "+newEffort);
                pq.add(new Pair(x, y, newEffort));
                vis[x][y]=true;
                
            }
        }
        return minEffort;
    }
    // effort -> Maximum ABs Diff.

    public void f(int sr, int sc, int dr, int dc, int[][] arr, int effort, boolean[][] vis){
        System.out.println("sr, sc , dr, dc:: "+sr+", "+ sc+", "+dr+", "+dc);
        if(sr==dr && sc==dc){
           minEffort=Math.min(minEffort, effort);
           return;
        }
        vis[sr][sc]=true;
        for(int i=0; i<dir.length; i++){
            int x=sr+dir[i][0];
            int y=sc+dir[i][1];
            //  System.out.println("x, y :: "+x+", "+ y);
            if(x>dr || x<0 || y>dc || y<0 || vis[x][y] ) continue;
            int newEffort = (Math.abs(arr[sr][sc]-arr[x][y])) ;
            // if(newEffort<minEffort){
            //     f(x, y, dr, dc, arr, Math.max(newEffort, effort), vis);
            // }
            if(minEffort==Integer.MAX_VALUE && newEffort<minEffort){
                f(x, y, dr, dc, arr, Math.max(newEffort, effort), vis);
            } if(newEffort<minEffort && newEffort>=effort)
                f(x, y, dr, dc, arr, Math.max(newEffort, effort), vis);
        }
        vis[sr][sc]=false;
    }
    */
}
