package hardik.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ShortestPathBFS {

	private Map<Node, Boolean> vis = new HashMap<Node, Boolean>();

	private Map<Node, Node> prev = new HashMap<Node, Node>();

	public List getDirections(Node start, Node finish){
	    List directions = new LinkedList();
	    Queue q = new LinkedList();
	    Node current = start;
	    q.add(current);
	    vis.put(current, true);
	    while(!q.isEmpty()){
	        current = (Node) q.poll();
	        if (current.equals(finish)){
	            break;
	        }else{
	        	NodeList nodeList = current.getChildNodes();
	            for(int i = 0 ; i < nodeList.getLength() ; i++){
	            	Node node = nodeList.item(i);
	                if(!vis.containsKey(node)){
	                    q.add(node);
	                    vis.put(node, true);
	                    prev.put(node, current);
	                }
	            }
	        }
	    }
	    if (!current.equals(finish)){
	        System.out.println("can't reach destination");
	    }
	    for(Node node = finish; node != null; node = prev.get(node)) {
	        directions.add(node);
	    }
	    //directions.reverse();
	    return directions;
	}
}
