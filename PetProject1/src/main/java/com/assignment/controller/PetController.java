package com.assignment.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.assignment.model.Pet;
import com.assignment.service.AnimalService;

@Controller
@SessionAttributes("name")
public class PetController {
	Logger log=Logger.getLogger(PetController.class);//log4j
	
@Autowired
private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

@Autowired
AnimalService petService;

public AnimalService getPetService() {
return petService;
}

public void setPetService(AnimalService petService) {
this.petService = petService;
}

@RequestMapping(value = "/savepet")
public String savePet(ModelMap m, HttpServletRequest req, @RequestParam("age") int age) {
String petname = req.getParameter("petname");
String place = req.getParameter("place");
log.info("inside savepet its in petController");//log4j
Pet p = new Pet();

p.setPet_name(petname);
p.setPet_age(age);

p.setPet_place(place);

int Count = petService.savePet(p);

if (Count > 0)

{

m.addAttribute("msg", "pet saved successfully");

} else {

m.addAttribute("msg", "failed to save pet details");

}

return "addpet";

}

@RequestMapping("/getpets")
public String getpets(ModelMap m) {
	log.info("inside getpets its in petController");
List<Pet> pets = petService.getpets();
m.addAttribute("petlist", pets);
return "home";

}

@RequestMapping("/buypet")
public String buypet(HttpSession see, Pet p, Model m, @RequestParam("petid") final int petid) {
final int id = (Integer) see.getAttribute("id");
String sql = "update pets set PET_OWNERID=? where pets.ID=?";
Boolean j = jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
ps.setLong(1, id);
ps.setLong(2, petid);
return ps.execute();

}

});
m.addAttribute("message", "Successfully bought the pet");
List<Pet> pets = petService.getpets();
m.addAttribute("petlist", pets);
return "home";
}

@RequestMapping("addpet")
public String addpet() {
return "addpet";

}

@RequestMapping("/idpets")

public String getpetsbyid(Model m, HttpSession see) {
	log.info("inside idpets its in petController");
int id = (Integer) see.getAttribute("id");
List<Pet> petlist = petService.getpetsbyid(see);
m.addAttribute("petlist", petlist);
System.out.println(petlist.size());
return "mypets";

}

}
