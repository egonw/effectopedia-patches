package org.effectopedia.jabref.fetchers;

/**
 * @author Philip Georgiev
 */

import java.util.List;

import net.sf.jabref.custom.BibtexEntry;
import net.sf.jabref.custom.CustomOutputPrinter;
import net.sf.jabref.custom.imports.ImportInspectionDialog;
import net.sf.jabref.custom.imports.ImportInspector;
import net.sf.jabref.custom.imports.MedlineFetcher;



public class MedlineDbSearcher {
    
    
    public String prepareSearchQuery(SearchFields sf) {
        
        
        StringBuilder query;
        boolean andNeeded = false;
        String input;
        
        query = new StringBuilder();
        
        input = sf.getGeneral().trim();
        if (sf.checkInput(input) != null) {
            query.append(input);
            return query.toString();
        }
        
        input = sf.getAuthor();
        if (sf.checkInput(input) != null) {
            query.append(input).append("[Author]");
            andNeeded = true;
        }

        input = sf.getTitle();
        if (sf.checkInput(input) != null) {
            if (andNeeded) {
                query.append(" and ");
            }
            query.append(input).append("[Title]");
            andNeeded = true;
        }

        input = sf.getJournal();
        if (sf.checkInput(input) != null) {
            if (andNeeded) {
                query.append(" and ");
            }
            query.append(input).append("[Journal]");
            andNeeded = true;
        }

        if (sf.getYear() > 0) {
            if (andNeeded) {
                query.append(" and ");
            }
            query.append(sf.getYear()).append("[Year]");
        }        
        
        return query.toString();
    }
//    
//    public Object submitSearchQuery() {
//        
//        MedlineFetcher mlFetcher;
//        CustomOutputPrinter printer;
//        ImportInspector dialog;
//        
//        
//        printer = new CustomOutputPrinter();
//        dialog = new ImportInspectionDialog();
//        mlFetcher = new MedlineFetcher();
//        mlFetcher.processQuery(query, dialog, printer);
//        
//        return null;
//    }
//    
    
    public Object submitSearchQuery(String query) {
        
        MedlineFetcher mlFetcher;
        CustomOutputPrinter printer;
        ImportInspector dialog;
        
        List<BibtexEntry> res = null;
        
        printer = new CustomOutputPrinter();
        dialog = new ImportInspectionDialog();
        mlFetcher = new MedlineFetcher();
        if (mlFetcher.processQuery(query, dialog, printer)) {
            res = mlFetcher.getEntriesFound();
        }
        
        return res;
    }    
    
}
