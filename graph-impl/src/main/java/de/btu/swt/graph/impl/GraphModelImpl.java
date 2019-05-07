/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.GraphModel;
import de.btu.swt.graph.api.GraphNode;
import de.btu.swt.graph.api.Metric;
import de.btu.swt.graph.api.Schema;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Marc
 */
public class GraphModelImpl implements GraphModel{

    Schema schema;
    GraphNode root;
    
    
    @Override
    public Schema nodeSchema() {
 
        return this.schema;
    }

    @Override
    public Stream<GraphNode> nodes() {

      return this.root.descendants();
    }

    @Override
    public int nodeCount() {
 
        return (int) nodes().count();
    }

    @Override
    public GraphNode getNode(int id) {
   
           Iterator<GraphNode> iterator = nodes().iterator();
           
           while(iterator.hasNext()) {
               
               GraphNode node = iterator.next(); 
               if(node.getID() == id) {
                   
                   return node; 
               }
           }
         return null;
    }

    @Override
    public GraphNode getRoot() {
 
        return this.root;
    }

    @Override
    public boolean contains(GraphNode node) {
  
        Iterator<GraphNode> iterator = nodes().iterator();

        while(iterator.hasNext()) {

            GraphNode currentNode = iterator.next(); 
            if(node.getID() == currentNode.getID()) {

                return true; 
            }
        }
        return false;
    }

    @Override
    public boolean addNode(GraphNode node, GraphNode parent) {
   
        if(parent == null) {
            
            node.setParent(root);
            return false;
        }
        node.setParent(parent);
   
        return true;
    }

    @Override
    public boolean remove(GraphNode node) {
   
        GraphNode currentNode = getNode((int) node.getID());
        
        if(! contains(currentNode)) { return false; }
        
        if(currentNode == null) { return false; }
        
        currentNode.setParent(null);
        return true;
    }

    @Override
    public void moveNode(GraphNode node, GraphNode newParent) {
   
        if(! contains(node)) { return; }
        
        if(! contains(newParent)) { return; }
        
        node.setParent(newParent);
   
    }

    @Override
    public void clear() {
   
        this.root = null;
    }

    @Override
    public void addMetric(Metric metric) {
  
        this.schema.add(metric);
    }

    @Override
    public void removeMetric(Metric metric) {
  
        this.schema.remove(metric);
    }
    
}
