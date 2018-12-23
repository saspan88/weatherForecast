/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.whs.weather.Logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sascha
 */
public class MatrixUtilesTest {
    
    public MatrixUtilesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create2DMatrixPlainInit method, of class MatrixUtiles.
     */
    @Test
    public void testCreate2DMatrixPlainInit() {
        System.out.println("MatrixUtilesTest - create2DMatrixPlainInit");
        int matrixHeight = 2;
        int matrixWidth = 2;
        MatrixUtiles instance = new MatrixUtiles();
        double[][] expResult = new double[matrixWidth][matrixWidth];
        expResult[0][0]=0.0;
        expResult[0][1]=0.0;
        expResult[1][0]=0.0;
        expResult[1][1]=0.0;
        double[][] result = instance.create2DMatrixPlainInit(matrixHeight, matrixWidth);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of create2DMatrixGaussianInit method, of class MatrixUtiles.
     */
    //@Test
    public void testCreate2DMatrixGaussianInit() {
        System.out.println("MatrixUtilesTest - create2DMatrixGaussianInit");
        int matrixHeight = 0;
        int matrixWidth = 0;
        MatrixUtiles instance = new MatrixUtiles();
        double[][] expResult = null;
        double[][] result = instance.create2DMatrixGaussianInit(matrixHeight, matrixWidth);
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create1DVectorPlainInit method, of class MatrixUtiles.
     */
    @Test
    public void testCreate1DVectorPlainInit() {
        System.out.println("MatrixUtilesTest - create1DVectorPlainInit");
        int vectorHeight = 3;
        MatrixUtiles instance = new MatrixUtiles();
        double[] expResult = new double[vectorHeight];
        expResult[0]=0.0;
        expResult[1]=0.0;
        expResult[2]=0.0;
        double[] result = instance.create1DVectorPlainInit(vectorHeight);
        assertArrayEquals(expResult, result, vectorHeight);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of applyFalkSchema method, of class MatrixUtiles.
     */
    @Test
    public void testApplyFalkSchema() {
        System.out.println("MatrixUtilesTest - applyFalkSchema");
        MatrixUtiles instance = new MatrixUtiles();
        double[][] matrix = instance.create2DMatrixPlainInit(3, 2);
        double[] vektor = instance.create1DVectorPlainInit(2);
        
        matrix[0][0] = 1.5;
        matrix[0][1] = 2.0;
        matrix[1][0] = 3.0;        
        matrix[1][1] = 4.0;
        matrix[2][0] = 5.2;        
        matrix[2][1] = 6.0;
        
        vektor[0] = 1.7;
        vektor[1] = 2.0;
        
        double[] expResult = new double[3];
        expResult[0] = 6.55;
        expResult[1] = 13.1;
        expResult[2] = 20.84;
        
        double[] result = instance.applyFalkSchema(matrix, vektor);
        assertArrayEquals(expResult, result, 3);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of applyFalkSchema method, of class MatrixUtiles.
     */
    @Test
    public void testTranspose() {
        System.out.println("MatrixUtilesTest - transpose");
        MatrixUtiles instance = new MatrixUtiles();
        double[][] matrix = new double[3][2];
        
        matrix[0][0] = 1.5;
        matrix[0][1] = 2.0;
        matrix[1][0] = 3.0;        
        matrix[1][1] = 4.0;
        matrix[2][0] = 5.2;        
        matrix[2][1] = 6.0;
        
        double[][] result = instance.transpose(matrix);
        double[][] expResult = new double[2][3];
        expResult[0][0] = 1.5;
        expResult[0][1] = 3;
        expResult[0][2] = 5.2;
        expResult[1][0] = 2;
        expResult[1][1] = 4;
        expResult[1][2] = 6;
        assertArrayEquals(expResult, result);
    }
}
