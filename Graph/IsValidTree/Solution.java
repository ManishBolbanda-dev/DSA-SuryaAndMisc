public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    static boolean cycleFound=false;

    public boolean validTree(int n, int[][] edges) {
        // write your code here

        // find cycle
        boolean[] vis = new boolean[n];
        //conctruct graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int components=0;
        cycleFound=false;

        for(int i=0; i<n; i++){
            
            if(vis[i] == false){
                components++;
                if(components == 2) return false;
                dfs(graph, vis, i, -1);
            }
        }
        return !cycleFound;
    }
    public void dfs(List<List<Integer>> graph, boolean[] vis, int src, int caller){
        vis[src]=true;
        if(cycleFound) return;
        for(int nbr : graph.get(src)){
            if(vis[nbr]==false){
                dfs(graph, vis, nbr, src);
            }else{
                if(caller != nbr) {
                    cycleFound=true;
                    return;
                }
            }  
        }
    }
}
