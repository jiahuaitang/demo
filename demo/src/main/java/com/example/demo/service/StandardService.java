package com.example.demo.service;

import com.example.demo.vo.StandaryVo;
import com.example.demo.entity.StandaryEntity;

public interface StandardService {

    StandaryEntity findById(Integer id);

    StandaryEntity findByStandaryVo(StandaryVo standaryVo);
}
