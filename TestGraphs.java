import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import Graph.*;

public class TestGraphs {
    static public List<EdgeList<Integer>> getTests() throws NumberFormatException, Exception
    {
        File input=new File(".\\graphInputs.griff");
        List<EdgeList<Integer>> tests=new ArrayList<>();
        Scanner sc=new Scanner(input);
        while(sc.hasNextLine())
        {
            String g=sc.nextLine();
            if(g.length()==0 || g.charAt(0)=='#') continue;
            g=g.substring(2, g.length()-2);
            String edges[]=g.split("\\),\\(");            
            EdgeList<Integer> graph=new EdgeList<>();
            for(int i=0; i<edges.length; i++)
            {
                String tuple[]=edges[i].split(",");
                graph.addEdge(Integer.parseInt(tuple[0]), Integer.parseInt(tuple[1]), Integer.parseInt(tuple[2]));
            }
            tests.add(graph);
        }
        return tests;
    }
}
