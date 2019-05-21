/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.ui;

import java.awt.event.ActionEvent;

/**
 *
 * @author marc-
 */
public class GraphEvent {
    
    Object source;
    ActionEvent event;
    
    public GraphEvent(Object source, ActionEvent event) {
        
        this.source = source;
        this.event = event;
       
    }
    
}
