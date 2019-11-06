package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.api.film.vo.FilmResponseInfo;
import com.stylefeng.guns.film.common.persistence.model.CatVO;
import com.stylefeng.guns.film.common.persistence.model.SourceVO;
import com.stylefeng.guns.film.common.persistence.model.YearVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FilmMapperZhao {
    ArrayList<CatVO> catQueryALL();
    ArrayList<SourceVO> sourceQueryALL();
    ArrayList<YearVO> yearQueryAll();
    ArrayList<FilmResponseInfo> filmSelectByStatus(@Param("film_status") int showType);

    Long filmQueryItems(@Param("film_status") int showType);


}
