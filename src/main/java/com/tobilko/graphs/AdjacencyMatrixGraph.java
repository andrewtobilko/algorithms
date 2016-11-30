package com.tobilko.graphs;

import java.util.List;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

/**
 *
 * Created by Andrew Tobilko on 11/27/2016.
 *
 */
public class AdjacencyMatrixGraph extends Graph {

    private final int NO_RELATION = 0;
    private final int NEIGHBOR_RELATION = 1;
    private final int INITIAL_SIZE = 16;

    private int[][] graph = new int[INITIAL_SIZE][INITIAL_SIZE];

    @Override
    protected void performAddingVertex(int vertex) {
        if (vertex > getVertexAmount()) {
            expandGraph(vertex);
        }
    }

    @Override
    protected void performAddingEdge(int a, int b) {
        if (a > getVertexAmount() || b > getVertexAmount()) {
            throw new IllegalArgumentException("Either a or b is greater than the graph size!");
        }
        graph[a][b] = NEIGHBOR_RELATION;
    }

    private void expandGraph(int dimensions) {
        int[][] temp = new int[dimensions][dimensions];
        for (int i = 0; i < graph.length; i++) {
            System.arraycopy(graph[i], 0, temp[i], 0, graph[i].length);
        }
        graph = temp;
    }

    @Override
    public List<Integer> getNeighbors(int vertex) {
        return stream(graph[vertex]).filter(i -> i == NEIGHBOR_RELATION).boxed().collect(toList());
    }

}
