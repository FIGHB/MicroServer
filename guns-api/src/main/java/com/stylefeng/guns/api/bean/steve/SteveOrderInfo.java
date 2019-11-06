package com.stylefeng.guns.api.bean.steve;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author Steve
 * @date 2019/10/16-20:42
 */
public class SteveOrderInfo implements Serializable {
    String UUID;
    int cinema_id;
    int field_id;
    int film_id;
    String seats_ids;
    String seats_name;
    double film_price;
    double order_price;
    Date order_time;
    int order_user;
    int order_status;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getSeats_ids() {
        return seats_ids;
    }

    public void setSeats_ids(String seats_ids) {
        this.seats_ids = seats_ids;
    }

    public String getSeats_name() {
        return seats_name;
    }

    public void setSeats_name(String seats_name) {
        this.seats_name = seats_name;
    }

    public double getFilm_price() {
        return film_price;
    }

    public void setFilm_price(double film_price) {
        this.film_price = film_price;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public int getOrder_user() {
        return order_user;
    }

    public void setOrder_user(int order_user) {
        this.order_user = order_user;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
}
