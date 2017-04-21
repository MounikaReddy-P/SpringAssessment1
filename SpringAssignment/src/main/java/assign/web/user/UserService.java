package assign.web.user;

import assign.exception.ServiceException;

public interface UserService {
	
	public void saveUser(User user) throws ServiceException;

}
