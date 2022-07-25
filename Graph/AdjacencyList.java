package Graph;

import java.util.*;

class Edge<T>
{
    T nodeValue;
    int weight;
    Edge(T nodeValue, int weight)
    {
        this.nodeValue=nodeValue;
        this.weight=weight;
    }

    @Override
    public String toString() {
        String res="("+this.nodeValue+","+this.weight+")";
        return res;
    }
}

public class AdjacencyList<T> implements Graph<T>, UndirectedGraph<T> {
    HashMap<T, List<Edge<T>>> fromToWeight;

    public AdjacencyList()
    {
        fromToWeight=new HashMap<>();
    }

    public AdjacencyList(EdgeList<T> edgeList) throws Exception
    {
        this();
        List<DEdge<T>> edges=edgeList.getEdgeList();
        for(DEdge <T> edge: edges)
        {
            if(!this.hasNode(edge.from))this.addNode(edge.from);
            if(!this.hasNode(edge.to))this.addNode(edge.to);
            this.addDirectEdge(edge.from, edge.to, edge.weight);
        }
    }

    @Override
    public void addNode(T val) throws Exception {
        if(fromToWeight.containsKey(val)) throw new Exception("node already exists");
        fromToWeight.put(val, new ArrayList<>());        
    }

    @Override
    public void addDirectEdge(T nodeFrom, T nodeTo, int weight) throws Exception {
        if(hasDirectEdge(nodeFrom, nodeTo)) throw new Exception("Edge Exists Between The Given Nodes");
        if(!fromToWeight.containsKey(nodeFrom)) throw new Exception("Node Does Not Exist");
        List<Edge<T>> edges=fromToWeight.get(nodeFrom);
        edges.add(new Edge<T>(nodeTo, weight));
        fromToWeight.put(nodeFrom, edges);   
        if(this instanceof UndirectedGraph)
        {
            if(!fromToWeight.containsKey(nodeTo)) throw new Exception("Node Does Not Exist");
            edges=fromToWeight.get(nodeTo);
            edges.add(new Edge<T>(nodeFrom, weight));
            fromToWeight.put(nodeTo, edges);  
        }    
    }

    @Override
    public void addDirectEdge(T nodeFrom, T nodeTo) throws Exception {
        addDirectEdge(nodeFrom, nodeTo, 1);       
    }

    @Override
    public boolean hasDirectEdge(T nodeFrom, T nodeTo) throws Exception {
        if(!fromToWeight.containsKey(nodeFrom)) throw new Exception("Node Does Not Exist");
        List<Edge<T>> edges=fromToWeight.get(nodeFrom);
        for(Edge<T> edge: edges) if(edge.nodeValue==nodeFrom) return true;
        return false;
    }

    @Override
    public int getWeight(T nodeFrom, T nodeTo) throws Exception {
        if(!fromToWeight.containsKey(nodeFrom)) throw new Exception("Node Does Not Exist");
        List<Edge<T>> edges=fromToWeight.get(nodeFrom);
        for(Edge<T> edge: edges) if(edge.nodeValue==nodeFrom) return edge.weight;
        return 0;
    }
    
    @Override
    public void setWeight(T nodeFrom, T nodeTo, int weight) throws Exception {
        if(!fromToWeight.containsKey(nodeFrom)) throw new Exception("Node Does Not Exist");
        List<Edge<T>> edges=fromToWeight.get(nodeFrom);
        for(Edge<T> edge: edges) if(edge.nodeValue==nodeFrom) edge.weight=weight;
    }

    public List<Edge<T>> getEdgesFrom(T node)
    {
        return fromToWeight.get(node);
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder("");
        for(T from: fromToWeight.keySet())
        {
            res.append(from+"->"+fromToWeight.get(from));
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public List<T> getNeighboursOf(T node) throws Exception {
        List<Edge<T>> edges=getEdgesFrom(node);
        List<T> neighbours=new ArrayList<>();
        for(Edge<T>edge: edges)
            neighbours.add(edge.nodeValue);
        return neighbours;
    }

    @Override
    public boolean hasNode(T val) {
        return fromToWeight.containsKey(val);
    }
}
