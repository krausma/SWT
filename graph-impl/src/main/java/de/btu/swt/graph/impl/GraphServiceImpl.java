/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.GraphModel;
import de.btu.swt.graph.api.GraphService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
@ServiceProvider(service = GraphService.class)
public class GraphServiceImpl implements GraphService {

    @Override
    public GraphModel getModel() {
        return null;
    }

    @Override
    public void createDefaultGraph1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createDefaultGraph2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
