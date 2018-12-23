/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.whs.weather.Data;

/**
 *
 * @author Sascha
 */
public class NormedWeatherEnty {
    private double timeStamp; // 0 dt
    private double session; //calculated field from full date
    private double temp; // 6) temp
    private double temp_173_233=0.1; // -100 bis -40 C
    private double temp_234_243=0.1; // -39 bis -30
    private double temp_244_253=0.1; // -29 bis -20
    private double temp_254_263=0.1; // -19 bis -10
    private double temp_264_273=0.1; // -9 bis 0
    private double temp_274_278=0.1; // 1 bis 5
    private double temp_279_283=0.1; // 6 bis 10
    private double temp_284_288=0.1; // 11 bis 15
    private double temp_289_293=0.1; // 16 bis 20
    private double temp_294_298=0.1; // 21 bis 25
    private double temp_299_303=0.1; // 26 bis 30
    private double temp_304_308=0.1; // 31 bis 35
    private double temp_309_313=0.1; // 36 bis 40
    private double temp_314_318=0.1; // 41 bis 45
    private double temp_319_333=0.1; // 45 bis 60
    private double min_temp = 0.1; //7) temp_min
    private double max_Temp = 0.1; //8) temp_max
    private double pressure =0.1;; //9) pressure
    private double humidity = 0.1;; // 12) humidity
    private double wind_speed = 0.1;; // 13) wind_speed
    private double wind_deg = 0.1;; //14) wind_deg
    private double weather_id = 0.1;; // 24) weather_id
    private double weather_mainGroup = 0.1;; //first digit from weather_id
    private double weather_subGroup_1 = 0.1;; //secound digit from weather_id
    private double weather_subGroup_2 = 0.1;; // thred digit from weather_id

