/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sircon.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erick Meza
 */
public class JDBCSirconTest {

    JDBCSircon jdbc;

    public JDBCSirconTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {

        jdbc = new JDBCSircon();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
   

    @Test
    public void testConecctionNoNula() {
        assertNotNull(jdbc.getConexion());
    }
}
