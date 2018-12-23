/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.whs.weather.Logic;

import de.whs.weather.Data.NormedWeatherEnty;
import java.util.Vector;

/**
 *
 * @author Sascha
 */
public class NeuralNetwork {

    public NeuralNetwork(int countInputNeurons, int contHiddenNeurons, int countOutputNeurons, double learningRate) {
        this.countInputNeurons = countInputNeurons;
        this.countHiddenNeureons = contHiddenNeurons;
        this.countOutputNeurons = countOutputNeurons;
        this.learningRate = learningRate;
        maUtils = new MatrixUtiles();
    }

    MatrixUtiles maUtils;
    private int countInputNeurons;
    private int countHiddenNeureons;
    private int countOutputNeurons;
    private ActivationTypEnum activationType;

    double[][] w_i_h;
    double[][] w_h_o;
    double learningRate = 0.1;

    public void initNeuralNetWork(int percentTrainigsSet, ActivationTypEnum activationType) {
        //Set Sigmoid as activationType
        this.activationType = activationType;
        //Init Wiegiht Matrixs
        //Input to Hidden
        this.w_i_h = maUtils.create2DMatrixGaussianInit(countHiddenNeureons, countInputNeurons);
        //Hidden to Output
        this.w_h_o = maUtils.create2DMatrixGaussianInit(countOutputNeurons, countHiddenNeureons);
    }

    public double[] queryNetwork(NormedWeatherEnty dataSetItem) {
        double[] inputLayer = this.selectInputFeaturesFromDataSet(dataSetItem);
        double[] hiddenLayer;
        double[] hiddenLayer_output;
        double[] outputLayer;
        double[] outputLayer_output;
        
        hiddenLayer = maUtils.applyFalkSchema(w_i_h, inputLayer);
        hiddenLayer_output = activateLayer(hiddenLayer);
        
        outputLayer = maUtils.applyFalkSchema(w_h_o, hiddenLayer_output);
        outputLayer_output=activateLayer(outputLayer);
        
        return outputLayer_output;
    }

    private double[] selectInputFeaturesFromDataSet(NormedWeatherEnty dataSetItem) {
        double[] inputLayer = maUtils.create1DVectorPlainInit(countInputNeurons);
        inputLayer[0] = dataSetItem.getTimeStamp();
        inputLayer[1] = dataSetItem.getSession();
        inputLayer[2] = dataSetItem.getPressure();
        inputLayer[3] = dataSetItem.getHumidity();
        inputLayer[4] = dataSetItem.getWind_speed();
        inputLayer[5] = dataSetItem.getWind_deg();
        inputLayer[6] = dataSetItem.getMin_temp();
        inputLayer[7] = dataSetItem.getMax_Temp();
        return inputLayer;
    }

    private double[] selectTargetFeaturesFromDataSet(NormedWeatherEnty dataSetItem) {
        double[] targetValues = maUtils.create1DVectorPlainInit(countOutputNeurons);
        targetValues[0] = dataSetItem.getTemp_173_233();
        targetValues[1] = dataSetItem.getTemp_234_243();
        targetValues[2] = dataSetItem.getTemp_244_253();
        targetValues[3] = dataSetItem.getTemp_254_263();
        targetValues[4] = dataSetItem.getTemp_264_273();
        targetValues[5] = dataSetItem.getTemp_274_278();
        targetValues[6] = dataSetItem.getTemp_279_283();
        targetValues[7] = dataSetItem.getTemp_284_288();
        targetValues[8] = dataSetItem.getTemp_289_293();
        targetValues[9] = dataSetItem.getTemp_294_298();
        targetValues[10] = dataSetItem.getTemp_299_303();
        targetValues[11] = dataSetItem.getTemp_304_308();
        targetValues[12] = dataSetItem.getTemp_309_313();
        targetValues[13] = dataSetItem.getTemp_314_318();
        targetValues[14] = dataSetItem.getTemp_319_333();

        targetValues[15] = dataSetItem.getWeather_mainGroup();
        targetValues[16] = dataSetItem.getWeather_subGroup_1();
        targetValues[17] = dataSetItem.getWeather_subGroup_2();

        return targetValues;
    }

    public double[] activateLayer(double[] layer) {
        double[] result = maUtils.create1DVectorPlainInit(layer.length);
        for (int i = 0; i < layer.length; i++) {
            result[i] = this.applyActivationFuctionOnInput(layer[i]);
        }
        return result;
    }

    public double applyActivationFuctionOnInput(double valueToActivate) {
        switch (this.activationType) {
            case FastSigmoid:
                return 1 / (1 + Math.abs(valueToActivate));
            case Sigmoid:
            default:
                return 1 / (1 + Math.exp(-valueToActivate));
        }
    }

