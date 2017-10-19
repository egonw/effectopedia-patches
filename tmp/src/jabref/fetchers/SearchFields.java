
package org.effectopedia.jabref.fetchers;

/**
 * @author Philip Georgiev
 */
public class SearchFields {

    
    String general;
    String author;
    String title;
    String journal;
    int year = 0;
    int dbToSearch;
    
    
    public String checkInput(String s) {
        if (s != null && s.length() > 0) {
            return s.trim();
        }
        else {
            return null;
        }
    }

    public String getGeneral() {
        return general;
    }
    
    public String getAuthor() {
        return author;
    }

    public int getDbToSearch() {
        return dbToSearch;
    }

    public String getJournal() {
        return journal;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDbToSearch(int dbToSearch) {
        this.dbToSearch = dbToSearch;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGeneral(String general) {
        this.general = general;
    }
    
    
}
