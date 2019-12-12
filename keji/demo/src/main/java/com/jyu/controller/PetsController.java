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

    @GetMapping("queryall")//查询全部
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

    @PostMapping("save")//新增
    public void save(@RequestBody Pet pet){
        petsService.save(pet);
        System.out.println("新增成功");
    }

    @GetMapping("querybyid/{id:\\d+}")//详细查询
    public Map<String,Object> queryById(@PathVariable Long id){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Pet pet = petsService.queryById(id);
        modelMap.put("code",0);
        modelMap.put("data",pet);
        modelMap.put("size",1);
        modelMap.put("msg","查询成功");
        return modelMap;
    }

    @DeleteMapping("delete/{id:\\d+}")//删除
    public void delete(@PathVariable Long id){
        petsService.delete(id);
        System.out.println("删除成功");
    }

    @PutMapping("update")//修改
    public void update(@RequestBody Pet pet){
        petsService.save(pet);
        System.out.println("修改成功");
    }
}
