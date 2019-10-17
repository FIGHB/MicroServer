package com.stylefeng.guns.film.modular.film;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.stylefeng.guns.api.film.FilmServiceZhao;
import com.stylefeng.guns.api.film.vo.BaseRespVo;
import com.stylefeng.guns.api.film.vo.FilmRequestInfo;
import com.stylefeng.guns.api.film.vo.FilmResponseInfo;
import com.stylefeng.guns.film.common.persistence.dao.FilmMapperZhao;
import com.stylefeng.guns.film.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.film.common.persistence.dao.MtimeFilmTMapperZhao;
import com.stylefeng.guns.film.common.persistence.model.CatVO;
import com.stylefeng.guns.film.common.persistence.model.SourceVO;
import com.stylefeng.guns.film.common.persistence.model.YearVO;
import com.stylefeng.guns.film.common.persistence.model.MtimeFilmTZhao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import com.baomidou.mybatisplus.plugins.pagination.PageHelper;

@Component
@Service(interfaceClass = FilmServiceZhao.class)
public class FilmServiceImplZhao implements FilmServiceZhao {
    @Autowired
    FilmMapperZhao filmMapperZhao;
    @Autowired
    MtimeFilmTMapperZhao mtimeFilmTMapper;

    @Override
    public HashMap getConditionList(Integer catId, Integer sourceId, Integer yearId) {
        if (catId==null || catId<1){
            catId = 99;
        }
        if (sourceId==null||catId<1){
            sourceId = 99;
        }
        if (yearId==null||yearId<1){
            yearId = 99;
        }
        ArrayList<CatVO> catVOList = filmMapperZhao.catQueryALL();
        for (CatVO catVO:catVOList){
            if (catVO.getCatId().equals(catId)){
                catVO.setActive(true);
            }
            catVO.setActive(false);
        }

        ArrayList<SourceVO> sourceVOList = filmMapperZhao.sourceQueryALL();
        for(SourceVO sourceVO:sourceVOList){
            if (sourceVO.getSourceId().equals(sourceId)){
                sourceVO.setActive(true);
            }
            sourceVO.setActive(false);
        }

        ArrayList<YearVO> yearVOList = filmMapperZhao.yearQueryAll();
        for (YearVO yearVO:yearVOList){
            if (yearVO.getYearId().equals(yearId)){
                yearVO.setActive(true);
            }
            yearVO.setActive(false);
        }

        HashMap<String, Object> conditionHashMap = new HashMap<>();
        conditionHashMap.put("catInfo",catVOList);
        conditionHashMap.put("sourceInfo",sourceVOList);
        conditionHashMap.put("yearInfo",yearVOList);
        return conditionHashMap;
    }

    @Override
    public BaseRespVo getFilms(FilmRequestInfo filmRequestInfo) {
        int showType ;
        if(filmRequestInfo.getShowType()!=null){
            showType = filmRequestInfo.getShowType();
        }else {
            showType = 1;
        }
        int pageSize;
        if(filmRequestInfo.getPageSize()!=null){
            pageSize = filmRequestInfo.getPageSize();
        }else {
            pageSize = 18;
        }
        int nowPage;
        if (filmRequestInfo.getNowPage()!=null){
            nowPage = filmRequestInfo.getNowPage();
        }else {
            nowPage = 1;
        }
        Page<MtimeFilmTZhao> page = new Page<>();
        page.setSize(pageSize);//当前几条数据
        page.setCurrent(nowPage);//当前第几页
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("film_status",showType);
        List<MtimeFilmTZhao> filmList = mtimeFilmTMapper.selectPage(page,entityWrapper);
        List<FilmResponseInfo> filmInfoList = convert2FilmInfoList(filmList);
        Long items = filmMapperZhao.filmQueryItems(showType);
        int totalPage = (int) Math.ceil(1.0*items/pageSize);
        BaseRespVo ok = BaseRespVo.ok(filmInfoList, "http://img.meetingshop.cn/", nowPage,totalPage );
        return ok;
    }

    private List<FilmResponseInfo> convert2FilmInfoList(List<MtimeFilmTZhao> filmList){
        ArrayList<FilmResponseInfo> filmInfoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(filmList)){
            for (MtimeFilmTZhao mtimeFilmT:filmList){
                FilmResponseInfo filmResponseInfo = new FilmResponseInfo();
                filmResponseInfo.setFilmId(mtimeFilmT.getUuid());
                filmResponseInfo.setFilmName(mtimeFilmT.getFilmName());
                filmResponseInfo.setFilmScore(mtimeFilmT.getFilmScore());
                filmResponseInfo.setFilmType(mtimeFilmT.getFilmType());
                filmResponseInfo.setImgAddress(mtimeFilmT.getImgAddress());
                filmInfoList.add(filmResponseInfo);
            }
        }
        return filmInfoList;
    }

//该方法，可以跑通，但是返回的数据不是文档中要求的数据，因为调用的mapper是代码生成器产生的，里面的参数没法按照要求封装到自定义类 FilmResponseInfo
 /*@Override
    public BaseRespVo getFilms(FilmRequestInfo filmRequestInfo) {
        int showType ;
        if(filmRequestInfo.getShowType()!=null){
            showType = filmRequestInfo.getShowType();
        }else {
            showType = 1;
        }
        int pageSize;
        if(filmRequestInfo.getPageSize()!=null){
            pageSize = filmRequestInfo.getPageSize();
        }else {
            pageSize = 18;
        }
        int nowPage;
        if (filmRequestInfo.getNowPage()!=null){
            nowPage = filmRequestInfo.getNowPage();
        }else {
            nowPage = 1;
        }
        Page<FilmResponseInfo> page = new Page<>();
        page.setSize(pageSize);//当前几条数据
        page.setCurrent(nowPage);//当前第几页
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("film_status",showType);
        List<FilmResponseInfo> filmList = mtimeFilmTMapper.selectPage(page,entityWrapper);
        Long items = filmMapperZhao.filmQueryItems(showType);
        int pages = (int) Math.ceil(items/pageSize);
        BaseRespVo ok = BaseRespVo.ok(filmList, "http://img.meetingshop.cn/", nowPage,pages);
        return ok;
    }



//该方法也正确。
 @Override
    public BaseRespVo getFilms(FilmRequestInfo filmRequestInfo) {
        int showType ;
        if(filmRequestInfo.getShowType()!=null){
            showType = filmRequestInfo.getShowType();
        }else {
            showType = 1;
        }
        int pageSize;
        if(filmRequestInfo.getPageSize()!=null){
            pageSize = filmRequestInfo.getPageSize();
        }else {
            pageSize = 18;
        }
        int nowPage;
        if (filmRequestInfo.getNowPage()!=null){
            nowPage = filmRequestInfo.getNowPage();
        }else {
            nowPage = 1;
        }
        PageHelper.startPage(nowPage,pageSize);
        ArrayList<FilmResponseInfo> filmList = filmMapperZhao.filmSelectByStatus(showType);
        Long items = filmMapperZhao.filmQueryItems(showType);
        int pages = (int) Math.ceil(items/pageSize);
        BaseRespVo ok = BaseRespVo.ok(filmList, null, filmRequestInfo.getNowPage(),pages);
        return ok;
    }*/

}
