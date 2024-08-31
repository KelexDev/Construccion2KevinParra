package Dao;

import Config.MYSQLConnection;
import DaoInterfacaces.UserDao;
import Dto.UserDto;
import Helpers.Helper;
import Model.Person;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImplementation implements UserDao {

    public UserDto findByUserName(UserDto userDto) throws Exception {
        String query = "SELECT ID,USERNAME,PASSWORD,ROLE,PERSONID FROM USER WHERE USERNAME = ?";
	PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
	preparedStatement.setString(1, userDto.getUserName());
	ResultSet resultSet = preparedStatement.executeQuery();
	if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setUserName(resultSet.getString("USERNAME"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setRol(resultSet.getString("ROL"));
            Person person = new Person();
            person.setDocument(resultSet.getLong("PERSONID"));
            user.setPersonId(person);
            resultSet.close();
            preparedStatement.close();
            return Helper.parse(user);
        }	
        resultSet.close();
        preparedStatement.close();
        return null;
	}

	
    public boolean existByUserName(UserDto userDto) throws Exception {
        String query = "SELECT 1 FROM USER WHERE USERNAME = ?"; //Estamos hablando de consultas a bases de dartos
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, userDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
	boolean exists = resulSet.next();
	resulSet.close();
	preparedStatement.close();
	return exists;
	}
    
    @Override
    public void createUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
	String query = "INSERT INTO USER(USERNAME,PASSWORD,PERSONID,ROLE) VALUES (?,?,?,?) ";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
	preparedStatement.setString(1, user.getUserName());
	preparedStatement.setString(2, user.getPassword());
	preparedStatement.setLong(3,user.getPersonId().getId());
	preparedStatement.setString(4, user.getRol());
	preparedStatement.execute();
	preparedStatement.close();		
    }

    @Override
    public UserDto findByUserName(String username) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}


