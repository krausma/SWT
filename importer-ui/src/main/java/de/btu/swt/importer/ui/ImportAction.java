/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btu.swt.importer.ui;

import de.btu.swt.importer.api.ImporterService;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "File",
        id = "de.btu.swt.importer.ui.ImportAction"
)
@ActionRegistration(
        displayName = "#CTL_ImportAction",
        lazy = false
)
@ActionReference(path = "Menu/File", position = 1950, separatorAfter = 2025)
@Messages("CTL_ImportAction=Import..")
public final class ImportAction extends AbstractAction implements Presenter.Menu {

    @Override
    public void actionPerformed(ActionEvent e) {
        // nothing to do
    }

    @Override
    public JMenuItem getMenuPresenter() {
        final JMenu importMenu = new JMenu("Import...");
        final ImporterService service = Lookup.getDefault().lookup(ImporterService.class);
        if (service != null) {
            service.importers().forEach(importer -> {
                final JMenuItem item = new JMenuItem(importer.getName());
                item.addActionListener(event
                        -> service.importGraph(importer)
                );
                importMenu.add(item);
            });
        }
        return importMenu;
    }
}
