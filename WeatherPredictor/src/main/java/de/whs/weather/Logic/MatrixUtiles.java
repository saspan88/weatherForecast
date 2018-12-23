/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.whs.weather.Logic;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Sascha
 */
public class MatrixUtiles {

    public double[][] create2DMatrixPlainInit(int matrixHeight, int matrixWidth) {
        double result[][] = new double[matrixHeight][matrixWidth];
        for (int h = 0; h < matrixHeight; h++) {
            for (int w = 0; w < matrixWidth; w++) {
                result[h][w] = 0.0;
            }
        }
        return result;
    }

    public double[][] create2DMatrixGaussianInit(int matrixHeight, int matrixWidth) {
        double desiredStandardDeviation = 1.0 / Math.sqrt(matrixWidth);
        double desiredMean = 0.0;
        Random r = new Random();

        double result[][] = new double[matrixHeight][matrixWidth];
        for (int h = 0; h < matrixHeight; h++) {
            for (int w = 0; w < matrixWidth; w++) {
                result[h][w] = r.nextGaussian() * desiredStandardDeviation + desiredMean;;
            }
        }
        return result;
    }

    public double[] create1DVectorPlainInit(int vectorHeight) {
        double[] result = new double[vectorHeight];
        Arrays.fill(result, 0.0);

        return result;
    }

    public double[] applyFalkSchema(double[][] matrix, double[] vektor) {
        //Get details from the matrix
        int height = matrix.length;
        int width = matrix[0].length;
        //Create a result vector which represents the result of the matrix multiplication
        double[] result = this.create1DVectorPlainInit(height);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                result[h] += matrix[h][w] * vektor[w];
            }
        }
        return result;
    }

    public double[][] transpose(double[][] matrixToTranspose) {
        int height = matrixToTranspose.length;
        int width = matrixToTranspose[0].length;

        //Columns and rows are switched !!
        double[][] result = this.create2DMatrixPlainInit(width, height);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                result[w][h] = matrixToTranspose[h][w];
            }
        }
        return result;
    }

    public double[][] transpose(double[] matrixToTranspose) {
        int height = matrixToTranspose.length;

        //Columns and rows are switched !!
        double[][] result = this.create2DMatrixPlainInit(1, height);

        for (int h = 0; h < height; h++) {
            result[0][h] = matrixToTranspose[h];
        }
        return result;
    }
}
