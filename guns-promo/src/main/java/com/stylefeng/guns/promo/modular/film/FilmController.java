package com.stylefeng.guns.promo.modular.film;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {

    @RequestMapping("/test")
    public String test() {
        return "ok";
    }
}
