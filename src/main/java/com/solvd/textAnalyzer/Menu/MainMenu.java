package com.solvd.textAnalyzer.Menu;

import com.solvd.textAnalyzer.InnerFunctionality.TextProcessor.BaseTextProcessor;
import com.solvd.textAnalyzer.InnerFunctionality.TextProcessor.TextProcessorFromConsole;
import com.solvd.textAnalyzer.InnerFunctionality.TextProcessor.TextProcessorFromFile;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

@Log4j2
public class MainMenu {

    private static BaseTextProcessor baseTextProcessor;

    public BaseTextProcessor chooseAction() {
        baseTextProcessor = null;
        log.info("Please enter 'console' if you want to print your own text or 'file' if you want to get text from the existing file");
        String option = BaseTextProcessor.scanner.nextLine();
        String neededOption = StringUtils.toRootLowerCase(option);
        switch (neededOption) {
            case "console" -> {
                baseTextProcessor = new TextProcessorFromConsole();
            }
            case "file" -> {
                baseTextProcessor = new TextProcessorFromFile();
            }
        }
        return baseTextProcessor;
    }

    public BaseTextProcessor exit() {
        baseTextProcessor = null;
        log.info("Your session is over");
        return baseTextProcessor;
    }
}
