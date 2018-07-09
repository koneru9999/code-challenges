package codechallenges.sixt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Assumptions:
 * 1. the lowest script id is '1'
 *
 * @author Venkaiah Chowdary Koneru
 */
public class ExecutionOrder {
    // an array to store the dependencies by script id as index
    private final LinkedList<Integer> dependencies[];

    // an array to mark visits.
    private final boolean[] visited;

    /**
     * @param scripts
     */
    public ExecutionOrder(VulnerabilityScript[] scripts) {
        this.dependencies = new LinkedList[scripts.length];
        this.visited = new boolean[scripts.length];

        /*
         * As we can't assume the order of the given scripts
         * Iterate over and set the dependencies explicitly by script id index
         */
        for (VulnerabilityScript script : scripts) {
            visited[script.getScriptId() - 1] = false;

            LinkedList<Integer> dependencyIds = new LinkedList<>();

            if (script.getDependencies() != null) {
                dependencyIds.addAll(script.getDependencies());
            }

            this.dependencies[script.getScriptId() - 1] = dependencyIds;
        }
    }

    /**
     * <p>
     * Step 1: Select an unmarked script
     * Step 1.1 call markVisit()
     * Step 1.1.1: mark as visited
     * Step 1.1.2: for each dependency of selected script
     * Step 1.1.3: call markVisit()
     * Step 1.2 push it to queue
     * </p>
     * Prints the execution order
     */
    public Queue<Integer> printsExecutionOrder() {
        final int size = dependencies.length;

        Queue<Integer> queue = new LinkedList<>();

        // iterate over scripts
        for (int i = 0; i < size; i++) {
            // Select unmarked entry
            if (!visited[i]) {
                markVisit(i, visited, queue);
            }
        }

        return queue;
    }

    /**
     * recursively marks the visits of a script dependencies
     *
     * @param arrayIndex
     * @param visited    array which contains the visit marking
     * @param queue      queue to store sorted order of scripts
     */
    private void markVisit(int arrayIndex, boolean[] visited, Queue<Integer> queue) {
        // mark visited
        visited[arrayIndex] = true;

        for (Integer next : dependencies[arrayIndex]) {
            // for each dependency, if it is not visited
            if (!visited[next - 1]) {
                markVisit(next - 1, visited, queue);
            }
        }

        // put into queue
        queue.offer(arrayIndex + 1);
    }
}
