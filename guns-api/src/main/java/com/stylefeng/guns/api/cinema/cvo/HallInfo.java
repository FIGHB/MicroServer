package com.stylefeng.guns.api.cinema.cvo;

import java.io.Serializable;

public class HallInfo implements Serializable {
    private static final long serialVersionUID = 7519573525227607708L;
    private String hallFieldId;
    private String hallName;
    private Integer price;
    private String seatFile;
    private String soldSeats;

    public String getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(String hallFieldId) {
        this.hallFieldId = hallFieldId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSeatFile() {
        return seatFile;
    }

    public void setSeatFile(String seatFile) {
        this.seatFile = seatFile;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }

    @Override
    public String toString() {
        return "HallInfo{" +
                "hallFieldId='" + hallFieldId + '\'' +
                ", hallName='" + hallName + '\'' +
                ", price=" + price +
                ", seatFile='" + seatFile + '\'' +
                ", soldSeats='" + soldSeats + '\'' +
                '}';
    }
}
