package basicgraph;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.arraycopy;

public class GraphAdjMatrix extends Graph {

    private final int DEFAULT_NUM_VERTICES = 5;
    private final int SIZE_TO_EXPAND = 2;

    private int[][] adjMatrix;

    public GraphAdjMatrix() {
        adjMatrix = new int[DEFAULT_NUM_VERTICES][DEFAULT_NUM_VERTICES];
    }

    public void implementAddVertex() {
        int v = getNumVertices();
        if (v >= adjMatrix.length) {
            int[][] newAdjMatrix = new int[v * SIZE_TO_EXPAND][v * SIZE_TO_EXPAND];
            for (int i = 0; i < adjMatrix.length; i++) {
                arraycopy(adjMatrix[i], 0, newAdjMatrix[i], 0, adjMatrix.length);
            }
            adjMatrix = newAdjMatrix;
        }
    }

    public void implementAddEdge(int v, int w) {
        adjMatrix[v][w] += 1;
    }

    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < getNumVertices(); i++) {
            for (int j = 0; j < adjMatrix[v][i]; j++) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public List<Integer> getInNeighbors(int v) {
        List<Integer> inNeighbors = new ArrayList<Integer>();
        for (int i = 0; i < getNumVertices(); i++) {
            for (int j = 0; j < adjMatrix[i][v]; j++) {
                inNeighbors.add(i);
            }
        }
        return inNeighbors;
    }

    public List<Integer> getDistance2(int v) {
        // XXX Implement this method in week 2
        return null;
    }

    public String adjacencyString() {
        int dim = getNumVertices();
        String s = "Adjacency matrix";
        s += " (size " + dim + "x" + dim + " = " + dim * dim + " integers):";
        for (int i = 0; i < dim; i++) {
            s += "\n\t" + i + ": ";
            for (int j = 0; j < dim; j++) {
                s += adjMatrix[i][j] + ", ";
            }
        }
        return s;
    }

}
