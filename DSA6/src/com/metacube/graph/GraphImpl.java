package com.metacube.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphImpl implements Graph{

	    private List<Integer>[] adjacenctVertices;
	    private int vertices;
	    private List<Edge> edgeList;
	    List<Integer> reachNode;

	    @SuppressWarnings("unchecked")
	    public GraphImpl(int vertices) {

	        this.vertices = vertices;
	        adjacenctVertices = new LinkedList[vertices];
	        edgeList = new LinkedList<Edge>();
	        for (int count = 0; count < vertices; count++) {
	            adjacenctVertices[count] = new LinkedList<Integer>();
	        }
	    }

	    /**
	     * method to add edges to the graph
	     * 
	     * @param source
	     * @param destination
	     * @param weight
	     */
	    public void addEdge(int source, int destination, int weight) {
	        Edge edge = new Edge(source, destination, weight);
	        adjacenctVertices[source].add(destination);
	        adjacenctVertices[destination].add(source);
	        edgeList.add(edge);
	    }

	    /**
	     * method to check whether graph is connected or not
	     */
	    @Override
	    public boolean isConnected() {
	        reachNode = new LinkedList<>();
	        return DFS(0);
	    }

	    /**
	     * method to return all reachable nodes
	     */
	    @Override
	    public List<Integer> reachable(int vertex) {
	        reachNode = new LinkedList<>();
	        DFS(vertex);
	        System.out.println();
	        return reachNode;
	    }

	    /**
	     * private method for DFS
	     * 
	     * @param sourceVertices
	     * @return
	     */
	    private boolean DFS(int sourceVertices) {
	        boolean visited[] = new boolean[vertices];
	        for (int count = 0; count < vertices; count++) {
	            visited[count] = false;
	        }
	        DFSUtility(sourceVertices, visited);
	        for (int count2 = 0; count2 < vertices; count2++) {
	            if (visited[count2] == false) {
	                return false;
	            }
	        }
	        return true;
	    }

	    /**
	     * helper method for DFS
	     * 
	     * @param source
	     * @param visited
	     */
	    private void DFSUtility(int source, boolean visited[]) {
	        System.out.println(source);
	        reachNode.add(source);
	        visited[source] = true;
	        Iterator<Integer> edgeIterator = adjacenctVertices[source].listIterator();
	        while (edgeIterator.hasNext()) {
	            int vertex = edgeIterator.next();
	            if (!visited[vertex])
	                DFSUtility(vertex, visited);
	        }
	    }

	    /**
	     * method to find the mst by prims algorithm
	     */
	    @Override
	    public List<Edge> mst() {
	        Set<Integer> visitedVertexSet = new HashSet<Integer>();
	        List<Edge> listOfVisitedEdge = new ArrayList<Edge>();
	        Collections.sort(edgeList);
	        if (edgeList.size() <= 0) {
	            throw new AssertionError("there are no edges in graph");
	        } else {
	            listOfVisitedEdge.add(edgeList.get(0));
	            visitedVertexSet.add(edgeList.get(0).getSource());
	            visitedVertexSet.add(edgeList.get(0).getDestination());

	            int count = 1;
	            while (visitedVertexSet.size() != vertices && count < edgeList.size()) {
	                Edge edge = edgeList.get(count);
	                if ((!visitedVertexSet.contains(edge.getSource()))
	                        || (!visitedVertexSet.contains(edge.getDestination()))) {
	                    listOfVisitedEdge.add(edge);
	                    visitedVertexSet.add(edge.getSource());
	                    visitedVertexSet.add(edge.getDestination());
	                } else {
	                    if ((visitedVertexSet.contains(edge.getSource()))
	                            && (visitedVertexSet.contains(edge.getDestination()))) {
	                        if (!(isCycle(listOfVisitedEdge, edge))) {
	                            listOfVisitedEdge.add(edge);
	                            visitedVertexSet.add(edge.getSource());
	                            visitedVertexSet.add(edge.getDestination());
	                        }
	                    }

	                }

	                count++;
	            }
	        }
	        if (visitedVertexSet.size() != vertices) {
	            throw new AssertionError("spanning tree not possible");
	        }
	        return listOfVisitedEdge;
	    }

	    /**
	     * check whether there is cycle in graph or not
	     * 
	     * @param visitedEdges
	     *            is a list of visited edges
	     * @param edge
	     *            is an edge
	     * @return
	     */
	    private boolean isCycle(List<Edge> visitedEdges, Edge edge) {
	        int startVertex = edge.getSource();
	        List<Edge> listOfEdges = new ArrayList<Edge>();
	        for (Edge graphEdge : visitedEdges) {
	            listOfEdges.add(graphEdge);
	        }
	        while (startVertex != edge.getDestination()) {
	            if (startVertex == -1) {
	                return false;
	            }
	            int endVertex = findEndVertex(listOfEdges, startVertex);
	            startVertex = endVertex;
	        }
	        if (startVertex == edge.getDestination()) {
	            return true;
	        }
	        return false;
	    }

	    /**
	     * find vertex corresponding to start vertex
	     * 
	     * @param tempList
	     *            is a list of visited edges
	     * @param startVertex
	     *            is a vertex
	     * @return end vertex
	     */
	    private int findEndVertex(List<Edge> listOfEdges, int startVertex) {
	        for (int count = 0; count < listOfEdges.size(); count++) {
	            if (listOfEdges.get(count).getSource() == startVertex) {
	                int vertex = listOfEdges.get(count).getDestination();
	                listOfEdges.remove(count);
	                return vertex;

	            } else {
	                if (listOfEdges.get(count).getDestination() == startVertex) {
	                    int vertex = listOfEdges.get(count).getSource();
	                    listOfEdges.remove(count);
	                    return vertex;
	                }
	            }
	        }
	        return -1;
	    }

	    public static void main(String[] args) {
	        GraphImpl graph = new GraphImpl(4);
	        graph.addEdge(2, 0, 2);
	        graph.addEdge(0, 1, 4);
	        graph.addEdge(1, 3, 3);
	        graph.addEdge(2, 3, 1);
	        System.out.println(graph.isConnected());
	        System.out.println(graph.reachable(2));

	        List<Edge> list = graph.mst();
	        for (Edge edge : list) {
	            System.out.println(edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight());
	        }

	    }
	    @Override
	    public int shortestPath(int vertex1, int vertex2) {
	        // TODO Auto-generated method stub
	        return 0;
	    }

}
