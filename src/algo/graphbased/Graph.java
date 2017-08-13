package algo.graphbased;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.*;

public class Graph<T> {
    Map<T, List<T>> nodesAndEdges = new HashMap<>();

    Set<T> getNodes() {
        return nodesAndEdges.keySet();
    }

    Set<T> getAdjacents(T node) {
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
