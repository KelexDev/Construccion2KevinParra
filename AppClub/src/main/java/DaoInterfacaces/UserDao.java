
package DaoInterfacaces;

import Dto.UserDto;


public interface UserDao {
    
    public UserDto findByUserName(String username) throws Exception;
    
    public boolean existByUserName(UserDto username) throws Exception;
    
    public void createUser(UserDto userDto) throws Exception;
}
