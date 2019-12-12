package com.jyu.service;

import com.jyu.entity.Pet;

import java.util.List;

public interface PetsService {
    public List<Pet> queryAll();
    public Pet queryById(Long id);
    public void delete(Long id);
    public void Update(Pet pet);
    public void save(Pet pet);
}
