package com.stylefeng.guns.gateway.modular.cinema;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.cinema.CWCinemaService;
import com.stylefeng.guns.api.cinema.cvo.CWCinemaFields;
import com.stylefeng.guns.api.cinema.cvo.CWInfo;
import com.stylefeng.guns.gateway.modular.cinema.vo.BaseRespVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CWCinemaController {
    @Reference(interfaceClass = CWCinemaService.class)
    CWCinemaService cwCinemaService;
   /* @GetMapping("/cinema/getFields")
    public BaseRespVo<CWCinemaFields> getFields(Integer cinemaId) {
        CWCinemaFields cwCinemaFields = cwCinemaService.queryCWCinemaFields(cinemaId);
        return BaseRespVo.ok(cwCinemaFields);
    }


   */

    @PostMapping("/cinema/getFieldInfo")
    public BaseRespVo<CWInfo> getFieldInfo(Integer cinemaId, Integer fieldId) {
        CWInfo cwInfo = cwCinemaService.queryCWInfo(cinemaId,fieldId);
        return BaseRespVo.ok(cwInfo);
    }

}
