package com.solvd.textAnalyzer;

import com.solvd.textAnalyzer.InnerFunctionality.TextReader.BaseReader;
import com.solvd.textAnalyzer.Menu.MainMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BaseReader.scanner; BaseReader.writer) {

            MainMenu mainMenu = new MainMenu();
            mainMenu.chooseAction().
                    countUniqueWords().
                    countAmountOfLetters().
                    findACertainWord();
            mainMenu.exit();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
