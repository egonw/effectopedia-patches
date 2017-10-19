package org.effectopedia.jabref.fetchers;

/**
 * @author Philip Georgiev
 * Copyright 2011 MSI GmbH. All rights reserved.
 */

import java.util.ArrayList;

import net.sf.jabref.custom.BibtexEntry;
import net.sf.jabref.custom.CustomOutputPrinter;
import net.sf.jabref.custom.imports.IEEEXploreFetcher;
import net.sf.jabref.custom.imports.ImportInspectionDialog;
import net.sf.jabref.custom.imports.ImportInspector;

public class IeeexploreDbSearcher {
    
    
    public Object submitSearchQuery(String query) {

        IEEEXploreFetcher ieFetcher;
        CustomOutputPrinter printer;
        ImportInspector dialog;
        
        ArrayList<BibtexEntry> res = null;
        
        printer = new CustomOutputPrinter();
        dialog = new ImportInspectionDialog();
        ieFetcher = new IEEEXploreFetcher();
        if (ieFetcher.processQuery(query, dialog, printer)) {
            res = ieFetcher.getEntriesFound();
        }
        
        return res;
    }     
    
}
