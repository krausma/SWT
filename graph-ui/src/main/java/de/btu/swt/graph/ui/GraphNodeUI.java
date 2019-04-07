/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.ui;

import de.btu.swt.graph.api.GraphNode;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public class GraphNodeUI extends AbstractNode {

    public GraphNodeUI(GraphNode node) {
        super(node.isLeaf() ? Children.LEAF : Children.create(new NodeChildrenFactory(node), Boolean.FALSE));
        setName(node.getName());
        setDisplayName(node.getName());
    }
}
