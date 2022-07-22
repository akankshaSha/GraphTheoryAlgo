import Graph.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception {
        Graph<Character> g=new AdjacencyMatrix<>(4);
        g.addNode('A');
        g.addNode('B');
        g.addNode('C');
        g.addNode('D');

        g.addDirectEdge('A', 'B');
        g.addDirectEdge('A', 'C');
        g.addDirectEdge('A', 'D');
        g.addDirectEdge('B', 'C');
        g.addDirectEdge('B', 'D');
        g.addDirectEdge('C', 'D');
        g.addDirectEdge('D', 'A');

        System.out.println(g.getNeighboursOf('A'));
        System.out.println(g.getNeighboursOf('B'));
        System.out.println(g.getNeighboursOf('C'));
        System.out.println(g.getNeighboursOf('D'));
    }
        
}