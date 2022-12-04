class Solution {
    class Pair implements Comparable<Pair>{
        int v;
        int wt;
        Pair(int v, int w){
            this.v=v;
            this.wt=w;
        }
        public int compareTo(Pair p){
            return this.wt-p.wt;
        }
        public String toString(){
            return "("+v+", "+wt+")";
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dist=0;
                dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                Pair np1 = new Pair(j, dist);
                Pair np2 = new Pair(i, dist);
                graph.get(i).add(np1);
                graph.get(j).add(np2);
            }
        }
        // System.out.println(graph);
        int ans=0;
        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while(pq.size()>0){
            Pair p = pq.remove();
            if(vis[p.v]) continue;
            ans += p.wt;
            // System.out.println("Pair :: "+p+" ans :: "+ans);
            vis[p.v]=true;
            for(Pair nbrP : graph.get(p.v)){
                if(!vis[nbrP.v]) pq.add(new Pair(nbrP.v, nbrP.wt));
            }
        }
        return ans;
    }
}
