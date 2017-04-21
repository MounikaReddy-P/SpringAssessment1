package assign.web.user;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private JdbcTemplate jdbcTemplate;

	public UserRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveUser(User user)throws DataAccessException {
		String sql = "INSERT INTO user (username, password)" + " VALUES (?, ?)";
		jdbcTemplate.update(sql, user.getUserName(), user.getPassword());
	}

}
