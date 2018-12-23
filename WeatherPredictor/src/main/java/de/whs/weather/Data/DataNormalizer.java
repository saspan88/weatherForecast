/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.whs.weather.Data;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

/**
 *
 * @author Sascha
 */
public class DataNormalizer {

    public DataNormalizer() {
    }

    public DataNormalizer(double intervalMin, double intervalMax) {
    }

    private int countAllValidItems=0;
    double intervalMin = 0.1;
    double intervalMax = 0.9;

    int min_timeStamp;
    int max_timeStamp;

    double min_season = 0;
    double max_season = 3;

    double min_temp = 173;
    double max_temp = 333;

    double min_temp_preNormed = 0;
    double max_temp_preNormed = 1;

    double min_pressure = 300;
    double max_pressure = 1200;

    double min_humidity = 0;
    double max_humidity = 100;

    double min_wind_speed = 0;
    double max_wind_speed = 100;

    double min_wind_deg = 0;
    double max_wind_deg = 360;

    double min_weather_main_groupId = 2;
    double max_weather_main_groupId = 8;

    double min_weather_sub_Group_1 = 0;
    double max_weather_sub_Group_1 = 9;

    double min_weather_sub_Group_2 = 0;
    double max_weather_sub_Group_2 = 9;

    public Vector<NormedWeatherEnty> normalizeData(Vector<WatherEnty> raw) {
        Vector<NormedWeatherEnty> result = new Vector<NormedWeatherEnty>();

        max_timeStamp = raw.get(0).getTimeStamp();
        min_timeStamp = raw.get(0).getTimeStamp();

        for (int i = 0; i < raw.size(); i++) {
            WatherEnty object = raw.get(i);
            if (object.getTimeStamp() > max_timeStamp) {
                max_timeStamp = object.getTimeStamp();
            }
            if (object.getTimeStamp() < min_timeStamp) {
                min_timeStamp = object.getTimeStamp();
            }
        }

        NormedWeatherEnty normed;
        for (int i = 0; i < raw.size(); i++) {
            WatherEnty item = raw.get(i);
            normed = new NormedWeatherEnty();
            //Input values
            normed.setTimeStamp(this.normalizeDataIntoRange(item.getTimeStamp(), min_timeStamp, max_timeStamp));
            normed.setSession(this.normalizeDataIntoRange(item.getSession(), min_season, max_season));
            normed.setPressure(this.normalizeDataIntoRange(item.getPressure(), min_pressure, max_pressure));
            normed.setHumidity(this.normalizeDataIntoRange(item.getHumidity(), min_humidity, max_humidity));
            normed.setWind_speed(this.normalizeDataIntoRange(item.getWind_speed(), min_wind_speed, max_wind_speed));
            normed.setWind_deg(this.normalizeDataIntoRange(item.getWind_deg(), min_wind_deg, max_wind_deg));
            normed.setMin_temp(this.normalizeDataIntoRange(item.getMin_temp(), min_temp, max_temp));
            normed.setMax_Temp(this.normalizeDataIntoRange(item.getMax_Temp(), min_temp, max_temp));

            //Result values
            normed.setTemp_173_233(this.normalizeDataIntoRange(item.getTemp_173_233(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_234_243(this.normalizeDataIntoRange(item.getTemp_234_243(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_244_253(this.normalizeDataIntoRange(item.getTemp_244_253(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_254_263(this.normalizeDataIntoRange(item.getTemp_254_263(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_264_273(this.normalizeDataIntoRange(item.getTemp_264_273(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_274_278(this.normalizeDataIntoRange(item.getTemp_274_278(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_279_283(this.normalizeDataIntoRange(item.getTemp_279_283(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_284_288(this.normalizeDataIntoRange(item.getTemp_284_288(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_289_293(this.normalizeDataIntoRange(item.getTemp_289_293(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_294_298(this.normalizeDataIntoRange(item.getTemp_294_298(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_299_303(this.normalizeDataIntoRange(item.getTemp_299_303(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_304_308(this.normalizeDataIntoRange(item.getTemp_304_308(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_309_313(this.normalizeDataIntoRange(item.getTemp_309_313(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_314_318(this.normalizeDataIntoRange(item.getTemp_314_318(), min_temp_preNormed, max_temp_preNormed));
            normed.setTemp_319_333(this.normalizeDataIntoRange(item.getTemp_319_333(), min_temp_preNormed, max_temp_preNormed));
            
            normed.setWeather_mainGroup(this.normalizeDataIntoRange(item.getWeather_mainGroup(),min_weather_main_groupId,max_weather_main_groupId));
            normed.setWeather_subGroup_1(this.normalizeDataIntoRange(item.getWeather_subGroup_1(), min_weather_sub_Group_1, max_weather_sub_Group_1));
            normed.setWeather_subGroup_2(this.normalizeDataIntoRange(item.getWeather_subGroup_2(), min_weather_sub_Group_2, max_weather_sub_Group_2));
            result.add(normed);
        }
        this.countAllValidItems = result.size();
        
        return result;
    }

    public double normalizeDataIntoRange(double x, double xMin, double xMax) {
        double result = ((x - xMin) * (intervalMax - intervalMin) / (xMax - xMin) + intervalMin);

        if (result < intervalMin || result > intervalMax) {
            if (result < 0 || result > 1) {
                System.err.println("Transformed Value: " + result + " is out of range!");
            }
        }
        return result;
    }

    public double normalizeDataIntoRange(int x, int xMin, int xMax) {
        double result = ((x - xMin) * (intervalMax - intervalMin) / (xMax - xMin) + intervalMin);
        if (result < intervalMin || result > intervalMax) {
            System.err.println("Transformed Value: " + result + " is out of range!");
        }
        return result;
    }

    public double deNormalizeData(double y, double xMin, double xMax) {
        return ((xMin * intervalMax - xMin * y - xMax * intervalMin + xMax * y) / (intervalMax - intervalMin));
    }

    /**
     * @return the countAllValidItems
     */
    public int getCountAllValidItems() {
        return countAllValidItems;
    }
}
