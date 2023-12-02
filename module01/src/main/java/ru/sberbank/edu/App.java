package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Greeting greeting = new GreetingImpl();
        System.out.println(greeting.getBestHobby());

        CommonDivisor divisor = new GCD();
        System.out.println(divisor.getDivisor(12,4));
        }
    }
