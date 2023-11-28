package com.solvd.textAnalyzer.InnerFunctionality.TextProcessor;

import com.solvd.textAnalyzer.InnerFunctionality.Exceptions.InvalidWordException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@Log4j2
public class TextProcessorFromFile extends BaseTextProcessor {

    private static String content;

    private String chooseTextFileToRead() {
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

    @Override
    public TextProcessorFromFile countUniqueWords() {
        if (content == null) {
            content = chooseTextFileToRead();
        }
        String text = StringUtils.replaceAll(content, "[^A-Za-zА-Яа-я0-9\\s]", "");
        String[] allWords = StringUtils.split(text, " ");
        boolean[] array = new boolean[allWords.length];
        int uniqueWordsCounter = 0;
        for (int i = 0; i < allWords.length; i++) {
            if (!array[i]) {
                uniqueWordsCounter++;
                for (int j = i + 1; j < allWords.length; j++) {
                    if ((StringUtils.compareIgnoreCase(allWords[j], (allWords[i])) == 0)) {
                        array[j] = true;
                    }
                }
            }
        }
        log.info("Total number of unique words - {}", uniqueWordsCounter);
        return this;
    }

    @Override
    public TextProcessorFromFile countAmountOfLetters() throws IOException {
        if (content == null) {
            content = chooseTextFileToRead();
        }
        String text = StringUtils.replaceAll(content, "[^A-Za-zА-Яа-я]", "");
        String letters = StringUtils.toRootUpperCase(text);
        for (int i = 0; i < StringUtils.length(letters); i++) {
            log.info(letters.charAt(i) + " ");
            writer.write(letters.charAt(i) + " ");
        }
        log.info("Total amount of letters is - {}", StringUtils.length(letters));
        return this;
    }

    @Override
    public TextProcessorFromFile findACertainWord() {
        if (content == null) {
            content = chooseTextFileToRead();
        }
        String text = StringUtils.replaceAll(content, "[^A-Za-zА-Яа-я0-9\\s]", "");
        String[] allWords = StringUtils.split(text, " ");
        int wordsCounter = 0;
        log.info("Enter a specific word you want to find in the text");
        String certainWord = scanner.nextLine();
        while (!StringUtils.isAlphanumeric(certainWord)
                || StringUtils.length(certainWord) < 2 || certainWord.matches(".*[0-9].*")
                || StringUtils.contains(certainWord, " ")) {
            try {
                throw new InvalidWordException("The word is incorrect, type it again");
            } catch (InvalidWordException e) {
                log.error(e.getMessage());
                certainWord = scanner.nextLine();
            }
        }
        for (String allWord : allWords) {
            if (StringUtils.equalsIgnoreCase(allWord, certainWord)) {
                wordsCounter++;
            }
        }
        log.info("Total number of matches - {}", wordsCounter);
        return this;
    }
}
