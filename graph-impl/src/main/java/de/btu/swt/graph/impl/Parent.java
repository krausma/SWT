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

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */

public class Parent extends GraphNodeImpl {
    private int keyId = 0; //unique ID of Node
    private String nodeName = "Nobody"; // Name of Node
    private Parent p; // eventual parent of Node
    private boolean root = true; //if Node Root
    public Stack<GraphNode> Children = new Stack(); //List of Children of Node
            
    //constructor of the Node
    public Parent (int id, String name){
        keyId = id;
        nodeName = name;
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
        if(Children.size()==0){
            return true;
        }else{
            return false;
        }
    }
    
    // checks if imput is the parent of this node
    @Override
    public boolean isParentOf(GraphNode node) {
        if(Children.search(node) == -1){
            return false;
        }else{
            return true;
        }
    }
    
    // returns the child index of input if it exists
    @Override
    public int getIndexOf(GraphNode child) {
        return Children.search(child);
    }

    @Override
    public Stream<GraphNode> descendants() {
        Stack<GraphNode> des = new Stack();
        
        des.push(this);
       
        if (this.isLeaf()){
            return des.stream();
            
        
        
        }else{
            
            
            for(int i = 1;i <= Children.size();i++){
            des.addAll((Stack<GraphNode>) Children.elementAt(i).descendants());
            
            }
            return des.stream();
        }
    }

    @Override
    public Stream<GraphNode> leafs() {
        Stack<GraphNode> lea = new Stack(); // stack to receive descendents of this node
        Stack<GraphNode> out = new Stack(); // stack to return
        lea = (Stack<GraphNode>) this.descendants(); // get all desendants
        

        // chekc for leafs in desendents and put them into out
        for(int i = 1; i <= lea.size();i++){ 
            if(lea.elementAt(i).isLeaf()){
                out.push(lea.elementAt(i));
            }
        }
        return out.stream();
    }

}
