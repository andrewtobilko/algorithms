package com.tobilko.ai.lab1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Stream.of;

public class Main {

    public static void main(String[] args) throws IOException {

        doTask(readFromFile("graph.data"), 2, 13);
    }

    private static Graph readFromFile(String fileName) throws IOException {
        final Edge[] edges = Files.lines(Paths.get(fileName)).map(l -> {
            final String[] values = l.split(" ");
            return new Edge(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
        }).toArray(Edge[]::new);

        return new Graph(edges);
    }

    private static int[] lengths;

    private static void doTask(Graph graph, int from, int to) {
        final Edge[] edges = graph.getEdges();
        final int[] vertices = of(edges)
                .flatMap(edge -> of(edge.getA(), edge.getB()))
                .collect(Collectors.toSet())
                .stream()
                .mapToInt(Integer::valueOf)
                .toArray();

        final int maxLength = IntStream.of(vertices).max().getAsInt() + 1;

        boolean[] visited = new boolean[maxLength];
        lengths = new int[maxLength];


        Queue<Integer> queue = new LinkedList<>();

        queue.add(from);
        visited[from] = true;

        while (!queue.isEmpty()) {
            int w = queue.remove();

            for (int j = 0; j < edges.length; j++) {

                final Edge edge = edges[j];

                Integer k = GraphUtil.getAdjacentVertex(edge, w);

                if (k == null) {
                    continue;
                }

                if (!visited[k]) {
                    lengths[k] = lengths[w] + 1;

                    if (k == to) {
                        System.out.println("the answer is " + lengths[k]);
                        return;
                    }
                    visited[k] = true;
                    queue.add(k);
                }

            }

        }
    }

}

final class Edge {
    private final int a;
    private final int b;

    public Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return String.format("[%d <-> %d]", a, b);
    }

}

class Graph {
    private final Edge[] edges;

    public Graph(Edge[] edges) {
        this.edges = edges;
    }

    public Edge[] getEdges() {
        return Arrays.copyOf(edges, edges.length);
    }

}

class GraphUtil {
    public static Integer getAdjacentVertex(Edge edge, int vertex) {
        final int a = edge.getA();
        final int b = edge.getB();

        if (a != vertex && b != vertex) {
            return null;
        }

        return a == vertex ? b : a;
    }
}
