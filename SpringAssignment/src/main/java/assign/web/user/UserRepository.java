package assign.web.user;

import org.springframework.dao.DataAccessException;

public interface UserRepository {
	
	public void saveUser(User user)throws DataAccessException;
	
}