    public double[] createOutputErros(double[] target, double[] calculated) {
        double result[] = maUtils.create1DVectorPlainInit(countOutputNeurons);
        for (int i = 0; i < result.length; i++) {
            result[i] = target[i] - calculated[i];
        }
        return result;
    }

    public double applyActivationDerivedFuctionOnInput(double valueToActivate) {
        switch (this.activationType) {
            case FastSigmoid:
                return 1 / (1 + Math.abs(valueToActivate));
            case Sigmoid:
            default:
                return (1 / (1 + Math.exp(-valueToActivate))) * (1 - (1 / (1 + Math.exp(-valueToActivate))));
        }
    }

    public void train(Vector<NormedWeatherEnty> normed, int trainigsEndIndex, int epoch) {
        for (int e = 0; e < epoch; e++) {
            for (int i = 0; i < trainigsEndIndex; i++) {
                this.trainElement(normed.get(i));
            }
            System.out.println("Epoch " +(e+1) + " of " + epoch + " done");
        }
    }

    public void trainElement(NormedWeatherEnty dataSetItem) {
        double[] inputLayer = this.selectInputFeaturesFromDataSet(dataSetItem);
        double[] hiddenLayer;
        double[] hiddenLayer_output;
        double[] outputLayer;
        double[] outputLayer_output;
        double[] targetValues = this.selectTargetFeaturesFromDataSet(dataSetItem);
        double[] outputErrors;
        double[] hiddenErrors;

        //Process singnal from Input to Hidden and activate hidden Layer
        hiddenLayer = maUtils.applyFalkSchema(w_i_h, inputLayer);
        hiddenLayer_output = activateLayer(hiddenLayer);

        //Process signals from Hidden to Output and activate output Layer
        outputLayer = maUtils.applyFalkSchema(w_h_o, hiddenLayer_output);
        outputLayer_output = activateLayer(outputLayer);
        
        //Get the error from the output by (target - calculated)
        outputErrors = this.createOutputErros(targetValues, outputLayer_output);
        
        //Backparse errors to Hidden Layer
        hiddenErrors = maUtils.applyFalkSchema(maUtils.transpose(w_h_o), outputErrors);
        
        this.updateWeightMatrix(this.w_h_o,outputErrors,outputLayer,hiddenLayer_output);
        
        this.updateWeightMatrix(this.w_i_h,hiddenErrors,hiddenLayer,hiddenLayer_output);
    }
    
    public void updateWeightMatrix(double[][] weightMatrixToModify, 
            double[] errorsFormPerviousLayer,double[] outputsFromPreviousLayer,
            double[] outputs){
        //Get details from the matrix
        int height = weightMatrixToModify.length;
        int width = weightMatrixToModify[0].length;
        
        double[] gradientKLayer = maUtils.create1DVectorPlainInit(outputsFromPreviousLayer.length);
        for(int k=0;k<outputsFromPreviousLayer.length;k++){
            gradientKLayer[k]= errorsFormPerviousLayer[k]*this.applyActivationDerivedFuctionOnInput(outputsFromPreviousLayer[k]);
        }
   
        double[][] outputs_TRANSPOSED = maUtils.transpose(outputs);
        
        for(int h=0; h < height; h++){
            for(int w=0; w < width;w++){
                weightMatrixToModify[h][w]-=this.learningRate*gradientKLayer[h]*outputs_TRANSPOSED[0][w];
            }
        }
    }

    public void calcScoreCard(Vector<NormedWeatherEnty> normed, int querryIndex, double errorLimit) {
        double[] calculatedoutput;
        double[] error;
        double[] expectedOutputs;
        int testedItems = 0;
        int passedItem = 0;
        for (int i = querryIndex; i < normed.size(); i++) {
            expectedOutputs = this.selectTargetFeaturesFromDataSet(normed.get(i));
            testedItems++;
            calculatedoutput = this.queryNetwork(normed.get(i));
            error = this.createOutputErros(expectedOutputs, calculatedoutput);
            double errorDistnace = this.calcErrorDistance(error);
            if (errorDistnace <= errorLimit) {
                passedItem++;
            }
            System.out.println("Dataset: " + i + " -> error: " + this.calcErrorDistance(error));
        }
        System.out.println("Performence:  " + 100.00 / testedItems * passedItem);
    }

    private double calcErrorDistance(double[] error) {
        double wholeError = 0.0;
        for (int i = 0; i < error.length; i++) {
            wholeError += Math.pow(error[i], 2.0);
        }
        return wholeError;
    }
}
