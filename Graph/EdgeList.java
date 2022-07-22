package Graph;
import java.util.*;

class Edge<T>
{
    T from, to;
    int weight;
    Edge(T from, T to, int weight)
    {
        this.from=from;
        this.to=to;
        this.weight=weight;
    }

    @Override
    public String toString() {
        String res="("+this.from+","+this.to+","+this.weight+")";
        return res;
    }
}

public class EdgeList<T> {
    List<Edge<T>> edges;

    public EdgeList()
    {
        edges=new ArrayList<>();
    } 
    
    public void addEdge(T from, T to, int weight) throws Exception
    {
        if(hasDirectEdge(from, to)) throw new Exception("Edge already Exists");
        Edge<T> edge=new Edge<>(from, to, weight);
        edges.add(edge);
    }

    public boolean hasDirectEdge(T from, T to)
    {
        for(Edge<T> edge: this.edges)
        {
            if(edge.from==from && edge.to==to) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return edges.toString();
    }
}
