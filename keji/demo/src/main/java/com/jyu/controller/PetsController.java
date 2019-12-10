package com.jyu.controller;

import com.jyu.entity.Pet;
import com.jyu.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PetsController {
    @Autowired
    private PetsService petsService;

    @GetMapping("queryall")
    public Map<String,Object> queryAll(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Pet> petList=new ArrayList<Pet>();
        petList=petsService.queryAll();
        modelMap.put("code",0);
        modelMap.put("data",petList);
        modelMap.put("size",petList.size());
        modelMap.put("msg","查询所有宠物成功");
        return modelMap;
    }

    @PostMapping("save")
    public Map<String,Object> save(@RequestBody Pet pet){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Pet> petList=new ArrayList<Pet>();
        petsService.save(pet);
        modelMap.put("code",0);
        modelMap.put("data",null);
        modelMap.put("size",0);
        modelMap.put("msg","添加成功");
        return modelMap;
    }
}
