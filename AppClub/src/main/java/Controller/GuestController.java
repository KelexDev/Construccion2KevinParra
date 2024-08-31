package Controller;

import ControllerValidator.PersonValidator;
import ControllerValidator.UserValidator;


public class GuestController implements InterfaceController {
    
    private PersonValidator personValidator;
    private UserValidator userValidator;
    
    private static final String MENU = "Ingrese la opcion que desea \n 1. Para cambiar a socio. \n 3. Para cerrar.";
    
    public GuestController(){
    this.personValidator = new PersonValidator();
    this.userValidator = new UserValidator();
    }
    
    public void session()throws Exception{
        boolean session = true;
        while(session){
            session = menu();
        }
    }
    
    private boolean menu(){
        try{
          //  System.out.println("Bienvenido " + Service.user.getUserName()); 
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return true;          
        }   
    }
    
    private boolean options(String option) throws Exception{
        switch(option){
            case "1":{
                this.changeRol();
                return true;
            }
            case "2":{
                System.out.println("Se ha cerrado la sesion.");
                return false;
            }
            default:{
                System.out.println("Ingrese una opcion valida");
                return true;
            }
        }
    }
    
    private void changeRol() throws Exception{
        
        
        
        
    }
    
}
