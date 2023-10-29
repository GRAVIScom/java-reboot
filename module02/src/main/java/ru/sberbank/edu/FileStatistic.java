package ru.sberbank.edu;

import java.io.*;
import java.util.List;

public class FileStatistic implements Statistic{
    public FileStatistic() {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    /**
     * Здесь начальный и конечный файл со статистикой.
     */
    private String inputFileName = "module02/src/main/java/ru/sberbank/edu/input.txt";
    private String outputFileName = "module02/src/main/java/ru/sberbank/edu/output.txt";

    /**
     * Метод возвращающий количество строк в файле.
     */
    @Override
    public int getLineCount() throws IOException {
        try (var lnr = new LineNumberReader(new BufferedReader(new FileReader(inputFileName)))) {
            while (lnr.readLine() != null) ;
            return lnr.getLineNumber();
        }
    }

    /**
     * Метод возвращающий количество пробелов в файле.
     */
    @Override
    public int getSpaceCount() throws IOException {
        int spaceCount = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName))) {
            List<String> lines = bufferedReader.lines().toList();
            for (String str : lines) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ' ') {
                        spaceCount += 1;
                    }
                }
            }
            return spaceCount;
        }
    }

    /**
     * Метод для поиска самой длинной строки.
     */
    @Override
    public String getLongestLine() throws IOException{
        int max = 0;
        String offer = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() > max) {
                    max = line.length();
                    offer = line;
                }
            }
            return offer;
        }
    }

    /**
     * Метод для сохранения в файл.
     */
    @Override
    public void save(int lineCount, int spaceCount, String line) throws IOException {
        try(FileWriter writer = new FileWriter(outputFileName)) {
            writer.write("Количество строк: " + lineCount + "; ");
            writer.write("Количество пробелов: " + spaceCount + "; ");
            writer.write("Самая длинная строка: " + line + ".");
        }
    }


}
