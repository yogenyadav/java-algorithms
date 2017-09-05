package algo.graphbased;

import com.google.common.collect.Sets;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class Graph<T> {
    /**
     * Node to Edges
     * Edge is defined as Pair (tuple)
     * Pair - left is the connected node and right is the weight of the edge
     */
    Map<T, List<Pair<T, Integer>>> nodesAndEdges = new HashMap<>();

    Set<T> getNodes() {
        return Sets.newHashSet(nodesAndEdges.keySet());
    }

    Set<Pair<T, Integer>> getAdjacents(T node) {
        return Sets.newHashSet(nodesAndEdges.get(node));
    }

    T getNode(T node) {
        Set<T> nodes = this.nodesAndEdges.keySet();
        for (T n : nodes) {
            if (n.equals(node)) {
                return n;
            }
        }
        return null;
    }

    @Data
    public static class Node<T> {
        public final T data;
        public boolean visited;
        public int distance;
        public Node<T> predecessor;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
