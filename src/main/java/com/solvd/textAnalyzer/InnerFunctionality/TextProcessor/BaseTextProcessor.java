package com.solvd.textAnalyzer.InnerFunctionality.TextProcessor;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Log4j2
public abstract class BaseTextProcessor {

    public static final Scanner scanner = new Scanner(System.in);

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


    public abstract BaseTextProcessor countUniqueWords() throws IOException;

    public abstract BaseTextProcessor countAmountOfLetters() throws IOException;

    public abstract BaseTextProcessor findACertainWord() throws IOException;
}
