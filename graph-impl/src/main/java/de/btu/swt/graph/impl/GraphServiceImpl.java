/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.GraphModel;
import de.btu.swt.graph.api.GraphNode;
import de.btu.swt.graph.api.GraphNodeFactory;
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
       Parent root = new Parent("root");
      GraphModelImpl model = new GraphModelImpl(root); 
      GraphNodeFactory graphNodeFactory = new GraphNodeFactoryImpl();
      
    @Override
    public GraphModel getModel() {
        return model;
    }

    @Override
    public void createDefaultGraph1() {
      
       model.clear();
        
      //other Nodes: 2 Parent-nodes + 4 Leaf-nodes
      GraphNode p1 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.PARENT, "p1");
      GraphNode p2 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.PARENT, "p2");
      GraphNode l1 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.LEAF, "l1");
      GraphNode l2 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.LEAF, "l2");   
      GraphNode l3 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.LEAF, "l3");
      GraphNode l4 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.LEAF, "l4");   
      
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
      GraphNode p1 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.PARENT, "p1");
      GraphNode p2 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.PARENT, "p2");
      GraphNode l1 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.LEAF, "l1");
      GraphNode l2 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.LEAF, "l2");   
      GraphNode l3 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.LEAF, "l3");
      GraphNode l4 = graphNodeFactory.createGraphNode(GraphNodeFactoryImpl.LEAF, "l4");  
      
      // put them into the model
      model.addNode(p1, model.getRoot());
      model.addNode(p2, p1);
      model.addNode(l1, model.getRoot());
      model.addNode(l2, p1);
      model.addNode(l3, p2);
      model.addNode(l4, p2);
    }

}
