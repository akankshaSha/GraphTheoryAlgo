import java.util.*;

import Graph.*;

public class DepthFirstSearch
{
    static List<Integer> DFT(Graph<Integer> g, int start) throws Exception
    {
        List<Integer> res=new ArrayList<>();
        HashSet<Integer> visited=new HashSet<>();
        if(!g.hasNode(start)) return res;
        Stack<Integer> nodes=new Stack<>();
        nodes.push(start);
        while(!nodes.isEmpty())
        {
            int node=nodes.pop();
            visited.add(node);
            res.add(node);
            List<Integer> neighbours=g.getNeighboursOf(node);
            for(int neighbour: neighbours) 
            {
                if(!visited.contains(neighbour)) nodes.push(neighbour);
            }
        }
        return res;
    }

    static List<Integer> DFT(Graph<Integer> g, int start, HashSet<Integer> visited) throws Exception
    {
        List<Integer> res=new ArrayList<>();
        if(!g.hasNode(start) || visited.contains(start)) return res;
        visited.add(start);
        List<Integer> neighbours=g.getNeighboursOf(start);
        res.add(start);
        for(int neighbour: neighbours) 
        {
            res.addAll(DFT(g, neighbour, visited));
        }
        return res;
    }
    public static void main(String[] args) throws Exception {
        Graph<Integer> g=new AdjacencyList<>();
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addNode(5);
        g.addDirectEdge(1, 2);
        g.addDirectEdge(2, 3);
        g.addDirectEdge(3, 1);
        g.addDirectEdge(3, 4);
        g.addDirectEdge(4, 5);
        g.addDirectEdge(5, 3);
        System.out.println(DFT(g, 1));
        System.out.println(DFT(g, 1, new HashSet<>()));
    }
}