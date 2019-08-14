package com.metacube.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GraphTest {

    @Test
    public void testConnectivityReturnsTrue() {
        GraphImpl graph = new GraphImpl(4);
        graph.addEdge(2, 0, 2);
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 3, 3);
        assertEquals(true, graph.isConnected());
    }

    @Test
    public void testConnectivityReturnsFalse() {
    	GraphImpl graph = new GraphImpl(4);
        graph.addEdge(2, 0, 2);
        graph.addEdge(0, 1, 4);
        assertEquals(false, graph.isConnected());
    }

    @Test
    public void testReachable() {
    	GraphImpl graph = new GraphImpl(4);
        graph.addEdge(2, 0, 2);
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 3, 3);
        List<Integer> listOfReachables=new LinkedList<>();
        listOfReachables.add(0);
        listOfReachables.add(1);
        listOfReachables.add(2);
        listOfReachables.add(3);
        List<Integer> result=graph.reachable(0);
        for(int count=0;count<result.size();count++){
            assertEquals(true,listOfReachables.contains(result.get(count)));
        }
        assertEquals(true, graph.isConnected());
    }
    @Test
    public void testMSTReturnsEdgesOfMst(){
    	GraphImpl graph = new GraphImpl(4);
        graph.addEdge(2, 0, 2);
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 1);
        List<Edge> result = graph.mst();
        List<Edge> expected=new ArrayList<>();
        expected.add(new Edge(2,3,1));
        expected.add(new Edge(2,0,2));
        expected.add(new Edge(1,3,3));
        for (int count=0;count<result.size();count++) {
           assertEquals(expected.get(count).getSource(),expected.get(count).getSource());
           assertEquals(expected.get(count).getDestination(),expected.get(count).getDestination());
        }
        
    }
}