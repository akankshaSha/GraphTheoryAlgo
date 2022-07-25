import java.util.List;

import Graph.*;

public class Main
{
    public void getMST(UndirectedGraph<Integer>g)
    {

    }
    public static void main(String[] args) throws Exception {
        List<EdgeList<Integer>> tests=TestGraphs.getTests();
        for(EdgeList<Integer> test: tests)
        {
            UndirectedGraph<Integer> g=new AdjacencyList<Integer>(test);
            System.out.println(g.getNeighboursOf(1));
        }
    }
        
}