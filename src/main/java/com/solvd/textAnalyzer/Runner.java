package com.solvd.textAnalyzer;

import com.solvd.textAnalyzer.innerFunctionality.textManipulator.FileReaderWriter;
import com.solvd.textAnalyzer.menu.MainMenu;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try (FileReaderWriter.scanner; FileReaderWriter.writer) {

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
