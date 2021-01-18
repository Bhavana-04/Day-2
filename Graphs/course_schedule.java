class Solution {
    //the problem is done by detecting the cycle in a graph 
    public boolean hasCycle(List<ArrayList<Integer>> adj,boolean[] vis,boolean[] recStack,int i){
        //if the course in recStack 
        if(recStack[i])
            return true;
        //if the course is visited
        if(vis[i])
            return false;
        recStack[i]=true;
        vis[i]=true;
        ArrayList<Integer> al=new ArrayList<Integer>();
        al=adj.get(i);
        for(int j=0;j<al.size();j++){
            if(hasCycle(adj,vis,recStack,al.get(j)))
                //cycle is detected
                return true;
        }
        recStack[i]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create two boolean arrays
        boolean recStack[]=new boolean[numCourses];
        boolean vis[]=new boolean[numCourses];
        List<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            boolean flag=hasCycle(adj,vis,recStack,i);
            if(flag){
                //the graph has a cycle that means it does not finish all courses
                //so it returns false
                return false;
            }
        }
        //the graph has no cycles that means it finish all courses
        //so it returns true
        return true;
    }
}
