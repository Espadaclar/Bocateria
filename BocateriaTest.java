

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BocateriaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BocateriaTest
{
    private Bocateria bocateri1;

    /**
     * Default constructor for test class BocateriaTest
     */
    public BocateriaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        bocateri1 = new Bocateria();
        bocateri1.llegaNuevoClienteALaCola(4);
        bocateri1.llegaNuevoClienteALaCola(7);
        bocateri1.llegaNuevoClienteALaCola(2);
        bocateri1.llegaNuevoClienteALaCola(12);
        bocateri1.visualizaDatosClienteEnLaCola();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
