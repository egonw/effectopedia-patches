package org.effectopedia.jabref.fetchers;

/**
 * @author Philip Georgiev
 */
public abstract class AbstractDbSearcher {
    
    String query;
    
    public abstract String prepareSearchQuery(SearchFields searchFields);
    
    public abstract Object submitSearchQuery(String query);
    
}
