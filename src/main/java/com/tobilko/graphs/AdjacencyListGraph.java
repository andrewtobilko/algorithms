package com.tobilko.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Andrew Tobilko on 11/27/2016.
 *
 */
public class AdjacencyListGraph extends Graph {

    private Map<Integer, List<Integer>> graph;

    @Override
    protected void performAddingVertex(int vertex) {
        graph.put(vertex, new ArrayList<>());
    }

    @Override
    protected void performAddingEdge(int a, int b) {
        if (graph.containsKey(a)) {
            graph.get(a).add(b);
        } else {
            throw new IllegalArgumentException("There is not a " + a + " vertex!");
        }
    }

    @Override
    public List<Integer> getNeighbors(int vertex) {
        return new ArrayList<>(graph.get(vertex));
    }

}
