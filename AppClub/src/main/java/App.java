
import Controller.AdminController;
import Controller.InterfaceController;
import Controller.PartnerController;

public class App {
    
    public static void main(String[] args) {
        InterfaceController controllerAdmin = new AdminController();
        InterfaceController controllerPartner = new PartnerController();     
        try{
            controllerAdmin.session();
            controllerPartner.session();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
