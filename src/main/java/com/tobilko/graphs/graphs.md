### Graphs

**Graph** is a set of vertices [notes, points] in which some pairs are wired by edges [arcs, lines].
**Path** is a sequence of vertices and edges that depicts hopping along graph.

**Types of graphs:**

- directed
- undirected
- weighted (the weight is assigned to each edge)
- complete
- dense
- sparse

**Adjacency matrices:**

 - [+] math representation
 - [+] fast to get edges (`O(1)`)
 - [+] fast to add/remove edges (`O(1)`)
 - [-] show to add (`O(|V|²))`) and to remove vertices (`O(|V|²)`)
 - [-] requires a lot of memory `O(|V|²)`
 
 **Adjacency lists**

 - [+] uses a lot less memory than adjacency matrix (`O(|V| + |E|)`)
 - [+] fast to add edges/vertices (`O(1)`)
 - [+] good to remove edges/vertices (`O(|E|)`)