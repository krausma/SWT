/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.importer.spi;

/**
 *
 * @author Sebastian Brueggemann <bruegber@b-tu.de>
 */
public interface SonarQubeImporter extends Importer {

    String getProjectId();

    void setProjectId();
}
