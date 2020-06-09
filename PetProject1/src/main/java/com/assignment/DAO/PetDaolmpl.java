package com.assignment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.model.Pet;
import org.springframework.jdbc.core.RowMapper;

public class PetDaolmpl implements AnimalDao {
@Autowired
private org.springframework.jdbc.core.JdbcTemplate JdbcTemplate;

public void setJdbcTemplate(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
this.JdbcTemplate = jdbcTemplate;
}

public List<Pet> getpets() {
String query = "select * from pets";
PetRowMapper p = new PetRowMapper();
List<Pet> pets = JdbcTemplate.query(query, p);
return pets;
}

public int savePet(Pet p) {
String query = "insert into pets(pet_name,pet_age,pet_place) values('" + p.getPet_name() + "','"
+ p.getPet_age() + "','" + p.getPet_place() + "')";
return JdbcTemplate.update(query);
}

public Boolean savePetByPreparedStatement(Pet p) {
return null;
}

class PetRowMapper implements RowMapper<Pet> {

public Pet mapRow(ResultSet rs, int rownum) throws SQLException {
Pet p = new Pet();
p.setId(rs.getInt("id"));

p.setPet_name(rs.getString("pet_name"));
//System.out.println(p.getPet_name());

p.setPet_age(rs.getInt("pet_age"));

p.setPet_place(rs.getString("pet_place"));
p.setPet_ownerid(rs.getInt("pet_ownerid"));
return p;
}

}

public List<Pet> getpetsbyid(HttpSession se) {
int id = (Integer) se.getAttribute("id");
System.out.println(id);
String query = "select * from pets where PET_OWNERID ="+id;
PetRowMapper p = new PetRowMapper();
List<Pet> pets = JdbcTemplate.query(query, p);
return pets;

}

}
