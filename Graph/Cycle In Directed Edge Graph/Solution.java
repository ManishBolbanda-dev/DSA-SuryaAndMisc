public class Solution 
{
    public static boolean isCycle=false;
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        // Write your code here.
        boolean[] vis = new boolean[v];
        boolean[] recStack = new boolean[v];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<v; i++) graph.add(new ArrayList<>());
           
        // construct graph
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        isCycle=false;
        for(int i=0; i<v; i++){
            if(vis[i]==false){
                dfs(graph, vis, recStack, i );
            }
        }
        return isCycle;
    }
    public static void dfs(List<List<Integer>> graph, boolean[] vis, boolean[] recStack, int src){
        if(isCycle) return;
        vis[src]=true;
        recStack[src]=true;
        for(int nbr : graph.get(src)){
            if(vis[nbr]==false){
                dfs(graph, vis, recStack, nbr );
            }else{
               if(recStack[nbr]==true){
                   isCycle=true;
                   return;
               } 
            }
        }
        recStack[src]=false;
    }
}
