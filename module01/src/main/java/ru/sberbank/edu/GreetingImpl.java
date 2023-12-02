package ru.sberbank.edu;

public class GreetingImpl implements Greeting {
    @Override
    /** Метод возвращающий хобби
     * @retutn - хобби
     */
    public String getBestHobby() {
        String hobbie = "Sport,Music,Books";
        return hobbie;
    }
}
