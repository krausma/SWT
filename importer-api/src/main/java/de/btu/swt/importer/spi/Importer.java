/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.importer.spi;

import de.btu.swt.graph.api.GraphModel;

/**
 * A importer handles a specific data source and transforms its data to the
 * graph.
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public interface Importer {

    /**
     * Retrieves and returns the unique identifier for this importer.
     *
     * @return The name of this importer.
     */
    String getName();

    /**
     * Fetches data from given data source and transforms the data into the
     * graph.
     *
     * @param graph The graph that is used to store the imported data.
     */
    void execute(GraphModel graph);
}
