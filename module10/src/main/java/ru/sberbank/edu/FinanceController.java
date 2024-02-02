package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sberbank.edu.Service.FinanceService;

@Controller
@RequestMapping(value = "/finance")
public class FinanceController {
    @Autowired
    FinanceService financeService;

    @GetMapping
    public ModelAndView financeInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/finance.jsp");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView financeReq(@RequestParam("sum") String sum,
                                   @RequestParam("percent") String percent,
                                   @RequestParam("years") String years) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/calc.jsp");
        try {
            modelAndView.addObject("calc", financeService.inCorrectSum(sum, percent, years));
            return modelAndView;
        } catch (Exception ex) {
            System.out.println("find error");
            modelAndView.setViewName("/error.jsp");
            return modelAndView;
        }
    }


}