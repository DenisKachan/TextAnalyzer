package com.solvd.textAnalyzer.menu;

import com.solvd.textAnalyzer.innerFunctionality.textProcessor.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

@Log4j2
public class MainMenu {

    private static TextProcessor textProcessor;

    public TextProcessor chooseAction() {
        textProcessor = null;
        log.info("Please enter 'console' if you want to print your own text or 'file' if you want to get text from the existing file");
        String option = ReaderWriter.scanner.nextLine();
        String neededOption = StringUtils.toRootLowerCase(option);
        switch (neededOption) {
            case "console" -> {
                ReaderWriter.option = "console";
                textProcessor = new TextProcessor();
            }
            case "file" -> {
                ReaderWriter.option = "file";
                textProcessor = new TextProcessor();
            }
        }
        return textProcessor;
    }

    public TextProcessor exit() {
        textProcessor = null;
        log.info("Your session is over");
        return textProcessor;
    }
}
