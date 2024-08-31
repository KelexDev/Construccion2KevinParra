package Helpers;

import Dto.PersonDto;
import Dto.UserDto;
import Model.Person;
import Model.User;


public abstract class Helper {
    
    public static PersonDto parse(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setDocument(person.getDocument());
        personDto.setName(person.getName());
        return personDto;
    }
    
    public static Person parse(PersonDto personDto){
        Person person = new Person();
        person.setId(personDto.getId());
        personDto.setDocument(person.getDocument());
        personDto.setName(person.getName());
        return person;
    }
    
    public static UserDto parse(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setPersonId(parse(user.getPersonId()));
        userDto.setRol(userDto.getRol());
        userDto.setUserName(userDto.getUserName());
        return userDto;
    }
    
    public static User parse(UserDto userDto){
        User user = new User();
	user.setId(userDto.getId());
	user.setPassword(userDto.getPassword());
	user.setPersonId(parse(userDto.getPersonId()));
	user.setRol(userDto.getRol());
	user.setUserName(userDto.getUserName());
	return user;
    }
    
    
}
