class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        Queue<Integer> que = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        Map<Integer, Integer> map = new HashMap<>();
        int state=1;
        
        
        for(int idx=0; idx<n; idx++){
            if(vis[idx]==false){
                que.add(idx);
                vis[idx]=true;
                map.put(idx,state);
                if(state==1) state=2;
                else state=1;
                while(que.size()>0){
                    int sz=que.size();
                    while(sz-->0){
                        int re = que.remove();
                        for(int i=0; i<graph[re].length; i++){
                            int nbr=graph[re][i];
                            if(vis[nbr]==false){
                                que.add(nbr);
                                map.put(nbr, state);
                                vis[nbr]=true;
                            }else{
                                if(map.get(re) == map.get(nbr)) return false;
                            }
                        }
                        
                    }
                    if(state==1) state=2;
                    else state=1;
                }
            }
        }
        
        return true;
    }
}
