package Service;

import Dao.PartnerDaoImplementation;
import Dao.UserDaoImplementation;
import DaoInterfacaces.PartnerDao;
import DaoInterfacaces.PersonDao;
import DaoInterfacaces.UserDao;
import Dto.PartnerDto;
import Dto.PersonDto;
import Dto.UserDto;
import ServiceInterfaces.AdminService;
import ServiceInterfaces.GuestService;
import ServiceInterfaces.LoginService;
import ServiceInterfaces.PartnerService;

public class Service implements LoginService, AdminService, GuestService, PartnerService{
    private UserDao userDao;
    private PartnerDao partnerDao;
    public  UserDto user;
    private PersonDao personDao;
    
    public Service(){
        this.userDao = new UserDaoImplementation();
        this.partnerDao = new PartnerDaoImplementation();  
    }
    
    
    
    
    @Override
    public void login(UserDto userDto) throws Exception{
        UserDto validateDto = userDao.findByUserName(userDto.getUserName());
        if(validateDto == null){ 
            throw new Exception ("No existe ese usuario registrado"); 
        }
        if(!userDto.getPassword().equals(validateDto. getPassword())){
            throw new Exception ("Usuario o contraseñas invalidas."); 
    }
        userDto.setRol(validateDto.getRol());
        user = validateDto;
    }
        
    @Override
    public void logout() {
            user = null;
            System.out.println("Se ha cerrado la sesion");
        } 
    //
    
    public void createUser(UserDto userDto) throws Exception{
        this.createPerson(userDto.getPersonId());
        PersonDto personDto = personDao.findByDocument(userDto.getPersonId());
        userDto.setPersonId(personDto);
        if(this.userDao.existByUserName(userDto)){
            this.personDao.deletePerson(personDto.getPersonId());
            throw new Exception ("Ya existe un usuario con ese nombre de usuario");
        }
        
        
    }
    
    public void createPerson(PersonDto personDto) throws Exception{
        if(this.personDao.existsByDocument(personDto)){
            throw new Exception ("Ya hay una perosna con ese documento en el sistema.");
        }
        this.personDao.createPerson(personDto);
    }
    
    
    @Override
    public void createPartner(UserDto userDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  

    @Override
    public void changeRol() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void createGuest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void activateGuest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void desactivateGuest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
