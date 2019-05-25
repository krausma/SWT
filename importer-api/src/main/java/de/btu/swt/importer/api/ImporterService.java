/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.importer.api;

import de.btu.swt.importer.spi.Importer;
import java.util.stream.Stream;

/**
 * The import service acts as a facade for the import module and allows to load
 * external data using a specific importer.
 * <pre>
 * {@code Lookup.getDefault().lookup(ImporterService.class)}
 * </pre>
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public interface ImporterService {

    /**
     * Loads a graph using the given importer.
     *
     * @param importer to load the graph data with.
     */
    void importGraph(Importer importer);

    /**
     * Retrieves and returns all currently available importers.
     *
     * @return A stream iterating over all importers.
     */
    Stream<? extends Importer> importers();
}
