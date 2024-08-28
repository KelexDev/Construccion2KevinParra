package Controller;

import ControllerValidator.PersonValidator;
import ControllerValidator.UserValidator;
import Dto.PersonDto;
import Dto.UserDto;

public class AdminController {
    private PersonValidator personValidator;
    private UserValidator userValidator;
    
    public AdminController(){
        this.personValidator = new PersonValidator();
        this.userValidator = new UserValidator();
    }
    
    public void session() throws Exception{
        
    }
    
    public void createUser() throws Exception{
        
        System.out.println("Ingrese el nombre del Usuario: ");
        String name = Utils.getReader().nextLine();
        personValidator.validName(name);
        System.out.println("Ingrese la Cedula del Usuario: ");
        long document = personValidator.validDocument(Utils.getReader().nextLine());
        System.out.println("Ingrese la edaddel Usuario: ");
        //int age = personValidator.validAge(Utils.getReader().nextLine());
        //System.out.println("Ingrese el nombre de usuario: ");
        String username = Utils.getReader().nextLine();
        userValidator.validUserName(username);
        System.out.println("Ingrese la contraseña del usuario: ");
        String password = Utils.getReader().nextLine();
        userValidator.validPassword(password);
        
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setDocument(document);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUserName(username);
        userDto.setPassword(password);
        userDto.setRol("Usuario");
        
        System.out.println("Se ha creado el usuario con exito!");
        
        
        
        
        
        
        
       
        
        
        
        
        
        
        
        
        
        
    }
    
}
