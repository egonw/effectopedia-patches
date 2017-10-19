package org.effectopedia.jabref.fetchers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fifo
 */
public class IeeexploreDbSearcherTest {
    
    public IeeexploreDbSearcherTest() {
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
     * Test of submitSearchQuery method, of class IeeexploreDbSearcher.
     */
    @Test
    public void testSubmitSearchQuery() {
        System.out.println("submitSearchQuery");
        String query = "";
        IeeexploreDbSearcher instance = new IeeexploreDbSearcher();
        Object result = instance.submitSearchQuery(query);
        assertNotNull(result);
    }
}
