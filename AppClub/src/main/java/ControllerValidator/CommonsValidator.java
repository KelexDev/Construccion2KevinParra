package ControllerValidator;


public abstract class CommonsValidator {
    
    public void isValidString(String element, String value) throws Exception{
        if (value.equals(" ")){
            throw new Exception (element + ",no puede ser un valor vacio."); //Se lanza una excepcion ya que el elemento no es valido 
        }
    }
    
    public int isValidInteger(String element, String value) throws Exception{
        isValidString(element, value);
        try {
            return Integer.parseInt(value); 
        }catch (Exception e){
            throw new Exception (element + ",debe ser una valor valido.");
        }
    }
    
    public long isValidLong(String element, String value) throws Exception{
       isValidString(element, value); //Primero se revisa si el String esta vacio
        try {
            return Long.parseLong(value); //Aca se parsea a un Long ya que de entrada es una String
        }catch (Exception e){
            throw new Exception (element + ",debe ser una valor valido.");
        } 
    }
    
    public double isValidDouble(String element, String value) throws Exception{
        isValidString(element, value);
        try{
            return Double.parseDouble(value);
        }catch(Exception e){
            throw new Exception(element + ",debe ser un valor valido.");
        }
    }
    
    
    
}
