/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.btu.swt.graph.api;

/**
 *
 * @author marc-
 */
public interface GraphNodeFactory {

   GraphNode createGraphNode(String className, String nodeName);
}
