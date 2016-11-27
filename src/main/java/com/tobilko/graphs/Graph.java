package com.tobilko.graphs;

/**
 *
 * Created by Andrew Tobilko on 11/27/2016.
 *
 */
public abstract class Graph {

    private int V;
    private int E;

    public int getV() { return V; }
    public int getE() { return E; }

    public final void addVertex(int vertex) {
        performAddingVertex(vertex);
        ++V;
    }
    public final void addEdge(int a, int b) {
        performAddingEdge(a, b);
        ++E;
    }

    protected abstract void performAddingVertex(int vertex);
    protected abstract void performAddingEdge(int a, int b);

}
