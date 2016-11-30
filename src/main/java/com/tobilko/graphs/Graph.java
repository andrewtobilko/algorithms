package com.tobilko.graphs;

import java.util.List;

/**
 *
 * Created by Andrew Tobilko on 11/27/2016.
 *
 */
public abstract class Graph {

    private int vertexAmount;
    private int edgeAmount;

    public int getVertexAmount() { return vertexAmount; }
    public int getEdgeAmount() { return edgeAmount; }

    public final void addVertex(int vertex) {
        performAddingVertex(vertex);
        ++vertexAmount;
    }
    public final void addEdge(int a, int b) {
        performAddingEdge(a, b);
        ++edgeAmount;
    }

    public abstract List<Integer> getNeighbors(int vertex);

    protected abstract void performAddingVertex(int vertex);
    protected abstract void performAddingEdge(int a, int b);

}
