/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.whs.weather.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Sascha
 */
public class DataReader {

    public DataReader() {
        this.rawData = new Vector<>();
    }
    private Vector<WatherEnty> rawData;

    public Vector<WatherEnty> readDataFromPath(String fullCsvFilePath, String cvsSplitBy) {
        BufferedReader br = null;
        String line = "";
        int countTotalItems=0;
        int countValidItems=0;
        WatherEnty templateToAdd;
        if (cvsSplitBy.isEmpty()) {
            cvsSplitBy = ",";
        }

        try {

            br = new BufferedReader(new FileReader(fullCsvFilePath));
            while ((line = br.readLine()) != null) {

                templateToAdd = new WatherEnty();
                // use comma as separator
                String[] dataLine = line.split(cvsSplitBy);
                if(dataLine.length > 1){
                    countTotalItems++;
                    templateToAdd.setTimeStamp(Integer.parseInt(dataLine[0]));
                    templateToAdd.setFullDate(dataLine[1]);
                    templateToAdd.setTemp(dataLine[6]);
                    templateToAdd.setMin_temp(dataLine[7]);
                    templateToAdd.setMax_Temp(dataLine[8]);
                    templateToAdd.setPressure(Integer.parseInt(dataLine[9]));
                    templateToAdd.setHumidity(Integer.parseInt(dataLine[12]));
                    templateToAdd.setWind_speed(Integer.parseInt(dataLine[13]));
                    templateToAdd.setWind_deg(Integer.parseInt(dataLine[14]));
                    templateToAdd.setWeather_id(Integer.parseInt(dataLine[24]));
                    if(checkTemplateHasValidValues(templateToAdd)==0){
                        countValidItems++;
                        this.rawData.add(templateToAdd);
                    } 
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("There are: " + countTotalItems+ " items, where " + countValidItems +" are valid.");
        return rawData;
    }

    private int checkTemplateHasValidValues(WatherEnty templateToAdd) {
        int errorCode=0;
        
        if(templateToAdd.getTemp() < 170 || templateToAdd.getTemp() > 334){
            errorCode++;
        }
        if(templateToAdd.getPressure()< 300  || templateToAdd.getPressure() > 1300){
            errorCode+=10;
        }
        if(templateToAdd.getHumidity()< 0  || templateToAdd.getHumidity() > 101){
            errorCode+=200;
        }
        if(templateToAdd.getWind_speed()< 0  || templateToAdd.getWind_speed() > 101){
            errorCode+=3000;
        }
        if(templateToAdd.getWind_deg()< 0  || templateToAdd.getWind_deg() > 360){
            errorCode+=40000;
        }
        if(templateToAdd.getWeather_id()< 200  || templateToAdd.getWeather_id() > 900){
            errorCode+=500000;
        }
        if(templateToAdd.getMax_Temp()< 170  || templateToAdd.getMax_Temp() > 334){
            errorCode+=6000000;
        }
        if(templateToAdd.getMin_temp()< 170  || templateToAdd.getMin_temp() > 334){
            errorCode+=70000000;
        }
        
        return errorCode;
    }
}
