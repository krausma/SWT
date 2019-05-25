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
public class MetricBuildBasicImpl implements GraphMetricBuilder {

    private MetricImpl Metric;
    private String BuildName;
    private static int uniqueKey = 0;
    private String key;
    private float buildvalue;
    public MetricBuildBasicImpl (float value, String name){
        this.Metric = new MetricImpl();
        
        uniqueKey++; // muss noch inkrementiert werden
        key = Integer.toString(uniqueKey);
        this.buildvalue = value;
        this.BuildName = name;
        
}


    @Override
    public void buildmetrickey() {
       Metric.setKey(key);
    }

    @Override
    public void buildmetricName() {
      Metric.setName(BuildName);
    }

    @Override
    public void buildmetricDescription() {
        Metric.setDescription("This is a basic Metric with just one attributes");
    }

    @Override
    public void buildotherAttributes() {
         Metric.setValue(buildvalue);
    }

    @Override
    public Metric getMetric() {
        return this.Metric;
    }
    
}
