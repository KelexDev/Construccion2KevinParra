package Controller;

import ControllerValidator.PersonValidator;
import ControllerValidator.UserValidator;
import Dto.GuestDto;
import Dto.PersonDto;
import Dto.UserDto;

public class PartnerController implements InterfaceController { 
    private PersonValidator personValidator;
    private UserValidator userValidator;
    private static final String MENU = "Ingrese la opcion que desea \n 1. Para crear invitado. \n 3. Para cerrar.";
    

    public PartnerController(){
        this.personValidator = new PersonValidator();
        this.userValidator = new UserValidator();      
    }
    
    @Override
    public void session() throws Exception{
        boolean session = true;
        while(session){
            session = partnerSession();
        }
    }
    
    private boolean partnerSession() throws Exception{
	try {
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return menu (option);
    } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;		
    }
    }
    
    private boolean menu(String option) throws Exception{
        switch (option){
            case "1" : {
                this.createGuest();
                return true;
            }
            case "2": {
                System.out.println("Se ha cerrado la sesion");
                return false;
            }
            default: {
                System.out.println("Opcion invalida");
                return true;
            }
        }
    }
        
    private void createGuest() throws Exception{
        System.out.println("Ingrese el nombre del Invitado: ");
        String name = Utils.getReader().nextLine();
        personValidator.validName(name);
        System.out.println("Ingrese la Cedula del Invitado: ");
        long document = personValidator.validDocument(Utils.getReader().nextLine());
        System.out.println("Ingrese el Usuario del invitado: ");
        String username = Utils.getReader().nextLine();
        userValidator.validUserName(username);
        System.out.println("Ingresar la contraseña: ");
        String password = Utils.getReader().nextLine();
        
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setDocument(document);
        UserDto userDto = new UserDto();
        GuestDto guestDto = new GuestDto();
        userDto.setUserName(username);
        userDto.setPassword(password);
        userDto.setRol("Usuario");
        guestDto.setUserId(userDto);
        
        System.out.println("Se ha creado el usuario (invitado) con exito!");    
    }        
}
    

     