class Solution
{
    //this problem is done by using bfs
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj,int[] vis,int i){
        //create queue
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> al=new ArrayList<>();
        //vis[i] is equal to zeo means it is visited
        vis[i]=0;
        q.add(i);
        while(!q.isEmpty()){
            int curr=q.poll();
            //vis[curr] is equal to 1 means it is visited and processed
            vis[curr]=1;
            al=adj.get(curr);
            for(int j=0;j<al.size();j++){
                int val=al.get(j);
                if(vis[val]==-1){
                    vis[val]=0;
                    q.add(val);
                }
                //vis[val] is equal to 0 means it is already visited that means cycle is detected
                else if(vis[val]==0)
                    return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        //create a visited array
        int vis[]=new int[V];
        //initialize all values with -1
        for(int i=0;i<V;i++){
            vis[i]=-1;
        }
        for(int i=0;i<V;i++){
            //if vis[i] is equal to -1 means it is not visited yet
            if(vis[i]==-1){
                //check if it has cycle or not
                boolean flag=isCyclic(adj,vis,i);
                if(flag){
                    //if flag means it has cycle then return true
                    return true;
                }
            }
        }
        return false;
    }
}