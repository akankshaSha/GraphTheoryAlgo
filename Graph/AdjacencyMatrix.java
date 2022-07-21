package Graph;
import Graph.Graph;
import java.util.*;

public class AdjacencyMatrix<T> implements Graph<T>
{
    int [][] matrix;
    HashMap<T, Integer> valueIndex;

    public AdjacencyMatrix(int n)
    {
        this.matrix=new int[n][n];
        valueIndex=new HashMap<>();
    }

    public AdjacencyMatrix(Set<T> nodeValues)
    {
        int n=nodeValues.size();
        this.matrix=new int [n][n];
        int i=0;
        for(T val: nodeValues) this.valueIndex.put(val, i++);
    }

    @Override
    public void addNode(T val) throws Exception
    {
        if(valueIndex.containsKey(val)) throw new Exception("Node already Exists");
        valueIndex.put(val, valueIndex.size());
    }

    @Override
    public void addDirectEdge(T nodeFrom, T nodeTo, int weight) throws Exception
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
        matrix[row][col]=weight;
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
    public String toString() {
        StringBuilder res=new StringBuilder("");
        int index=0;
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

}