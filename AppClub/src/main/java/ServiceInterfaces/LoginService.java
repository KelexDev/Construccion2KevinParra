
package ServiceInterfaces;

import Dto.UserDto;


public interface LoginService {
    public void login(UserDto userDto) throws Exception;
    public void logout();
}
    
