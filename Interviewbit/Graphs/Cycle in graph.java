/**
* Definition for undirected graph.
* class UndirectedGraphNode {
*     int label;
*     List<UndirectedGraphNode> neighbors;
*     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
* };
*/
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;
    
    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); //new node for return
    HashMap<Integer, UndirectedGraphNode> map = new HashMap(); //store visited nodes
    
    map.put(newNode.label, newNode); //add first node to HashMap
    
    LinkedList<UndirectedGraphNode> queue = new LinkedList(); //to store **original** nodes need to be visited
    queue.add(node); //add first **original** node to queue
    
    while (!queue.isEmpty()) { //if more nodes need to be visited
      UndirectedGraphNode n = queue.pop(); //search first node in the queue
      for (UndirectedGraphNode neighbor : n.neighbors) {
        if (!map.containsKey(neighbor.label)) { //add to map and queue if this node hasn't been searched before
          map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
          queue.add(neighbor);
        }
        map.get(n.label).neighbors.add(map.get(neighbor.label)); //add neighbor to new created nodes
      }
    }
    
    return newNode;
  }
}


public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}