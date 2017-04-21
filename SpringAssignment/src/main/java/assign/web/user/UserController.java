package assign.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import assign.exception.ServiceException;

@Controller
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveUser(@RequestBody User user)
			throws ServiceException {
		HttpHeaders headers = new HttpHeaders();
		if (user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
			throw new ServiceException("User information is not valid.");
		}
		userService.saveUser(user);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}
}