package com.assignment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.assignment.model.Pet;

public interface AnimalService {
public List<com.assignment.model.Pet> getpets();

public int savePet(Pet p);

public boolean savePetByPreparedStatement(final Pet p);
public List<Pet> getpetsbyid(HttpSession se);

}