class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // [u,v] ::  v -> u
        int[] ans = new int[numCourses];
        // if(prerequisites.length==0) {
        //     for(int i=0; i<numCourses; i++) ans[i]=i;
        //     return ans;
        // }
        int idx=0;
        int n = numCourses;
        int[] inDegree = new int[n];
        // for(int i=0; i<n; i++) inDegree[i]=-1;

        // construct adjacency matrix
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            int u=edge[0];
            int v=edge[1];
            graph.get(v).add(u);
            inDegree[u]+=1;
        }
        // for(int val : inDegree) System.out.print(val+", ");
        // System.out.println();
        Queue<Integer> que = new ArrayDeque<>();

        for(int i=0; i<n; i++) if(inDegree[i]==0) { que.add(i); }
        // System.out.println("queuef :: "+que);
        while(que.size()>0){
            int sz=que.size();
            // while(sz-->0){
            int re=que.remove();
            ans[idx++]=re;
            for(int val : graph.get(re)){
                inDegree[val] -= 1;
                if(inDegree[val]==0) que.add(val);
                
            }
            // }
        }
       
        System.out.println("idx :: "+idx);
        if(idx!=n) return new int[0];
        return ans;


    }
}
