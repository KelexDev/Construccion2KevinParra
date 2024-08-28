package ControllerValidator;


public class UserValidator extends CommonsValidator {
    
    public UserValidator(){
        super();
    }
    
    public void validUserName(String userName) throws Exception{
        super.isValidString("El usuario de la persona: " , userName); 
    }
    
    public void validPassword(String password) throws Exception{
        super.isValidString("La contraseña de la persona: ", password);
    }
    
    
}
