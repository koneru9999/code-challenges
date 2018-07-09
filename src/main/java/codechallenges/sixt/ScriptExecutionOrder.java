package codechallenges.sixt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Venkaiah Chowdary Koneru
 */
public class ScriptExecutionOrder {
    private final Graph<Integer> graph;

    /**
     * constructor to initialize the graph based on the supplied scripts
     *
     * @param scripts
     */
    public ScriptExecutionOrder(List<VulnerabilityScript> scripts) {
        if (scripts == null || scripts.isEmpty()) {
            throw new IllegalArgumentException("Null / Empty scripts are provided");
        }

        this.graph = new Graph<>(scripts.size());

        // All every script as an edge of the graph
        scripts.forEach((script) -> {
            Edge<Integer> scriptFromGraph = graph.getEdge(script.getScriptId());
            if (scriptFromGraph == null) { // Add only if it is not yet added
                scriptFromGraph = new Edge<>(script.getScriptId());
                graph.addEdge(scriptFromGraph);
            }

            //add script's dependencies as adjacent edges
            if (script.getDependencies() != null && !script.getDependencies().isEmpty()) {
                for (Integer dependency : script.getDependencies()) {
                    Edge<Integer> dependencyScript = graph.getEdge(dependency);
                    if (dependencyScript == null) {
                        dependencyScript = new Edge<>(dependency);
                        graph.addEdge(dependencyScript);
                    }
                    scriptFromGraph.getAdjacency().add(dependencyScript);
                }
            }
        });
    }

    /**
     * Step 1: visit every vertex if not visited
     * Step 2: once visited after recursive visit of dependencies, add it to ordered list
     *
     * @return
     */
    public List<Integer> getExecutionOrder() {
        List<Edge<Integer>> orderedList = new ArrayList<>();
        for (Edge<Integer> script : graph.getEdges().values()) {
            if (!script.isVisited()) {
                markVisit(script, orderedList);
            }
        }

        return orderedList.stream()
                .map(Edge::getLabel)
                .collect(Collectors.toList());
    }

    /**
     * Traverse graph based on DFS
     *
     * @param script
     * @param orderedList
     */
    private void markVisit(Edge<Integer> script, List<Edge<Integer>> orderedList) {
        if (script == null) {
            return;
        }

        // mark as visited
        script.setVisited(true);

        if (script.getAdjacency() != null && !script.getAdjacency().isEmpty()) {
            script.getAdjacency().forEach((dependency) -> {
                if (!dependency.isVisited()) {
                    markVisit(dependency, orderedList);
                }
            });
        }

        orderedList.add(script);
    }
}
