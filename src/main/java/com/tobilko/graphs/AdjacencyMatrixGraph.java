package com.tobilko.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Created by Andrew Tobilko on 11/27/2016.
 *
 */
public class AdjacencyMatrixGraph extends Graph {

    private int[][] graph;

    @Override
    protected void performAddingVertex(int vertex) {

    }

    @Override
    protected void performAddingEdge(int a, int b) {

    }

    @Override
    public List<Integer> getNeighbors(int vertex) {
        return Arrays.stream(graph[vertex]).filter(i -> i > 1).boxed().collect(Collectors.toList());
    }

}
