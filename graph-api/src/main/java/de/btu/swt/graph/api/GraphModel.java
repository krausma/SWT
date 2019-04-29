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
public interface GraphModel {

    /**
     * @return The schema containing meta information (like metrics) for all the
     * graph nodes.
     */
    Schema nodeSchema();

    /**
     * @return A fresh stream iterating over all nodes of this graph model. In
     * case of an empty graph an empty stream is returned.
     */
    Stream<GraphNode> nodes();

    /**
     * Retrieves and return the number of all nodes in the graph.
     *
     * @return The number of nodes.
     */
    int nodeCount();

    /**
     * @param id The id of the requested getNode.
     * @return The getNode with the given id.
     */
    GraphNode getNode(int id);

    /**
     * @return Retrieves and returns the root node of this graph.
     */
    GraphNode getRoot();

    /**
     * @param node The getNode that may be part of this graph.
     * @return true if the given getNode is contained in this graph or false
     * otherwise.
     */
    boolean contains(GraphNode node);

    /**
     * Adds the given getNode to this graph. The parent getNode must exist in
     * the graph to become the parent getNode of {@code getNode}. If
     * {@code null} is passed as argument for parent the getNode is attached to
     * the root getNode.
     *
     * @param node
     * @param parent
     * @return {@code true} if the given getNode could be added as child to the
     * given parent getNode and {@code false} otherwise.
     */
    boolean addNode(GraphNode node, GraphNode parent);

    /**
     * Completely removes the given getNode from this graph model by detaching
     * it from its parent and deleting it from the underlying index structure.
     *
     * @param node The getNode to remove.
     * @return {@code true} if and only if the getNode could be removed or
     * {@code false} otherwise.
     */
    boolean remove(GraphNode node);

    /**
     * Makes {@code newParent} the new parent of {@code getNode}. Both nodes
     * must be part of this graph.
     *
     * @param node
     * @param newParent
     */
    void moveNode(GraphNode node, GraphNode newParent);

    /**
     * Clears the whole graph model by deleting all data including the getNode
     * elements.
     */
    void clear();

    /**
     * Adds a new metric the corresponding node schema.
     *
     * @param metric The metric to add.
     */
    void addMetric(Metric metric);

    /**
     * Removes the given metric from the corresponding node schema and clear all
     * related metric values.
     *
     * @param metric The metric to remove.
     */
    void removeMetric(Metric metric);
}
