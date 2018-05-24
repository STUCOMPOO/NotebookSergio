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

    public Config(List<String> configData){
        this.year = Integer.valueOf(configData.get(0));
        this.month = Integer.valueOf(configData.get(1));
        this.inputlanguage = configData.get(2);
        this.outputlanguage = configData.get(3);
    }

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
