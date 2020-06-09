package com.assignment.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.assignment.model.Pet;

public interface AnimalDao {
public List<Pet> getpets();
public int savePet(Pet p);
public Boolean savePetByPreparedStatement(final Pet p);
public List<Pet> getpetsbyid(HttpSession se);

}
