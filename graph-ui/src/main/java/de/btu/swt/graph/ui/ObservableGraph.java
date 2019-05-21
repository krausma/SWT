/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.ui;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author marc-
 */
public class ObservableGraph {
    
  private final List<GraphEventListener> listeners = new ArrayList<>();

  public void addListener( GraphEventListener listener ) {
      
    if ( ! listeners.contains( listener ) )
      listeners.add( listener );
  }

  public void removeListener( GraphEventListener listener ) {
      
    listeners.remove( listener );
  }

  public void notifyListener(GraphEvent event) {
      
    for ( GraphEventListener listener : listeners )
      listener.onGraphChanged(event);
  }

}
