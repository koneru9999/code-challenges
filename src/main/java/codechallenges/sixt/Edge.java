package codechallenges.sixt;

import java.util.ArrayList;
import java.util.List;

/**
 * A Graph Edge with its adjacent edges
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Edge<T> {
    private boolean visited;
    private T label;
    private List<Edge<T>> adjacency;

    public Edge(T label) {
        this.label = label;
        this.adjacency = new ArrayList<>();
        this.visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public T getLabel() {
        return label;
    }

    public void setAdjacency(List<Edge<T>> adjacency) {
        this.adjacency = adjacency;
    }

    public List<Edge<T>> getAdjacency() {
        return adjacency;
    }
}