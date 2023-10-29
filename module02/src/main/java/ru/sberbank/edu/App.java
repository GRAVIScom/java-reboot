package ru.sberbank.edu;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        FileStatistic statistic = new FileStatistic();
        statistic.save(statistic.getLineCount(), statistic.getSpaceCount(), statistic.getLongestLine());
    }
}
