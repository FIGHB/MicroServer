package com.stylefeng.guns.api.cinema;

        import com.stylefeng.guns.api.cinema.cvo.CWCinemaFields;
        import com.stylefeng.guns.api.cinema.cvo.CWInfo;

public interface CWCinemaService {
    CWInfo queryCWInfo(Integer cinemaId, Integer fieldId);
    /*CWCinemaFields queryCWCinemaFields(Integer cinemaId);*/
}
