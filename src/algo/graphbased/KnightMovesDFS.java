package algo.graphbased;

/**
 * All possible moves of knight on a chess board.
 *
 */
public class KnightMovesDFS {
    private final Graph<Graph.Node<Integer>> chessBoard;

    public KnightMovesDFS(Graph<Graph.Node<Integer>> chessBoard) {
        this.chessBoard = generateKnightMoves();
    }

    /**
     * Generates a graph of knight moves
     * 1. Each square on board is a node.
     * 2. Edges are moves possible from a node to all the other nodes.
     *
     */
    private Graph<Graph.Node<Integer>> generateKnightMoves() {
        return null;
    }


}
