class Solution {
    //the problem is done by detecting cycle in an array
    ArrayList<Integer> list=new ArrayList<>();
    //topological order if found in directed graphs and not having back edges,self loops
    public void topological(List<ArrayList<Integer>> adj,boolean vis[],Stack<Integer> st,int i){
        //make node as visited
        vis[i]=true;
        ArrayList<Integer> al=new ArrayList<>();
        al=adj.get(i);
        for(int j=0;j<al.size();j++){
            //iterate all adjacent nodes
            if(!vis[al.get(j)])
                topological(adj,vis,st,al.get(j));
        }
        //after visiting all adjacent nodes the i is pushed in the stack
        st.push(i);
    }
    public void topologicalSort(List<ArrayList<Integer>> adj,int[] arr,int n){
        boolean vis[]=new boolean[n];
        //create a stack
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<n;i++){
            //if not visited call topological
            if(!vis[i])
                topological(adj,vis,st,i);
        }
        //add all elements in to a list from stack
        while(!st.isEmpty()){
            list.add(st.pop());
        }
    }
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
                //cycle detected
                return true;
        }
        recStack[i]=false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean recStack[]=new boolean[numCourses];
        boolean vis[]=new boolean[numCourses];
        List<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int emp[]=new int[0];
        int arr[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            boolean flag=hasCycle(adj,vis,recStack,i);
            if(flag){
                //the graph has a cycle that means it does not finish all courses
                //so return an empty array
                return emp;
            }
        }
        //the graph has no cycles that means it finish all courses
        //order of courses should finish all courses
        topologicalSort(adj,arr,numCourses);
        int ind=0;
        for(int i=list.size()-1;i>=0;i--){
            arr[ind]=list.get(i);
            ind+=1;
        }
        return arr;
    }
}
