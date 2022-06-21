package com.example.demo.service.impl;

import com.example.demo.result.AppCode;
import com.example.demo.exception.APIException;
import com.example.demo.vo.StandaryVo;
import com.example.demo.entity.StandaryEntity;
import com.example.demo.service.StandardService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StandardServiceImpl implements StandardService {

    @Override
    public StandaryEntity findById(Integer id) {
        return new StandaryEntity();
    }

    @Override
    public StandaryEntity findByStandaryVo(StandaryVo standaryVo) {
        if(standaryVo.getId() == 1){
            throw new APIException(AppCode.ID_NOT_EXIST,"id不存在："+standaryVo.getId());
        }
        return new StandaryEntity(1,"测试",new BigDecimal(12));
    }
}
