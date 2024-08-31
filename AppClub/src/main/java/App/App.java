package App;

import Config.MYSQLConnection;
import Controller.InterfaceController;
import Controller.LoginController;


public class App {
    
    public static void main(String[] args) throws Exception {
        InterfaceController controller = new LoginController();    
        try{
            controller.session();
            MYSQLConnection.getConnection();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}