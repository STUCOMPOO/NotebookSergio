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

    String FILE_PATH;
    FileUtils fileUtils;
    String directoryPath;
    List<String> configList;
    File fileAux;
    Map<String, String[]> mapAux;

    @Before
    public void setUp() {
        FILE_PATH = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        //FILE_PATH="C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        fileUtils = new FileUtils();
        directoryPath = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal";
        //directoryPath = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal";
        configList = new ArrayList<>();
        mapAux = new HashMap<>();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void readConfig() {

        configList = fileUtils.readFileByPath(FILE_PATH);
        fileAux = fileUtils.readLanguageFile(directoryPath);
        mapAux = fileUtils.readFileByFile(fileAux);

        //recorremos el map para ver si se han añadido correctmante las traducciones
        for (Map.Entry<String, String[]> e : mapAux.entrySet()) {
            //al tener un array de string, tenemos que recorrer el array de nuevo
            System.out.println(e.getKey());
            for (String b : e.getValue()) {
                System.out.println(b);
            }
        }

    }
}