    /**
     * @return the timeStamp
     */
    public double getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(double timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the session
     */
    public double getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(double session) {
        this.session = session;
    }

    /**
     * @return the temp
     */
    public double getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * @return the temp_173_233
     */
    public double getTemp_173_233() {
        return temp_173_233;
    }

    /**
     * @param temp_173_233 the temp_173_233 to set
     */
    public void setTemp_173_233(double temp_173_233) {
        this.temp_173_233 = temp_173_233;
    }

    /**
     * @return the temp_234_243
     */
    public double getTemp_234_243() {
        return temp_234_243;
    }

    /**
     * @param temp_234_243 the temp_234_243 to set
     */
    public void setTemp_234_243(double temp_234_243) {
        this.temp_234_243 = temp_234_243;
    }

    /**
     * @return the temp_244_253
     */
    public double getTemp_244_253() {
        return temp_244_253;
    }

    /**
     * @param temp_244_253 the temp_244_253 to set
     */
    public void setTemp_244_253(double temp_244_253) {
        this.temp_244_253 = temp_244_253;
    }

    /**
     * @return the temp_254_263
     */
    public double getTemp_254_263() {
        return temp_254_263;
    }

    /**
     * @param temp_254_263 the temp_254_263 to set
     */
    public void setTemp_254_263(double temp_254_263) {
        this.temp_254_263 = temp_254_263;
    }

    /**
     * @return the temp_264_273
     */
    public double getTemp_264_273() {
        return temp_264_273;
    }

    /**
     * @param temp_264_273 the temp_264_273 to set
     */
    public void setTemp_264_273(double temp_264_273) {
        this.temp_264_273 = temp_264_273;
    }

    /**
     * @return the temp_274_278
     */
    public double getTemp_274_278() {
        return temp_274_278;
    }

    /**
     * @param temp_274_278 the temp_274_278 to set
     */
    public void setTemp_274_278(double temp_274_278) {
        this.temp_274_278 = temp_274_278;
    }

    /**
     * @return the temp_279_283
     */
    public double getTemp_279_283() {
        return temp_279_283;
    }

    /**
     * @param temp_279_283 the temp_279_283 to set
     */
    public void setTemp_279_283(double temp_279_283) {
        this.temp_279_283 = temp_279_283;
    }

    /**
     * @return the temp_284_288
     */
    public double getTemp_284_288() {
        return temp_284_288;
    }

    /**
     * @param temp_284_288 the temp_284_288 to set
     */
    public void setTemp_284_288(double temp_284_288) {
        this.temp_284_288 = temp_284_288;
    }

    /**
     * @return the temp_289_293
     */
    public double getTemp_289_293() {
        return temp_289_293;
    }

    /**
     * @param temp_289_293 the temp_289_293 to set
     */
    public void setTemp_289_293(double temp_289_293) {
        this.temp_289_293 = temp_289_293;
    }

    /**
     * @return the temp_294_298
     */
    public double getTemp_294_298() {
        return temp_294_298;
    }

    /**
     * @param temp_294_298 the temp_294_298 to set
     */
    public void setTemp_294_298(double temp_294_298) {
        this.temp_294_298 = temp_294_298;
    }

    /**
     * @return the temp_299_303
     */
    public double getTemp_299_303() {
        return temp_299_303;
    }

    /**
     * @param temp_299_303 the temp_299_303 to set
     */
    public void setTemp_299_303(double temp_299_303) {
        this.temp_299_303 = temp_299_303;
    }

    /**
     * @return the temp_304_308
     */
    public double getTemp_304_308() {
        return temp_304_308;
    }

    /**
     * @param temp_304_308 the temp_304_308 to set
     */
    public void setTemp_304_308(double temp_304_308) {
        this.temp_304_308 = temp_304_308;
    }

    /**
     * @return the temp_309_313
     */
    public double getTemp_309_313() {
        return temp_309_313;
    }

    /**
     * @param temp_309_313 the temp_309_313 to set
     */
    public void setTemp_309_313(double temp_309_313) {
        this.temp_309_313 = temp_309_313;
    }

    /**
     * @return the temp_314_318
     */
    public double getTemp_314_318() {
        return temp_314_318;
    }

    /**
     * @param temp_314_318 the temp_314_318 to set
     */
    public void setTemp_314_318(double temp_314_318) {
        this.temp_314_318 = temp_314_318;
    }

    /**
     * @return the temp_319_333
     */
    public double getTemp_319_333() {
        return temp_319_333;
    }

    /**
     * @param temp_319_333 the temp_319_333 to set
     */
    public void setTemp_319_333(double temp_319_333) {
        this.temp_319_333 = temp_319_333;
    }

    /**
     * @return the min_temp
     */
    public double getMin_temp() {
        return min_temp;
    }

    /**
     * @param min_temp the min_temp to set
     */
    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    /**
     * @return the max_Temp
     */
    public double getMax_Temp() {
        return max_Temp;
    }

    /**
     * @param max_Temp the max_Temp to set
     */
    public void setMax_Temp(double max_Temp) {
        this.max_Temp = max_Temp;
    }

    /**
     * @return the pressure
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the humidity
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the wind_speed
     */
    public double getWind_speed() {
        return wind_speed;
    }

    /**
     * @param wind_speed the wind_speed to set
     */
    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    /**
     * @return the wind_deg
     */
    public double getWind_deg() {
        return wind_deg;
    }

    /**
     * @param wind_deg the wind_deg to set
     */
    public void setWind_deg(double wind_deg) {
        this.wind_deg = wind_deg;
    }

    /**
     * @return the weather_id
     */
    public double getWeather_id() {
        return weather_id;
    }

    /**
     * @param weather_id the weather_id to set
     */
    public void setWeather_id(double weather_id) {
        this.weather_id = weather_id;
    }

    /**
     * @return the weather_mainGroup
     */
    public double getWeather_mainGroup() {
        return weather_mainGroup;
    }

    /**
     * @param weather_mainGroup the weather_mainGroup to set
     */
    public void setWeather_mainGroup(double weather_mainGroup) {
        this.weather_mainGroup = weather_mainGroup;
    }

    /**
     * @return the weather_subGroup_1
     */
    public double getWeather_subGroup_1() {
        return weather_subGroup_1;
    }

    /**
     * @param weather_subGroup_1 the weather_subGroup_1 to set
     */
    public void setWeather_subGroup_1(double weather_subGroup_1) {
        this.weather_subGroup_1 = weather_subGroup_1;
    }

    /**
     * @return the weather_subGroup_2
     */
    public double getWeather_subGroup_2() {
        return weather_subGroup_2;
    }

    /**
     * @param weather_subGroup_2 the weather_subGroup_2 to set
     */
    public void setWeather_subGroup_2(double weather_subGroup_2) {
        this.weather_subGroup_2 = weather_subGroup_2;
    }
    
}
