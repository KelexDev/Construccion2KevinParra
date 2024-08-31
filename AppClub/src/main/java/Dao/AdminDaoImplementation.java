package Dao;

import Config.MYSQLConnection;
import Dto.UserDto;
import Helpers.Helper;
import Model.User;
import ServiceInterfaces.AdminService;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDaoImplementation implements AdminService {

    @Override
    public void createPartner(UserDto userDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void createUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
	String query = "INSERT INTO USER(USERNAME,PASSWORD,PERSONID,ROLE) VALUES (?,?,?,?) ";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, userDto.getUserName());
            preparedStatement.setString(2, userDto.getPassword());
            preparedStatement.setLong(3,userDto.getPersonId().getId());
            preparedStatement.setString(4, userDto.getRol());
            preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
            throw new Exception("Error, no se pudo crear el usuario.");
        }
    }
    
    
    
}


