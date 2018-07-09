package codechallenges.sixt;

import java.util.HashMap;
import java.util.Map;

/**
 * A graph to represent the relationships
 *
 * @param <T>
 * @author Venkaiah Chowdary Koneru
 */
public class Graph<T> {
    private int size;
    private Map<T, Edge<T>> edges;

    public Graph(int V) {
        this(new HashMap<>(V));
    }

    public Graph(HashMap<T, Edge<T>> edges) {
        this.size = edges.size();
        this.edges = new HashMap<>(edges);
    }

    public int getSize() {
        return size;
    }

    public Edge<T> getEdge(T edgeLabel) {
        return edges.get(edgeLabel);
    }

    public void addEdge(Edge<T> vertex) {
        if (!edges.containsKey(vertex.getLabel())) {
            edges.put(vertex.getLabel(), vertex);
        }
    }

    public Map<T, Edge<T>> getEdges() {
        return edges;
    }
}
