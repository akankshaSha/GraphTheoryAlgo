package Graph;

public class DEdge<T>
{
    T from, to;
    int weight;
    public DEdge(T from, T to, int weight)
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
