package Controller;

import ControllerValidator.PersonValidator;
import ControllerValidator.UserValidator;
import Dto.PersonDto;
import Dto.UserDto;
import Service.Service;
import ServiceInterfaces.AdminService;

public class AdminController implements InterfaceController{
    
    private PersonValidator personValidator;
    private UserValidator userValidator;
    private AdminService service;
    private static final String MENU = "Ingrese la opcion que desea \n 1. Para crear socio. \n 3. Para cerrar.";
    
    
    public AdminController(){
        this.personValidator = new PersonValidator();
        this.userValidator = new UserValidator();
        this.service = new Service();
    }
    
    
    public void session() throws Exception{
        boolean session = true;
        while(session) {
            session = menu();   
        }
    }
    
    private boolean menu(){
        try {
            //System.out.println("Bienvenido " + Service.user.getUserName()); 
            System.out.print("Bienvenido Admin \n" + MENU);
            String option = Utils.getReader().nextLine();
            return options(option);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return true;
        }
    }
 
    private boolean options(String option) throws Exception{
        switch(option){
            case"1": {
                this.createUser();
                return true;
            }
            case "2":{
                System.out.println("Se ha cerrado la sesion");
                return true;
            }
            default:{
                System.out.println("Ingrese una opcion valida.");
                return true;
            }
        }
    }
    
    private void createUser() throws Exception{
        
        System.out.println("Ingrese el nombre del Usuario: ");
        String name = Utils.getReader().nextLine();
        personValidator.validName(name);
        System.out.println("Ingrese la Cedula del Usuario: ");
        long document = personValidator.validDocument(Utils.getReader().nextLine());
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
