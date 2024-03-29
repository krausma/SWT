/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.GraphEventListener;
import de.btu.swt.graph.api.GraphModel;
import de.btu.swt.graph.api.GraphNode;
import de.btu.swt.graph.api.GraphNodeFactory;
import de.btu.swt.graph.api.Metric;
import de.btu.swt.graph.api.ObservableGraph;
import de.btu.swt.graph.api.Schema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 *
 * @author Marc
 */
public class GraphModelImpl implements GraphModel{

    Schema schema;
    GraphNode root;
    List<GraphEventListener> listenerList = new ArrayList();
    GraphNodeFactory factory = new GraphNodeFactoryImpl();
    
    public GraphModelImpl(GraphNode RootNode){
        root = RootNode;
    
        notifyObserver();
    }
    
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
            return true;
        }
        node.setParent(parent);
   
        notifyObserver();
        return true;
    }

    @Override
    public boolean remove(GraphNode node) {
   
        GraphNode currentNode = getNode((int) node.getID());
        
        if(! contains(currentNode)) { return false; }
        
        if(currentNode == null) { return false; }
        
        currentNode.setParent(null);
        
        notifyObserver();
        return true;
    }

    @Override
    public void moveNode(GraphNode node, GraphNode newParent) {
   
        if(! contains(node)) { return; }
        
        if(! contains(newParent)) { return; }
        
        node.setParent(newParent);
        notifyObserver();
    }

    @Override
    public void clear() {
   
        this.root = factory.createGraphNode(GraphNodeFactoryImpl.PARENT, "root");
        notifyObserver();
    }


    public void addMetric(Metric metric) {
  
        this.schema.add(metric);
        notifyObserver();
    }

    public void removeMetric(Metric metric) {
  
        this.schema.remove(metric);
        notifyObserver();
    }

    @Override
    public void attach(GraphEventListener listener) {
      
        listenerList.add(listener);
    }

    @Override
    public void detach(GraphEventListener listener) {
        
        listenerList.remove(listener);
    }

    @Override
    public void notifyObserver() {
       
        
        for ( GraphEventListener listener : listenerList ) {

              listener.onGraphChanged();
              
        }
    }
}
    

