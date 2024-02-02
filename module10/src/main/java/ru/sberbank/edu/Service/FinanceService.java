package ru.sberbank.edu.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class FinanceService {
    private int sum;
    private int percent;
    private int years;

    public String minSum;


    public int inCorrectSum(String a, String b, String c) {
        this.sum = Integer.parseInt(a);
        this.percent = Integer.parseInt(b);
        this.years = Integer.parseInt(c);
        if (checkCondition()) {
            return (int) calculation(sum, percent, years);
        }
        throw new RuntimeException("inCorrect value");
    }



    private boolean checkCondition() {
        return sum > 0 && percent > 0 && years > 0 && sum > Integer.parseInt(minSum);
    }

    private double calculation(double sum, double percent, double years) {
        return (sum * (percent / 100) * years) + sum;
    }
    @Value("${minSum}")
    public void setMinSum(String minSum) {
        this.minSum = minSum;
    }
}
