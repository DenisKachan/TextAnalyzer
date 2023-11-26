package com.solvd.textAnalyzer;

import com.solvd.textAnalyzer.InnerFunctionality.TextProcessor.BaseTextProcessor;
import com.solvd.textAnalyzer.Menu.MainMenu;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try (BaseTextProcessor.scanner; BaseTextProcessor.writer) {

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
