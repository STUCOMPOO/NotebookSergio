/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alu2015018
 */
public class Config {

    public int year;
    public int month;
    public String inputlanguage;
    public String outputlanguage;

    // public List<Config> configList = new ArrayList<>();

    /*public Config(int year, int month, String inputlanguage, String outputlanguage) {
        this.year = year;
        this.month = month;
        this.inputlanguage = inputlanguage;
        this.outputlanguage = outputlanguage;
    }*/

    public Config(List<String> configData){
        this.year = Integer.valueOf(configData.get(0));
        this.month = Integer.valueOf(configData.get(1));
        this.inputlanguage = configData.get(2);
        this.outputlanguage = configData.get(3);
    }

    /*public Config saveConfigFromFile(List<String> configData) {
        Config config;
        //año
        int year = Integer.valueOf(configData.get(0));
        //mes
        int month = Integer.valueOf(configData.get(1));
        //inputLanguage
        String inputLang = configData.get(2);
        //outputLanguage
        String outLang = configData.get(3);

        //creamos el objeto del tipo config
        config = new Config(year, month, inputLang, outLang);

        //configList.add(config);

        return config;
    }*/

    /*public List<Config> getConfigList() {
        if (configList.isEmpty()) {
            return null;
        } else {
            return configList;
        }
    }*/

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getInputlanguage() {
        return inputlanguage;
    }

    public void setInputlanguage(String inputlanguage) {
        this.inputlanguage = inputlanguage;
    }

    public String getOutputlanguage() {
        return outputlanguage;
    }

    public void setOutputlanguage(String outputlanguage) {
        this.outputlanguage = outputlanguage;
    }

    @Override
    public String toString() {
        return "config [year=" + year + ", month=" + month + ", inputlanguage=" + inputlanguage + ", outputlanguage="
                + outputlanguage + "]";
    }

}
