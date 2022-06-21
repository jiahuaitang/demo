package com.example.demo.controller;

import com.example.demo.vo.ResultVo;
import com.example.demo.vo.StandaryVo;
import com.example.demo.entity.StandaryEntity;
import com.example.demo.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("standard")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @GetMapping("findById")
    public StandaryEntity findById(Integer id){
        return standardService.findById(id);
    }

    /**
     * 测试参数：{"id":1,"name":"测试","password":"1231","email":"123a","price":12}
     * @param standaryVo
     * @return
     */
    @PostMapping("findByStandaryVo")
    public ResultVo findByStandaryVo(@RequestBody @Validated StandaryVo standaryVo){
        return new ResultVo(standardService.findByStandaryVo(standaryVo));
    }

    /**
     * 测试参数：{"id":1,"name":"测试","password":"1231","email":"123a","price":12}
     * @param standaryVo
     * @return
     */
    @PostMapping("findByStandaryVoCopy")
    public StandaryEntity findByStandaryVoCopy(@RequestBody @Validated StandaryVo standaryVo){
        return standardService.findByStandaryVo(standaryVo);
    }

}
