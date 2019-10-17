package com.stylefeng.guns.cinema.modular.guoservice;

import com.alibaba.dubbo.config.annotation.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stylefeng.guns.api.cinema.GuoCinemaService;
import com.stylefeng.guns.api.cinema.vo.*;
import com.stylefeng.guns.cinema.common.persistence.dao.GuoCinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service(interfaceClass = GuoCinemaService.class)
public class CinemaServiceImpl implements GuoCinemaService {
    @Autowired
    GuoCinemaMapper guoCinemaMapper;

    @Override
    public CinemaResult getCinemaList(CinemaShow cinemaShow) {
        if(cinemaShow.getHalltypeId()==null||cinemaShow.getHalltypeId()==99){
            cinemaShow.setHallIds("#");
        }else {
            cinemaShow.setHallIds("#"+cinemaShow.getHalltypeId()+"#");
        }
        if(cinemaShow.getNowPage()!=null&&cinemaShow.getPageSize()!=null){
            PageHelper.startPage(cinemaShow.getNowPage(),cinemaShow.getPageSize());
        }else if(cinemaShow.getNowPage()==null&&cinemaShow.getPageSize()!=null){
            PageHelper.startPage(1,cinemaShow.getPageSize());
        }else if(cinemaShow.getNowPage()!=null&&cinemaShow.getPageSize()==null){
            cinemaShow.setPageSize(12);
            PageHelper.startPage(cinemaShow.getNowPage(),12);
        }else{
            cinemaShow.setPageSize(12);
            PageHelper.startPage(1,12);
        }
        List<Cinema> cinemaList = guoCinemaMapper.getCinemaListByDetail(cinemaShow);
        PageInfo<Cinema> pageInfo=new PageInfo<>(cinemaList);
        long total = pageInfo.getTotal();
        long totalPage;
        if(total%cinemaShow.getPageSize()==0){
            totalPage=total/cinemaShow.getPageSize();
        }else {
            totalPage=total/cinemaShow.getPageSize()+1;
        }

        if(cinemaShow.getNowPage()==null){
            cinemaShow.setNowPage(1);
        }
        long totalPage1=totalPage;
        Integer totalPage2=(int)totalPage1;

        for (int i = 0; i < cinemaList.size(); i++) {
            Cinema cinema = cinemaList.get(i);
            cinema.setCinemaAddress(cinema.getAddress());
        }

        return CinemaResult.ok(cinemaList,cinemaShow.getNowPage(), totalPage2);
    }

    @Override
    public CinemaResult getCondition(ConditionShow conditionShow) {
        Conditions conditions = new Conditions();

        //brandList
        List<Brand> brandList;
        try{
            brandList=guoCinemaMapper.getBrandList();
            if(brandList==null){
                return CinemaResult.businessException();
            }
        }catch(Exception e){
            CinemaResult cinemaResult = CinemaResult.SystemException();
            return cinemaResult;
        }
        if(conditionShow.getBrandId()==null){
            conditionShow.setBrandId(99);
        }
        for (int i = 0; i < brandList.size(); i++) {
            if(conditionShow.getBrandId()==brandList.get(i).getBrandId()){
                brandList.get(i).setActive(true);
            }else {
                brandList.get(i).setActive(false);
            }
        }
        conditions.setBrandList(brandList);

        //areaList
        List<Area> areaList;
        try{
            areaList=guoCinemaMapper.getAreaList();
            if(areaList==null){
                return CinemaResult.businessException();
            }
        }catch(Exception e){
            return CinemaResult.SystemException();
        }
        if(conditionShow.getAreaId()==null){
            conditionShow.setAreaId(99);
        }
        for (int i = 0; i < areaList.size(); i++) {
            if(conditionShow.getAreaId()==areaList.get(i).getAreaId()){
                areaList.get(i).setActive(true);
            }else {
                areaList.get(i).setActive(false);
            }
        }
        conditions.setAreaList(areaList);

        //hallList
        List<Halltype> halltypeList;
        try {
            halltypeList=guoCinemaMapper.getHalltypeList();
            if(halltypeList==null){
                return CinemaResult.businessException();
            }
        }catch(Exception e){
            return CinemaResult.SystemException();
        }
        if(conditionShow.getHallType()==null){
            conditionShow.setHallType(99);
        }
        for (int i = 0; i < halltypeList.size(); i++) {
            if(conditionShow.getHallType()==halltypeList.get(i).getHalltypeId()){
                halltypeList.get(i).setActive(true);
            }else {
                halltypeList.get(i).setActive(false);
            }
        }
        conditions.setHalltypeList(halltypeList);
        return CinemaResult.ok(conditions,null,null);
    }

    @Override
    public CinemaResult getFields(Integer cinemaId) {
        Fields fields = new Fields();

        Cinema cinema=null;
        try{
            cinema= guoCinemaMapper.getCinemaInfoById(cinemaId);
        }catch(Exception e){
            return CinemaResult.businessException();
        }
        fields.setCinemaInfo(cinema);

        List<FilmField> fieldList=null;
        try{
            fieldList=guoCinemaMapper.getFieldByCinemaId(cinemaId);
            if(fieldList==null){
                return CinemaResult.businessException();
            }
        }catch(Exception e){
            return CinemaResult.businessException();
        }

        List<FilmInfo> filmInfoList=new ArrayList<>();

        outer:for (FilmField filmField : fieldList) {
            Integer filmId = filmField.getFilmId();
            for (int i = 0; i < filmInfoList.size(); i++) {
                if(filmInfoList.get(i).getFilmId()==filmId){
                    FilmInfo filmInfo = filmInfoList.get(i);
                    List<FilmField> filmFields = filmInfo.getFilmFields();
                    filmField.setLanguage(filmInfo.getFilmType());
                    filmFields.add(filmField);
                    continue outer;
                }
            }
            FilmInfo filmInfo=null;
            try{
                filmInfo=guoCinemaMapper.getFilmInfoByFilmId(filmId);
                if(filmInfo==null){
                    return CinemaResult.businessException();
                }
            }catch(Exception e){
                return CinemaResult.SystemException();
            }
            List<FilmField> filmFields=new ArrayList<>();
            filmField.setLanguage(filmInfo.getFilmType());
            filmFields.add(filmField);
            filmInfo.setFilmFields(filmFields);

            FilmInfo filmInfo1=guoCinemaMapper.getFilmLength(filmId);
            filmInfo.setFilmLength(filmInfo1.getFilmLength());

            filmInfoList.add(filmInfo);
        }
        fields.setFilmList(filmInfoList);
        return CinemaResult.ok(fields,null,null);
    }
}
