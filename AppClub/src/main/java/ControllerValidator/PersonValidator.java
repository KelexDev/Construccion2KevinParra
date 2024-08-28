package ControllerValidator;

public class PersonValidator extends CommonsValidator{ //Esta heredando el 

    public PersonValidator(){
        super();
    }
    
    public void validName(String name) throws Exception{
        super.isValidString("El nombre de la persona ", name);
    }
    
    public long validDocument(String document) throws Exception{ //String ya que recibe este tipo de dato desde la consola.
        return super.isValidLong("La cedula de la persona " , document);
    }
    
    public int validAge(String age) throws Exception{
        return super.isValidInteger("La edad de la persona " , age);
    }
    

    
}
