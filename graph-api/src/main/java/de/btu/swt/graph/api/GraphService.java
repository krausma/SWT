/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.api;

/**
 * The graph service instance can be retrieved using:
 *
 * <pre>
 * {@code Lookup.getDefault().lookup(GraphService.class)}
 * </pre>
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public interface GraphService {

    /**
     * Retrieves and returns the current graph model used for the data
     * visualization.
     *
     * @return The current graph model.
     */
    GraphModel getModel();

    /**
     * Creates a balanced tree with 3 parent and 4 leaf nodes and a maximum
     * depth of 3.
     */
    void createDefaultGraph1();

    /**
     * Creates an unbalanced tree with 3 parent and 4 leaf nodes and a maximum
     * depth of 4.
     */
    void createDefaultGraph2();

}
