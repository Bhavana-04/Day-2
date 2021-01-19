class Solution {
    public Node cloneGraph(Node node) {
        //if node is null return it
        if(node==null)
            return node;
        //create a queue for storing a nodes
        Queue<Node> q=new LinkedList<>();
        //create a hash map for storing the all neighbors of a node
        HashMap<Node,Node> hm=new HashMap<>();
        q.add(node);
        Node n=new Node(node.val);
        hm.put(node,n);
        while(!q.isEmpty()){
            Node curr=q.poll();
            //iterate all neighbors
            for(Node adj:curr.neighbors){
                //if it is not in the hashmap then add in to a queue and map
                if(!hm.containsKey(adj)){
                    Node newNode=new Node(adj.val);
                    hm.put(adj,newNode);
                    q.add(adj);
                }
                hm.get(curr).neighbors.add(hm.get(adj));
            }
        }
        return hm.get(node);
    }
}
