/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;


import de.btu.swt.graph.api.GraphNode;
import java.util.Stack;
import java.util.stream.Stream;


/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */

public class Parent implements GraphNode {
    private int keyId = 0;
    private String nodeName = "Nobody";
    private Parent p;
    private boolean root = true;
    public Stack<GraphNode> Children = new Stack();
            
    public Parent (int id, String name){
        keyId = id;
        nodeName = name;
    }
    
    @Override
    public long getID() {
        return keyId;
    }

    @Override
    public String getName() {
        return nodeName;
    }

    @Override
    public GraphNode getChildAt(int index) {
        if(index < 0 || index >= Children.size()){
            throw new IndexOutOfBoundsException();
        }else{
            return Children.get(index);
        }
    }

    @Override
    public int getChildCount() {
       return p.Children.size();
    }

    @Override
    public Stream<GraphNode> children() {
        return Children.stream();
    }

    @Override
    public GraphNode getParent() {
        if(root == false){
            return p;
        }else{
            return null;
        }
    }

    @Override
    public void setParent(GraphNode parent) {
        p = (Parent)parent;
        root = false;
        p.Children.addElement(this);
    }

    @Override
    public boolean hasParent() {
        return !root;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isParentOf(GraphNode node) {
        if(Children.search(node) == -1){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public int getIndexOf(GraphNode child) {
        return Children.search(child);
    }

    @Override
    public Stream<GraphNode> descendants() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<GraphNode> leafs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<GraphNode> ancestors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<GraphNode> siblings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAncestorOf(GraphNode node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDepth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
