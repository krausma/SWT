/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.GraphNode;
import de.btu.swt.graph.api.GraphNodeFactory;

/**
 *
 * @author marc-
 */
public class GraphNodeFactoryImpl implements GraphNodeFactory{
    
    public final static String PARENT = "parent";
    public final static String LEAF = "leaf";

    @Override
    public GraphNode createGraphNode(String className, String nodeName) {
        
        if(nodeName == null || "".equals(nodeName)) {
            
            nodeName = "Defaultname";
        }
        
        if(className.equals(PARENT)) {
            
            return new Parent(nodeName);
        }
        
        if(className.equals(LEAF)) {
            
            return new Leaf(nodeName);
        }
        
        return null;
    }
    
}
