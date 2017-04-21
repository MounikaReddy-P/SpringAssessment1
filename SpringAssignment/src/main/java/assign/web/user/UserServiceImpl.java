package assign.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assign.exception.ServiceException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public void saveUser(User user) throws ServiceException{
		userRepository.saveUser(user);
	}
}
