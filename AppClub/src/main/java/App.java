
import Controller.AdminController;

public class App {
    
    public static void main(String[] args) {
        AdminController controller = new AdminController();
        
        try{
            controller.createUser();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
