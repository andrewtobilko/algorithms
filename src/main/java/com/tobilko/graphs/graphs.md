### Graphs

**Main definitions:**

*Graph* - a set of vertices [notes, points] in which some pairs are wired by edges [arcs, lines].
*Path* - a sequence of vertices and edges that depicts hopping along graph.

*Vertex degree* - the sum of in-degree (a number of endpoint edges) and out-degree (a number of start point edges).
*Distance* - is the shortest length of a path between two vertices.

*Path length* - the number of times it traverses edges.
*Path cost* - the sum of the weights of each of the edges it traverses.


**Types of graphs:**

- directed
- undirected
- weighted (the weight is assigned to each edge)
- complete
- dense
- sparse

**Adjacency matrices:**

    0 1 0                   
    1 0 0        =>         0 -> 1, 1 -> 0   
    0 0 0

 - [+] math representation
 - [+] fast to get edges (`O(1)`)
 - [+] fast to add/remove edges (`O(1)`)
 - [-] show to add (`O(|V|²))`) and to remove vertices (`O(|V|²)`)
 - [-] requires a lot of memory `O(|V|²)`
 
 **Adjacency lists:**

    0 -> [1]
    1 -> [0]

 - [+] built-in and programmatically convenient implementation
 - [+] fast to add edges/vertices (`O(1)`)
 - [?] uses a lot less memory than adjacency matrix (`O(|V| + |E|)`)
 - [?] removing edges/vertices (`O(|E|)`)
 - [?] getting (`O(|V|)`)