/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.api;

/**
 *
 * @author Johannes
 */
public interface GraphMetricBuilder {
    
    public void buildmetrickey();
    
    public void buildmetricName();
    
    public void buildmetricDescription();
    
    public void buildotherAttributes();
    
    public Metric getMetric();
    
}
