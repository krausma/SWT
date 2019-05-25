/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.GraphMetricBuilder;
import de.btu.swt.graph.api.Metric;
/**
 *
 * @author Johannes
 */
public class MetricDirector {
   
    private GraphMetricBuilder  graphMetricBuilder;
 
    public MetricDirector (GraphMetricBuilder Builder){
    
        this.graphMetricBuilder = Builder;
    }
    
    public Metric getMetric(){
        return this.graphMetricBuilder.getMetric();
    }
    
    public void buildmetric(String name, float value){
        
        this.graphMetricBuilder.buildmetricName(name);
        this.graphMetricBuilder.buildmetricDescription();
        this.graphMetricBuilder.buildmetrickey();
        this.graphMetricBuilder.buildotherAttributes(value);
    }
 }
