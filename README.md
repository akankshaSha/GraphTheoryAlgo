# Graph Theory

notes and code from free code camp's
[youtube tutorial](https://www.youtube.com/watch?v=09_LlHjoEiY)
creted by William Fiset  

## Introduction

Graph Theory is the mathematical theory of thr properties and application of graphs (network).  

### Types of Graph

- **Undirected Graph**: a type of graph in which edges have no orientation, i.e, the edge (u, v) is identical to
edge (v, u)
![undirected graph](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/undirected%20graph.jpg?raw=true)
- **Directed Graphs**: (aka: diagraph) a type of graph in which edges have orientation, i.e, (u, v) is the edge from node u to node v
![directed graph](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/directed%20graph.jpg?raw=true)

- **Weighted Graph**: graphs with weights assigned to its edges that represent some arbitrary value such as cost, distance, quantity, etc...  
*(note: edges of weighted graph will be denoted as (u, v, w))*

### Special Graphs

- **Tree**: a tree is a undirected graph with no cycles. Equivalently, it is a connected graph with N nodes and N-1 edges
![tree](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/tree.jpg?raw=true)
- **Rooted Tree**: it is a tree with a designated *root node*, where every edge either points away from or towards the root node. When edges point away from the root, the graph is called an *arborescence (out-tree)* and *anti arborescence (in-tree) otherwise*
![rootes tree](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/rooted%20trees.jpg?raw=true)
- **Directed Acyclic graphs**: (aka: DAG) directed graphs with no cycle. These graphs play an important role in representing structures with dependencies (eg: sceduler, build system, compiler, uni class pre-requisites), Several efficient algorithms exist to operate in DAGs. (eg: topological ordering of nodes)
![DAG](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/DAG.jpg?raw=true)
*(cool fact: all out trees are DAGs, but not all DAGs are out trees)*
- **Bipartide Graph**: it a graph whose vertices can be split into two independent groups U, V such that every edge connects between U and V.
![Bipartide](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/bipartide%20graphs.jpg?raw=true)  
other definations:
  - two-colorable graph
  - no odd length cycle
- **complete graph**: a graph where there's a unique edge between every pair of nodes. A complete graph with n vertices is denoted as the graph Kn
![k6](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/complete%20graph.jpg?raw=true)

## Representing Graphs

- **Adjacency Matrix**: m[i][j] represents the edge weight of going from node i to j
![adj mat](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/adjecency%20matrix.jpg?raw=true) 
|Pros |Cons
|--- |---
|Splace Efficient for representing dense graphs |Requires Θ(V²) space
|Edge Weight lookup is O(1) |Iterateing over all edges take Θ(V²) time
|Simplest Graph representation |  

- **Adjecency List**: represent a grpah as a map from nodes to list of edges
![adj lst](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/adjecencey%20list.jpg?raw=true)
|Pros |Cons
|--- |---
|Space efficient for representing sparse graph | Less space efficient for dense graphs
|Iterating over all edges is efficient | Edge weight look up os O(E)
|  | Slightly more complex grph representation

- **Edge List**: unordered list of edges (in form of triplets (u, v, w))
![edge lst](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/Edge%20List.jpg?raw=true)  
*Note: this form of representation is seldomply used because of its lack of structure. However it is conceptually simple and practical in a handful of algorithms*  

|Pros |Cons
|--- |---
|Space efficient for representing sparse graph | Less space efficient for dense graphs
|Iterating over all edges is efficient | Edge weight look up os O(E)
|Very Simple Structure |  

## Common Graph Theory Problems

before begining any problem, ask yourself:
![questions](https://github.com/akankshaSha/GraphTheoryAlgo/blob/main/Images/stating%20a%20problem.jpg?raw=true)

## DFS

a dfs plunges depth first search into a graph without regard for which edge it takes next until it cannot go any further at which point it backtracks and continues  
[!dfs](https://www3.cs.stonybrook.edu/~skiena/combinatorica/animations/anim/dfs.gif)