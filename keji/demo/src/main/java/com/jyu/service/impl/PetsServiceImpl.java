package com.jyu.service.impl;

import com.jyu.dao.PetsDao;
import com.jyu.service.PetsService;
import com.jyu.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetsServiceImpl implements PetsService {
    @Autowired
    private PetsDao dao;
    @Override
    public List<Pet> queryAll() {
        return dao.findAll();
    }

    @Override
    public Pet queryById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void Update(Pet pet) {
        dao.save(pet);
    }

    @Override
    public void save(Pet pet) {
        dao.save(pet);
    }
}
