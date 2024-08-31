package Dao;

import Config.MYSQLConnection;
import DaoInterfacaces.PartnerDao;
import Dto.PartnerDto;
import java.sql.Date;
import java.sql.PreparedStatement;


public class PartnerDaoImplementation implements PartnerDao {
    
    
    public void createPartner(PartnerDto partnerDto) throws Exception {
        String query = "INSERT INTO PARTNER(USERID, AMOUNT, TYPE, CREATION_DATE) VALUES(?,?,?,?) ";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, partnerDto.getUserId().getId()); //Utilice el getId para convertirlo en long
        preparedStatement.setBoolean(2, partnerDto.isType());
        preparedStatement.setDouble(3, partnerDto.getAmaunt());
        preparedStatement.setDate(4, (Date) partnerDto.getCreationDate());
    }
    
    
}
