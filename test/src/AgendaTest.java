/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import UtilsFile.FileUtils;
import entities.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Request;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author alu2015018
 */
public class AgendaTest {

    public AgendaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    String FILE_PATH_PETICIONES, FILE_PATH_CONFIG;
    FileUtils fileUtils;
    String directoryPath;
    List<String> configList;
    File fileAux;
    Map<String, String[]> mapAux;
    Request request;
    Config config;

    @Before
    public void setUp() {
        //FILE_PATH_PETICIONES = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\peticions.txt";
        //FILE_PATH_CONFIG = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        FILE_PATH_PETICIONES = "C:\\Users\\alu2014044\\Desktop\\Enunciado práctica en grupo Agenda-20180413\\peticions.txt";
        FILE_PATH_CONFIG = "C:\\Users\\alu2014044\\Desktop\\Enunciado práctica en grupo Agenda-20180413\\config.txt";
        fileUtils = new FileUtils();
        //directoryPath = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal";
        directoryPath = "C:\\Users\\alu2014044\\Desktop\\Enunciado práctica en grupo Agenda-20180413";
        configList = new ArrayList<>();
        mapAux = new HashMap<>();
        config = null;

    }


    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void readConfigAndGetLanguageFileByLangSpecified() {
        //leemos el archivo config.txt
        configList = fileUtils.readFileByPath(FILE_PATH_CONFIG);
        config = new Config(configList);
        System.out.println("\n");
        //obtenemos el archivo internacional dependiendo del idioma especificado en la configuracion
        fileAux = fileUtils.getLanguageFile(config.getOutputlanguage(), directoryPath);

        fileUtils.getTraductionsFromFile(fileAux);

        //fileUtils.getMonthByNum();
    }


}
