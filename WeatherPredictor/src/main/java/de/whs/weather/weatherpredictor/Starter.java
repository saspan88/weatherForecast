/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.whs.weather.weatherpredictor;

import de.whs.weather.Data.DataNormalizer;
import de.whs.weather.Data.DataReader;
import de.whs.weather.Data.NormedWeatherEnty;
import de.whs.weather.Data.WatherEnty;
import de.whs.weather.Logic.ActivationTypEnum;
import de.whs.weather.Logic.MatrixUtiles;
import de.whs.weather.Logic.NeuralNetwork;
import java.util.Vector;

/**
 *
 * @author Sascha
 */
public class Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataReader reader = new DataReader();
        Vector<WatherEnty> raw = reader.readDataFromPath("C:\\Users\\Sascha\\Documents\\Studium\\ML1\\WeatherData.csv", ",");
        DataNormalizer normalizer = new DataNormalizer(0.1, 0.9);
        Vector<NormedWeatherEnty> normed = normalizer.normalizeData(raw);
        int trainigsEndIndex = normalizer.getCountAllValidItems()/100*70;
        NeuralNetwork network = new NeuralNetwork(8, 50, 18, 0.05);
        network.initNeuralNetWork(70,ActivationTypEnum.Sigmoid);
        network.train(normed,trainigsEndIndex,5000);
        network.calcScoreCard(normed,(trainigsEndIndex+1),0.05);
    }
    
}
