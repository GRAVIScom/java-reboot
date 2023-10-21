package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GreetingImplTest {
    @Test
    @DisplayName("check hobbie")
    void getHobbie(){
        GreetingImpl greetingImpl = new GreetingImpl();

        Assertions.assertThat(greetingImpl.getBestHobby()).isEqualTo("Sport,Music,Books");
    }
}