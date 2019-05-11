/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;


import de.btu.swt.graph.api.GraphNode;
import java.util.Stack;
import java.util.stream.Stream;
import de.btu.swt.graph.impl.GraphNodeImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */

public class Parent extends GraphNodeImpl {
    private long keyId; //unique ID of Node
    private String nodeName; // Name of Node
    private Parent p; // eventual parent of Node
    private boolean root = true; //if Node Root
    public List<GraphNode> Children; //List of Children of Node
            
    //constructor of the Node
    public Parent (long id, String name){
        keyId = id;
        nodeName = name;
        Children = new ArrayList<GraphNode>();
    }
    
    // returns the ID
   
    // returns the Child number "index" if it exists
    @Override
    public GraphNode getChildAt(int index) {
        if(index < 0 || index >= Children.size()){
            throw new IndexOutOfBoundsException();
        }else{
            return Children.get(index);
        }
    }
    
    // returns the number of childs
    @Override
    public int getChildCount() {
       return p.Children.size();
    }
    
    //returns all childs of this node
    @Override
    public Stream<GraphNode> children() {
        return Children.stream();
    }

 
   
    
    // checks if a parent  exists for this node
 
    
    // checks if this node is a leaf/has no children
    @Override
    public boolean isLeaf() {
        if(Children.size()== 0){
            return true;
        }else{
            return false;
        }
    }
    
    // checks if imput is the parent of this node
    @Override
    public boolean isParentOf(GraphNode node) {
        return Children.contains(node);
    }
    
    // returns the child index of input if it exists
    @Override
    public int getIndexOf(GraphNode child) {
        if(this.isParentOf(child)){
            return Children.indexOf(child);
        }else{
            return (-1);
        }
    }

    @Override
    public Stream<GraphNode> descendants() {
        List<GraphNode> des = new ArrayList<GraphNode>();
        
        des.add(this);
       
        if (this.isLeaf()){
            return des.stream();
            
        
        
        }else{
            
            
            for(int i = 1;i <= Children.size();i++){
            des.addAll(this.Children.get(i).descendants().collect(Collectors.toList()));
            
            }
            return des.stream();
        }
    }

    @Override
    public Stream<GraphNode> leafs() {
      return this.descendants().filter(l -> l.isLeaf());
    }

}
