package com.stylefeng.guns.gateway.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.cinema.GuoCinemaService;
import com.stylefeng.guns.api.cinema.vo.CinemaResult;
import com.stylefeng.guns.api.cinema.vo.CinemaShow;
import com.stylefeng.guns.api.cinema.vo.ConditionShow;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cinema")
public class GuoCinemaController {

    @Reference(interfaceClass = GuoCinemaService.class,check = false)
    GuoCinemaService guoCinemaService;

    @RequestMapping("/getCinemas")
    @ResponseBody
    public CinemaResult getCinemas(CinemaShow cinemaShow){
        System.out.println(1);
        return guoCinemaService.getCinemaList(cinemaShow);
    }
    @RequestMapping("/getCondition")
    @ResponseBody
    public CinemaResult getCondition(ConditionShow conditionShow){
        return guoCinemaService.getCondition(conditionShow);
    }
}
