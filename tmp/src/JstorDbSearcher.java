
package org.effectopedia.jabref.fetchers;

/**
 * @author Philip Georgiev
 */

import java.util.ArrayList;

import net.sf.jabref.custom.BibtexEntry;
import net.sf.jabref.custom.CustomOutputPrinter;
import net.sf.jabref.custom.imports.ImportInspectionDialog;
import net.sf.jabref.custom.imports.ImportInspector;
import net.sf.jabref.custom.imports.JSTORFetcher;

public class JstorDbSearcher {


    public Object submitSearchQuery(String query) {

        JSTORFetcher jsFetcher;
        CustomOutputPrinter printer;
        ImportInspector dialog;
        
        ArrayList<BibtexEntry> res = null;
        
        printer = new CustomOutputPrinter();
        dialog = new ImportInspectionDialog();
        jsFetcher = new JSTORFetcher();
        if (jsFetcher.processQuery(query, dialog, printer)) {
            res = jsFetcher.getEntriesFound();
        }
        
        return res;
    }     
    
    
}
