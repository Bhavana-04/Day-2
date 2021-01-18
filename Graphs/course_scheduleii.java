//this is similar to the course schedule by detecting cycle in a graph
class Solution{
    public boolean hasCycle(List<ArrayList<Integer>> adj,boolean[] vis,boolean[] recStack,int i,ArrayList<Integer> list){
            //if the course in recStack 
            if(recStack[i])
                return true;
            //if the course is visited
            if(vis[i])
                return false;
            recStack[i]=true;
            ArrayList<Integer> al=new ArrayList<Integer>();
            al=adj.get(i);
            for(int j=0;j<al.size();j++){
                if(hasCycle(adj,vis,recStack,al.get(j),list))
                    //cycle is detected
                    return true;
            }
            //adding the course in a list
            list.add(i);
            vis[i]=true;
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
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            boolean flag=hasCycle(adj,vis,recStack,i,list);
            if(flag){
                //the graph has a cycle that means it does not finish all courses
                //so return an empty array
                return emp;
            }
        }
        //the graph has no cycles that means it finish all courses
        //so it returns a array having the order of finishing all courses
        int ind=0;
        for(int i=0;i<list.size();i++){
            arr[ind]=list.get(i);
            ind+=1;
        }
        return arr;
    }
}