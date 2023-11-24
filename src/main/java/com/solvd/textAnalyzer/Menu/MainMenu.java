package com.solvd.textAnalyzer.Menu;

import com.solvd.textAnalyzer.InnerFunctionality.TextReader.BaseReader;
import com.solvd.textAnalyzer.InnerFunctionality.TextReader.TextReaderFromConsole;
import com.solvd.textAnalyzer.InnerFunctionality.TextReader.TextReaderFromFile;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

@Log4j2
public class MainMenu {

    private static BaseReader baseReader;

    public BaseReader chooseAction() {
        baseReader = null;
        log.info("Please enter 'console' if you want to print your own text or 'file' if you want to get text from the existing file");
        String option = BaseReader.scanner.nextLine();
        String neededOption = StringUtils.toRootLowerCase(option);
        switch (neededOption) {
            case "console" -> {
                baseReader = new TextReaderFromConsole();
            }
            case "file" -> {
                baseReader = new TextReaderFromFile();
            }
        }
        return baseReader;
    }

    public BaseReader exit() {
        baseReader = null;
        log.info("Your session is over");
        return baseReader;
    }
}
