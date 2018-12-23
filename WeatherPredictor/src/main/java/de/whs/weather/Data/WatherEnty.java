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
public class WatherEnty {

    private int timeStamp; // 0 dt
    private String fullDate; // 1 dt_iso
    private int session=0; //calculated field from full date
    private int temp =-1; // 6) temp
    private int temp_173_233=0; // -100 bis -40 C
    private int temp_234_243=0; // -39 bis -30
    private int temp_244_253=0; // -29 bis -20
    private int temp_254_263=0; // -19 bis -10
    private int temp_264_273=0; // -9 bis 0
    private int temp_274_278=0; // 1 bis 5
    private int temp_279_283=0; // 6 bis 10
    private int temp_284_288=0; // 11 bis 15
    private int temp_289_293=0; // 16 bis 20
    private int temp_294_298=0; // 21 bis 25
    private int temp_299_303=0; // 26 bis 30
    private int temp_304_308=0; // 31 bis 35
    private int temp_309_313=0; // 36 bis 40
    private int temp_314_318=0; // 41 bis 45
    private int temp_319_333=0; // 45 bis 60
    private int min_temp = -1; //7) temp_min
    private int max_Temp = -1; //8) temp_max
    private int pressure; //9) pressure
    private int humidity; // 12) humidity
    private int wind_speed; // 13) wind_speed
    private int wind_deg; //14) wind_deg
    private int weather_id; // 24) weather_id
    private int weather_mainGroup; //first digit from weather_id
    private int weather_subGroup_1; //secound digit from weather_id
    private int weather_subGroup_2; // thred digit from weather_id

    /**
     * @return the timeStamp
     */
    public int getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the fullDate
     */
    public String getFullDate() {
        return fullDate;
    }

    /**
     * @param fullDate the fullDate to set
     */
    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
        //stuff to set the seesion
        
        int year = Integer.parseInt(fullDate.substring(0, 4));
        int month = Integer.parseInt(fullDate.substring(5, 7));
        int day = Integer.parseInt(fullDate.substring(8, 10));
        
