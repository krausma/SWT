/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.ui;

import de.btu.swt.graph.api.GraphNode;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public class NodeChildrenFactory extends ChildFactory<GraphNode> {

    private final GraphNode node;

    public NodeChildrenFactory(GraphNode node) {
        this.node = node;
    }

    @Override
    protected boolean createKeys(List<GraphNode> list) {
        node.children()
                .sorted((n1, n2) -> n1.getName().compareToIgnoreCase(n2.getName()))
                .forEach(list::add);
        return Boolean.TRUE;
    }

    @Override
    protected Node createNodeForKey(GraphNode node) {
        return new GraphNodeUI(node);
    }
}
