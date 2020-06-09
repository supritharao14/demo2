package com.assignment.model;

public class Pet {
int id;
String pet_name;
int pet_age;
String pet_place;
int pet_ownerid;

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getPet_name() {
return pet_name;
}

public void setPet_name(String pet_name) {
this.pet_name = pet_name;
}

public int getPet_age() {
return pet_age;
}

public void setPet_age(int pet_age) {
this.pet_age = pet_age;
}

public String getPet_place() {
return pet_place;
}

public void setPet_place(String pet_place) {
this.pet_place = pet_place;
}

public int getPet_ownerid() {
return pet_ownerid;
}

public void setPet_ownerid(int i) {
this.pet_ownerid = i;
}

public Pet() {
super();
}

public Pet(int id, String pet_name, int pet_age, String pet_place, int pet_ownerid) {
super();
this.id = id;
this.pet_name = pet_name;
this.pet_age = pet_age;
this.pet_place = pet_place;
this.pet_ownerid = pet_ownerid;
}


}