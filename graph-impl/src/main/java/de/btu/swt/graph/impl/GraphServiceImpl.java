/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.GraphModel;
import de.btu.swt.graph.api.GraphService;
import org.openide.util.lookup.ServiceProvider;
import java.util.Arrays;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
@ServiceProvider(service = GraphService.class)
public class GraphServiceImpl implements GraphService {

      // root Node + Model
       Parent root = new Parent(1,"root");
      GraphModelImpl model = new GraphModelImpl(root); ;
      
    @Override
    public GraphModel getModel() {
        return model;
    }

    @Override
    public void createDefaultGraph1() {
      
       model.clear();
        
      //other Nodes: 2 Parent-nodes + 4 Leaf-nodes
      Parent p1 = new Parent (99, "p1");
      Parent p2 = new Parent (2, "p2");
      Leaf l1 = new Leaf (3, "l1");
      Leaf l2 = new Leaf (4, "l2");
      Leaf l3 = new Leaf (5, "l3");
      Leaf l4 = new Leaf (6, "l4");
      
      // put them into the model
      
      model.addNode(p1, model.getRoot());
      model.addNode(p2, model.getRoot());
      model.addNode(l1, p1);
      model.addNode(l2, p1);
      model.addNode(l3, p2);
      model.addNode(l4, p2);
    }

    @Override
    public void createDefaultGraph2() {
    
        model.clear();
     

        //other Nodes: 2 Parent-nodes + 4 Leaf-nodes
      Parent p1 = new Parent (1, "p1");
      Parent p2 = new Parent (2, "p2");
      Leaf l1 = new Leaf (3, "l1");
      Leaf l2 = new Leaf (4, "l2");
      Leaf l3 = new Leaf (5, "l3");
      Leaf l4 = new Leaf (6, "l4");
      
      // put them into the model
      model.addNode(p1, model.getRoot());
      model.addNode(p2, p1);
      model.addNode(l1, model.getRoot());
      model.addNode(l2, p1);
      model.addNode(l3, p2);
      model.addNode(l4, p2);
    }

}
