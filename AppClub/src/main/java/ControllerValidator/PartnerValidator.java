
package ControllerValidator;


public class PartnerValidator extends CommonsValidator {
    
    public void validName(String name) throws Exception{
        super.isValidString("El nombre de la persona ", name);
    }
    
    public long validDocument(String document) throws Exception{ //String ya que recibe este tipo de dato desde la consola.
        return super.isValidLong("La cedula de la persona " , document);
    }
    
    
    
}
