import java.util.*;

import Graph.*;

public class DepthFirstSearch
{
    static List<Integer> depthFirstTraversal(Graph<Integer> g, int start) throws Exception
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

    static List<Integer> depthFirstTraversal(Graph<Integer> g, int start, HashSet<Integer> visited) throws Exception
    {
        List<Integer> res=new ArrayList<>();
        if(!g.hasNode(start) || visited.contains(start)) return res;
        visited.add(start);
        List<Integer> neighbours=g.getNeighboursOf(start);
        res.add(start);
        for(int neighbour: neighbours) 
        {
            res.addAll(depthFirstTraversal(g, neighbour, visited));
        }
        return res;
    }

    static boolean depthFirstSearch(Graph<Integer> g, int start, int search) throws Exception
    {
        HashSet<Integer> visited=new HashSet<>();
        if(!g.hasNode(start)) return false;
        Stack<Integer> nodes=new Stack<>();
        nodes.push(start);
        while(!nodes.isEmpty())
        {
            int node=nodes.pop();
            visited.add(node);
            if(node==search) return true;
            List<Integer> neighbours=g.getNeighboursOf(node);
            for(int neighbour: neighbours) 
            {
                if(!visited.contains(neighbour)) nodes.push(neighbour);
            }
        }
        return false;
    }

    static boolean depthFirstSearch(Graph<Integer> g, int start,int search, HashSet<Integer> visited) throws Exception
    {
        if(!g.hasNode(start) || visited.contains(start)) return false;
        visited.add(start);
        List<Integer> neighbours=g.getNeighboursOf(start);
        if(start==search) return true;
        for(int neighbour: neighbours) 
        {
            if(depthFirstSearch(g, neighbour, search, visited)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        List<EdgeList<Integer>> tests=TestGraphs.getTests();
        for(EdgeList<Integer> test: tests)
        {
            System.out.println(depthFirstTraversal(new AdjacencyList<Integer>(test), 1));
        }
    }
}