        if(month<3){
            this.session =0;
        } if(month==3){
            if(day <20){
              this.session =0;  
            } else{
                this.session =1;
            }
        }
        if(month > 3 &&  month < 6){
            this.session =1;
        }
        if(month ==6){
            if(day <21){
                this.session =1;
            }else{
                this.session =2;
            }
        }
        if(month > 6 && month < 9){
            this.session =2;
        }
        if(month == 9){
           if(year == 2012 || year == 2013 || year == 2016 || year == 2017){
               if(day <22){
                   this.session =2;
               }else{
                   this.session =3;
               }
           }else{
               if(day < 23){
                   this.session =2;
               }else{
                  this.session =3; 
               }
           }
        }
        if(month > 9 && month < 12){
            this.session =3; 
        }
        if(month == 12){
            if(year == 2014 || year == 2015){
                if(day<22){
                    this.session =3; 
                }else{
                    this.session =0; 
                }
            }else{
                if(day<23){
                    this.session =3; 
                }else{
                    this.session =0; 
                }
            }
        }
    }

    /**
     * @return the temp
     */
    public int getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(String temp) {
        
        float paresedDouble = Float.parseFloat(temp);
        int parsedRounded = Math.round(paresedDouble);
        this.temp = parsedRounded;
        
        if(parsedRounded >= 173 && parsedRounded<=233){
            this.temp_173_233 =1;
        }
        if(parsedRounded >= 234 && parsedRounded<=243){
            this.temp_234_243 =1;
        }
        if(parsedRounded >= 244 && parsedRounded<=253){
            this.temp_244_253 =1;
        }
        if(parsedRounded >= 254 && parsedRounded<=263){
            this.temp_254_263 =1;
        }
        if(parsedRounded >= 264 && parsedRounded<=273){
            this.temp_264_273 =1;
        }
        if(parsedRounded >= 274 && parsedRounded<=278){
            this.temp_274_278 =1;
        }
        if(parsedRounded >= 279 && parsedRounded<=283){
            this.temp_279_283 =1;
        }
        if(parsedRounded >= 284 && parsedRounded<=288){
            this.temp_284_288 =1;
        }
        if(parsedRounded >= 289 && parsedRounded<=293){
            this.temp_289_293 =1;
        }
        if(parsedRounded >= 294 && parsedRounded<=298){
            this.temp_294_298 =1;
        }
        if(parsedRounded >= 299 && parsedRounded<=303){
            this.temp_299_303 =1;
        }
        if(parsedRounded >= 304 && parsedRounded<=308){
            this.temp_304_308 =1;
        }
        if(parsedRounded >= 309 && parsedRounded<=313){
            this.temp_309_313 =1;
        }
        if(parsedRounded >= 314 && parsedRounded<=318){
            this.temp_314_318 =1;
        }
        if(parsedRounded >= 315 && parsedRounded<=333){
            this.temp_319_333 =1;
        }
    }

    /**
     * @return the min_temp
     */
    public int getMin_temp() {
        return min_temp;
    }

    /**
     * @param min_temp the min_temp to set
     */
    public void setMin_temp(String min_temp) {
        float paresedDouble = Float.parseFloat(min_temp);
        int parsedRounded = Math.round(paresedDouble);
        this.min_temp = parsedRounded;
    }

    /**
     * @return the max_Temp
     */
    public int getMax_Temp() {
        return max_Temp;
    }

    /**
     * @param max_Temp the max_Temp to set
     */
    public void setMax_Temp(String max_Temp) {
        float paresedDouble = Float.parseFloat(max_Temp);
        int parsedRounded = Math.round(paresedDouble);
        this.max_Temp = parsedRounded;
    }

    /**
     * @return the pressure
     */
    public int getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the wind_speed
     */
    public int getWind_speed() {
        return wind_speed;
    }

    /**
     * @param wind_speed the wind_speed to set
     */
    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    /**
     * @return the wind_deg
     */
    public int getWind_deg() {
        return wind_deg;
    }

    /**
     * @param wind_deg the wind_deg to set
     */
    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg;
    }

    /**
     * @return the weather_id
     */
    public int getWeather_id() {
        return weather_id;
    }

    /**
     * @param weather_id the weather_id to set
     */
    public void setWeather_id(int weather_id) {
        this.weather_id = weather_id;
        
        this.weather_mainGroup = weather_id/100;
        int tmp = weather_id%100;
        this.weather_subGroup_1 = tmp/10;
        this.weather_subGroup_2 = tmp%10;
    }

    /**
     * @return the weather_mainGroup
     */
    public int getWeather_mainGroup() {
        return weather_mainGroup;
    }

    /**
     * @return the weather_subGroup_1
     */
    public int getWeather_subGroup_1() {
        return weather_subGroup_1;
    }

    /**
     * @return the weather_subGroup_2
     */
    public int getWeather_subGroup_2() {
        return weather_subGroup_2;
    }

    /**
     * @return the session
     */
    public int getSession() {
        return session;
    }

    /**
     * @return the temp_173_233
     */
    public int getTemp_173_233() {
        return temp_173_233;
    }

    /**
     * @return the temp_234_243
     */
    public int getTemp_234_243() {
        return temp_234_243;
    }

    /**
     * @return the temp_244_253
     */
    public int getTemp_244_253() {
        return temp_244_253;
    }

    /**
     * @return the temp_254_263
     */
    public int getTemp_254_263() {
        return temp_254_263;
    }

    /**
     * @return the temp_264_273
     */
    public int getTemp_264_273() {
        return temp_264_273;
    }

    /**
     * @return the temp_274_278
     */
    public int getTemp_274_278() {
        return temp_274_278;
    }

    /**
     * @return the temp_279_283
     */
    public int getTemp_279_283() {
        return temp_279_283;
    }

    /**
     * @return the temp_284_288
     */
    public int getTemp_284_288() {
        return temp_284_288;
    }

    /**
     * @return the temp_289_293
     */
    public int getTemp_289_293() {
        return temp_289_293;
    }

    /**
     * @return the temp_294_298
     */
    public int getTemp_294_298() {
        return temp_294_298;
    }

    /**
     * @return the temp_299_303
     */
    public int getTemp_299_303() {
        return temp_299_303;
    }

    /**
     * @return the temp_304_308
     */
    public int getTemp_304_308() {
        return temp_304_308;
    }

    /**
     * @return the temp_309_313
     */
    public int getTemp_309_313() {
        return temp_309_313;
    }

    /**
     * @return the temp_314_318
     */
    public int getTemp_314_318() {
        return temp_314_318;
    }

    /**
     * @return the temp_319_333
     */
    public int getTemp_319_333() {
        return temp_319_333;
    }
}
