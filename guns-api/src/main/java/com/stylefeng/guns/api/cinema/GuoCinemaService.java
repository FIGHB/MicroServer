package com.stylefeng.guns.api.cinema;

import com.stylefeng.guns.api.cinema.vo.CinemaResult;
import com.stylefeng.guns.api.cinema.vo.CinemaShow;
import com.stylefeng.guns.api.cinema.vo.ConditionShow;


public interface GuoCinemaService {

    CinemaResult getCinemaList(CinemaShow cinemaShow);

    CinemaResult getCondition(ConditionShow conditionShow);
}
