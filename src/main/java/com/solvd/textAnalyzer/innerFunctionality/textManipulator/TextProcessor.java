package com.solvd.textAnalyzer.innerFunctionality.textManipulator;

import com.solvd.textAnalyzer.innerFunctionality.exceptions.InvalidWordException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

@Log4j2
public class TextProcessor {

    public String neededText;

    public TextProcessor countUniqueWords() throws IOException {
        if (ReaderWriter.option.equals("console")){
            log.info("Enter any kind of text");
            neededText = ReaderWriter.scanner.nextLine();
            ReaderWriter.writer.write(neededText);
        } else { if(ReaderWriter.content == null){
            neededText = ReaderWriter.chooseTextFileToRead();}

        }
        String text = StringUtils.replaceAll(neededText, "[^A-Za-zА-Яа-я0-9\\s]", "");
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

    public TextProcessor countAmountOfLetters() throws IOException {
        if (ReaderWriter.option.equals("console")){
            log.info("Enter any kind of text");
            neededText = ReaderWriter.scanner.nextLine();
            ReaderWriter.writer.write(neededText);
        } else { if(ReaderWriter.content == null){
            neededText = ReaderWriter.chooseTextFileToRead();}

        }
        String text = StringUtils.replaceAll(neededText, "[^A-Za-zА-Яа-я]", "");
        String letters = StringUtils.toRootUpperCase(text);
        for (int i = 0; i < StringUtils.length(letters); i++) {
            log.info(letters.charAt(i) + " ");
            ReaderWriter.writer.write(letters.charAt(i) + " ");
        }
        log.info("Total amount of letters is - {}", StringUtils.length(letters));
        return this;
    }

    public TextProcessor findACertainWord() throws IOException {
        if (ReaderWriter.option.equals("console")){
            log.info("Enter any kind of text");
            neededText = ReaderWriter.scanner.nextLine();
            ReaderWriter.writer.write(neededText);
        } else { if(ReaderWriter.content == null){
            neededText = ReaderWriter.chooseTextFileToRead();}
        }
        String text = StringUtils.replaceAll(neededText, "[^A-Za-zА-Яа-я0-9\\s]", "");
        String[] allWords = StringUtils.split(text, " ");
        int wordsCounter = 0;
        log.info("Enter a specific word you want to find in the text");
        String certainWord = ReaderWriter.scanner.nextLine();
        while (!StringUtils.isAlphanumeric(certainWord)
                || StringUtils.length(certainWord) < 2 || certainWord.matches(".*[0-9].*")
                || StringUtils.contains(certainWord, " ")) {
            try {
                throw new InvalidWordException("The word is incorrect, type it again");
            } catch (InvalidWordException e) {
                log.error(e.getMessage());
                certainWord = ReaderWriter.scanner.nextLine();
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
