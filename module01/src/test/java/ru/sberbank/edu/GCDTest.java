package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class GCDTest {
    @Test
    @DisplayName("get Divisor")
    void getDivisor() {
        CommonDivisor divisor = new GCD();

        Assertions.assertThat(divisor.getDivisor(12,4)).isEqualTo(4);
    }
}