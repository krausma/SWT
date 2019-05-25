/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.impl;

import de.btu.swt.graph.api.Metric;

/**
 *
 * @author Johannes
 */
public class MetricImpl implements Metric {

    
    private String metricKey;
    private String metricName;
    private String metricDescription;
    
    @Override
    public void setKey(String key) {
        metricKey = key;
    }

    @Override
    public void setName(String name) {
       metricName = name;
    }

    @Override
    public void setDescription(String Description) {
        metricDescription = Description;
    }

    @Override
    public String getKey() {
        return metricKey;
    }

    @Override
    public String getName() {
        return metricName;
    }

    @Override
    public String getDescription() {
     return metricDescription;
    }

    @Override
    public float getLowerBound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getUpperBound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
