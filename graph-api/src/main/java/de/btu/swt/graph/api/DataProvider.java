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
public interface DataProvider {

    /**
     * Retrieves and returns the metric value for the given metric key.
     *
     * @param metric The metric key.
     * @return The metric value for the given metric key.
     */
    float getValue(String metric);

    /**
     * Convenient method for retrieving a metric value by passing an additional
     * default value. The default value will be returned when the resulting
     * metric value is {@link Float#NaN}.
     *
     * @param metric The metric key.
     * @param defaultValue The default value returned when the resulting value
     * was invalid.
     * @return The metric value for the given metric key.
     */
    default float getValue(String metric, float defaultValue) {
        final float value = getValue(metric);
        return Float.isNaN(value) ? defaultValue : value;
    }

    /**
     * Applies the given value for the given metric key.
     *
     * @param metric The metric key.
     * @param value The new value.
     */
    void setValue(String metric, float value);
}
