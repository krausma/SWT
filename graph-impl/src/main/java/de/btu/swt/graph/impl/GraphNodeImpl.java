/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.GraphModel;
import de.btu.swt.graph.api.GraphNode;
import java.util.Stack;
import java.util.stream.Stream;


/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */

public abstract class GraphNodeImpl implements GraphNode {
     long keyId;
    String nodeName;
     Parent p; // eventual parent of Node
    private boolean root = true;
    
    
    
    @Override
    public long getID() {
        return keyId;
    }
    // returns the Name
    @Override
    public String getName() {
        return nodeName;
    }

    @Override
    public abstract GraphNode getChildAt(int index);

    @Override
    public abstract int getChildCount();

    @Override
    public abstract Stream<GraphNode> children();

    @Override
    public GraphNode getParent() {
        if(root == false){
            return p;
        }else{
            return null;
        }
    }
    
    // sets the parent of this node
    @Override
    public void setParent(GraphNode parent) {
        // check if the object is a leaf to potentially remove object from the child-list of former parent
       if(this.root == false){
           this.p.Children.remove(this);
       }
        this.p = (Parent)parent;
        root = false;
        this.p.Children.add(this);
    }

   @Override
    public boolean hasParent() {
        return !root;
    }

    @Override
    public abstract boolean isLeaf();

    @Override
    public abstract boolean isParentOf(GraphNode node);

    @Override
    public abstract int getIndexOf(GraphNode child);

    @Override
    public abstract Stream<GraphNode> descendants() ;

    @Override
    public abstract Stream<GraphNode> leafs();
    
    @Override
    public Stream<GraphNode> ancestors() {
         Stack<GraphNode> out = new Stack(); // stack to return
         out.push(this);
         if(this.root == false){
             out.addAll((Stack<GraphNode>) this.ancestors());
         }
         return out.stream();
    }

    @Override
    public Stream<GraphNode> siblings() {
        
        Stack<GraphNode> out = new Stack();
        out.addAll(this.p.Children);
        
        if(this.hasParent()){
        out.remove(this);
        }
         return out.stream();
    }

    @Override
    public boolean isAncestorOf(GraphNode node) {
        if(this.hasParent() == false){
            return false;
        }else{
            Stack<GraphNode> out = new Stack();
            out.addAll((Stack<GraphNode>) this.ancestors());
            if(out.search(node) != -1){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public int getDepth() {
       return (int)this.ancestors().count();
    }

    @Override
    public long getWeight() {
        return this.leafs().count();
    }


}
