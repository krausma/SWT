/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.api;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public interface Metric {

    
 
    
    public void setKey(String key);
    
    public void setName(String name);
    
    public void setDescription(String description);
    
    public void setValue(float value);
    /**
     * @return The metric key.
     */
    String getKey();

    /**
     * @return The human readable name of the metric.
     */
    String getName();

    /**
     * @return The human readable description of the metric.
     */
    String getDescription();

    /**
     * @return The lower bound of all values associated with the metric.
     */
    float getLowerBound();

    /**
     * @return The upper bound of all values associated with the metric.
     */
    float getUpperBound();
}
