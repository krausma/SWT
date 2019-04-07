/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.graph.api;

import java.util.stream.Stream;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public interface Schema {

    /**
     * Retrieves and returns all metrics registered at the schema instance.
     *
     * @return A fresh stream over all metrics.
     */
    Stream<Metric> metrics();

    /**
     * Retrieves a metric by the given metric key.
     *
     * @param key The metric key.
     * @return The metric for the given key or {@code null} if no metric was
     * found.
     */
    Metric getMetric(String key);

    /**
     * Adds the metric to the schema
     *
     * @param metric
     * @return
     */
    boolean add(Metric metric);

    /**
     * Removes the metric of the schema
     *
     * @param metric
     * @return
     */
    boolean remove(Metric metric);
}
