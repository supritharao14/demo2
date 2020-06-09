package com.assignment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.DAO.AnimalDao;
import com.assignment.model.Pet;

public class PetServiceImpl implements AnimalService {
@Autowired
private AnimalDao petDao;

public List<Pet> getpets() {
return petDao.getpets();
}

public int savePet(Pet p) {
return petDao.savePet(p);
}

public boolean savePetByPreparedStatement(Pet p) {
return petDao.savePetByPreparedStatement(p);
}


public List<Pet> getpetsbyid(HttpSession se) {
return petDao.getpetsbyid(se);

}
 
}