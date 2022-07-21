package Graph;

public interface Graph<T> {
    public void addNode(T val) throws Exception;
    public void addDirectEdge(T nodeFrom, T nodeTo, int weight) throws Exception;
    public void addDirectEdge(T nodeFrom, T nodeTo) throws Exception;
    public boolean hasDirectEdge(T nodeFrom, T nodeTo) throws Exception;
    public int getWeight(T nodeFrom, T nodeTo) throws Exception;
}
