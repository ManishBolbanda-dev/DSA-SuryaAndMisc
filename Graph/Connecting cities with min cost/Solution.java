import java.util.* ;
import java.io.*; 
public class Solution {

    public static class Pair implements Comparable<Pair>{
        int v;
        int wt;
        Pair(int v, int wt){
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
        public String toString(){
            return "("+v+", "+wt+") ";
        }
    }
    public static int getMinimumCost(int n, int m, int[][] connections) {
        // construct graph
        // bfs + heap
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : connections){
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        boolean[] vis = new boolean[n+1];
        int ans =0;
        
        pq.add(new Pair(1, 0));
        while(pq.size()!=0){
            Pair rp = pq.remove();
            if(vis[rp.v]) continue;
            
            vis[rp.v]=true;
            ans += rp.wt;
//             System.out.println(ans);
            for(Pair p : graph.get(rp.v)){
                if(!vis[p.v]){
                    pq.add(new Pair(p.v, p.wt));
                }
            }
        }
        for(int i=1; i<=n; i++) if(!vis[i]) return -1;
        return ans;
    }
    
}
