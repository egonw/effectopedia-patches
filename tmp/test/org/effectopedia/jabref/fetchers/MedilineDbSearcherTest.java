
package org.effectopedia.jabref.fetchers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import net.sf.jabref.custom.BibtexEntry;
import java.util.ArrayList;

/**
 *
 * @author fifo
 */
public class MedilineDbSearcherTest {
    
    public MedilineDbSearcherTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of prepareSearchQuery method, of class MedlineDbSearcher.
     */
    @Test
    public void testPrepareSearchQuery() {
        System.out.println("prepareSearchQuery");
        SearchFields sf = null;
        MedlineDbSearcher instance = new MedlineDbSearcher();
        String expResult = "";
        String result = instance.prepareSearchQuery(sf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of submitSearchQuery method, of class MedlineDbSearcher.
     */
    @Test
    public void testSubmitSearchQuery() {
        
        ArrayList<BibtexEntry> entries;
        System.out.println("submitSearchQuery");
        MedlineDbSearcher instance = new MedlineDbSearcher();
        String query = "cell";
        entries = (ArrayList)instance.submitSearchQuery(query);
        assertNotNull(entries);
    }
}
