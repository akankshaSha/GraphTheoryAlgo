package Graph;
import java.util.*;

public class EdgeList<T> {
    List<DEdge<T>> edges;

    public EdgeList()
    {
        edges=new ArrayList<>();
    } 
    
    public void addEdge(T from, T to, int weight) throws Exception
    {
        if(hasDirectEdge(from, to)) throw new Exception("Edge already Exists");
        DEdge<T> edge=new DEdge<>(from, to, weight);
        edges.add(edge);
    }

    public boolean hasDirectEdge(T from, T to)
    {
        for(DEdge<T> edge: this.edges)
        {
            if(edge.from==from && edge.to==to) return true;
        }
        return false;
    }

    public List<DEdge<T>> getEdgeList()
    {
        return edges;
    }

    @Override
    public String toString() {
        return edges.toString();
    }
}
