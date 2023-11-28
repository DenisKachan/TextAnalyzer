package com.solvd.textAnalyzer.innerFunctionality.textProcessor;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Log4j2
public class ReaderWriter {

    public static final Scanner scanner = new Scanner(System.in);

    public static String option;
    public static String content;

    public static String pathName = "src/main/resources/fileForWriting.txt";

    public static final File fileForWriting = new File(pathName);

    public static final FileWriter writer;

    static {
        try {
            writer = new FileWriter(fileForWriting);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String chooseTextFileToRead() {
        log.info("Enter the name of the text file from the project directory");
        try {
            content = new Scanner(new File(BaseTextProcessor.scanner.nextLine())).useDelimiter("\\Z").next();
            log.info("You chose a file with the following text: {}", content);
            return content;
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
