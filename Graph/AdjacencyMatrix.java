package Graph;
import java.util.*;

public class AdjacencyMatrix<T> implements Graph<T>, UndirectedGraph<T>
{
    int [][] matrix;
    HashMap<T, Integer> valueIndex;
    HashMap<Integer, T> indexValue;

    public AdjacencyMatrix(int n)
    {
        this.matrix=new int[n][n];
        valueIndex=new HashMap<>();
        indexValue=new HashMap<>();
    }

    public AdjacencyMatrix(Set<T> nodeValues)
    {
        this(nodeValues.size());
        int j=0;
        for(T val: nodeValues) 
        {
            this.valueIndex.put(val, j);
            this.indexValue.put(j, val);
            j++;
        }
    }

    public AdjacencyMatrix(EdgeList<T> edgeList, int n) throws Exception
    {
        this(n);
        List<DEdge<T>> edges=edgeList.getEdgeList();
        for(DEdge <T> edge: edges)
        {
            if(!this.hasNode(edge.from))this.addNode(edge.from);
            if(!this.hasNode(edge.to))this.addNode(edge.to);
            this.addDirectEdge(edge.from, edge.to, edge.weight);
        }
    }

    @Override
    public void addNode(T val) throws Exception
    {
        if(valueIndex.containsKey(val)) throw new Exception("Node already Exists");
        valueIndex.put(val, valueIndex.size());
        indexValue.put(indexValue.size(), val);
    }

    @Override
    public void addDirectEdge(T nodeFrom, T nodeTo, int weight) throws Exception
    {
        if(weight==0) throw new Exception("cannot add edge with weight 0");
        int row=0, col=0;
        try
        {
            row=valueIndex.get(nodeFrom);
            col=valueIndex.get(nodeTo);
        }
        catch(Exception e) 
        {
            throw new Exception("node does not exist");
        }
        matrix[row][col]=weight;
        if(this instanceof UndirectedGraph) matrix[col][row]=weight;
    }

    @Override
    public void addDirectEdge(T nodeFrom, T nodeTo) throws Exception
    {
        addDirectEdge(nodeFrom, nodeTo, 1);
    }

    @Override
    public boolean hasDirectEdge(T nodeFrom, T nodeTo) throws Exception
    {
        int row=0, col=0;
        try
        {
            row=valueIndex.get(nodeFrom);
            col=valueIndex.get(nodeTo);
        }
        catch(Exception e) 
        {
            throw new Exception("node does not exist");
        }
        if(matrix[row][col]!=0) return true;
        return false;
    }

    @Override
    public int getWeight(T nodeFrom, T nodeTo) throws Exception
    {
        if(!hasDirectEdge(nodeFrom, nodeTo)) throw new Exception("no such edge exist");
        int row=0, col=0;
        try
        {
            row=valueIndex.get(nodeFrom);
            col=valueIndex.get(nodeTo);
        }
        catch(Exception e) 
        {
            throw new Exception("node does not exist");
        }
        return matrix[row][col];
    }

    @Override
    public void setWeight(T nodeFrom, T nodeTo, int weight) throws Exception
    {
        if(!hasDirectEdge(nodeFrom, nodeTo)) throw new Exception("no such edge exist");
        addDirectEdge(nodeFrom, nodeTo, weight);
    }

    @Override
    public List<T> getNeighboursOf(T node)
    {
        List<T> neighbours=new ArrayList<>();
        for(int i=0; i<valueIndex.size(); i++)
            if(matrix[valueIndex.get(node)][i]>0) neighbours.add(indexValue.get(i));
        return neighbours;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder("");
        for(int i=0; i<valueIndex.size(); i++)
        {
            for(int j=0; j<valueIndex.size(); j++)
            {
                res.append(matrix[i][j]+" ");
            }
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public boolean hasNode(T val) {
        return valueIndex.containsKey(val);
    }

}