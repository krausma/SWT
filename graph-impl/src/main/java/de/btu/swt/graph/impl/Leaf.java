/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.impl.GraphNodeImpl;
import de.btu.swt.graph.api.GraphModel;
import de.btu.swt.graph.api.GraphNode;
import java.util.stream.Stream;


/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */

public class Leaf extends GraphNodeImpl {
 
   
    
    public Leaf (String name){
        
        super();
        nodeName = name;
        root = true;
    }
    
    

    @Override
    public GraphNode getChildAt(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public Stream<GraphNode> children() {
        return Stream.of();
    }


    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean isParentOf(GraphNode node) {
       return false;
    }

    @Override
    public int getIndexOf(GraphNode child) {
        return -1;
    }

    @Override
    public Stream<GraphNode> descendants() {
        return Stream.of(this);
    }

    @Override
    public Stream<GraphNode> leafs() {
        return Stream.of(this);
    }

    @Override
    public float getValue(String metric) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValue(String metric, float value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
