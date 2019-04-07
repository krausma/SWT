/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.api;

import java.util.stream.Stream;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public interface GraphNode {

    /**
     * Each graph element is defined by unique long identifier. Multiple graph
     * nodes with the same id cannot be registered to the same model.
     *
     * @return The node id.
     */
    long getID();

    /**
     * @return The name of this graph node.
     */
    String getName();

    /**
     * Retrieves and returns the child node at the given {@code index}.
     *
     * @param index The index of the child in the underlying list.
     * @return The child node at the given index.
     * @throws IndexOutOfBoundsException
     */
    GraphNode getChildAt(int index);

    /**
     * Computes and returns the number of children of this parent node.
     *
     * @return The number of child nodes.
     */
    int getChildCount();

    /**
     * Retrieves the child nodes of this node or an empty stream in case this
     * node is a leaf node.
     *
     * @return A fresh stream over all child nodes of this node.
     */
    Stream<GraphNode> children();

    /**
     * Retrieves and returns the parent node of this node. In case this node has
     * no parent {@code null} is returned.
     *
     * @return The parent node of this node.
     */
    GraphNode getParent();

    /**
     * sets parent everytime the Node is added or moved
     *
     * @param parent
     */
    void setParent(GraphNode parent);

    /**
     * Checks whether this node is a root or not.
     *
     * @return {@code true} if this node has a parent or {@code false}
     * otherwise.
     */
    boolean hasParent();

    /**
     * Is true, when node has no children.
     *
     * @return {@code true} if the node is a leaf (has no children) or
     * {@code false} otherwise.
     */
    boolean isLeaf();

    /**
     * Checks whether this node is the parent of the given node.
     *
     * @param node The node that may be a child of this node.
     * @return {@code true} if this node is the parent of the given child node.
     */
    boolean isParentOf(GraphNode node);

    /**
     * @param child The child node to check the index for.
     * @return The index (equal to or greater than 0) in case this node is the
     * parent of the given child node or -1 otherwise.
     */
    int getIndexOf(GraphNode child);

    /**
     * Retrieves all descendant nodes of this node including this node.
     *
     * @return The descendant nodes of this node.
     */
    Stream<GraphNode> descendants();

    /**
     * Retrieves and returns all leafs in the sub tree this node is the root
     * node for.
     *
     * @return All leaf nodes of this node.
     */
    Stream<GraphNode> leafs();

    /**
     * Retrieves and returns a stream over all ancestors of this node starting
     * from the nodes parent to the graphs root node.
     *
     * @return A new stream over all ancestors starting with the parent of this
     * node.
     */
    Stream<GraphNode> ancestors();

    /**
     * Retrieves and returns a stream over all siblings of this node. In a
     * parent child relationship between a parent p and a child c siblings(c)
     * are all nodes that are children of p except c.
     *
     * @return A fresh stream over all siblings of this node.
     */
    Stream<GraphNode> siblings();

    /**
     * Checks whether this node is an ancestor of the given node.
     *
     * @param node The node that may be a descendant of this.
     * @return {@code true} if this node is an ancestor of {@code node} or
     * {@code false} otherwise.
     */
    boolean isAncestorOf(GraphNode node);

    /**
     * Computes and returns the depth of this node in the hierarchy (the number
     * of ancestors).
     *
     * @return The depth in the hierarchy.
     */
    int getDepth();

    /**
     * is the count of leafs under this node
     *
     * @return the weight of the GraphNode
     */
    long getWeight();
}
