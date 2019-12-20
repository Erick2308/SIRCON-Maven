/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sircon.util.JDBCSircon;

/**
 *
 * @author Erick Meza
 */
public class JDBCSirconTest {
    
    JDBCSircon jdbc;
    
    public JDBCSirconTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        jdbc = new JDBCSircon();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testConecctionNoNula(){
        assertNotNull(jdbc.getConexion());
    }
}
