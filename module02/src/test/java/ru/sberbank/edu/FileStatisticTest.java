package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FileStatisticTest {

    @Test
    @DisplayName("Check line count")
    void getLineCount() throws IOException {
        FileStatistic fileStatistic = new FileStatistic();
        Assertions.assertThat(fileStatistic.getLineCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("Check space count")
    void getSpaceCount() throws IOException {
        FileStatistic fileStatistic = new FileStatistic();
        Assertions.assertThat(fileStatistic.getSpaceCount()).isEqualTo(6);
    }

    @Test
    @DisplayName("Check longest line")
    void getLongestLine() throws IOException {
        FileStatistic fileStatistic = new FileStatistic();
        Assertions.assertThat(fileStatistic.getLongestLine()).isEqualTo("Java developer");
    }
}