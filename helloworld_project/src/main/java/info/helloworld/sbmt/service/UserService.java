package info.helloworld.sbmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.helloworld.sbmt.entity.User;
import info.helloworld.sbmt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRpository;

	public List<User> findAll() {
		return userRpository.findAll();
	}

//	public User findOne(Long userId) {
//		return userRpository.findOne(userId);
//	}

	public User save(User user) {
		return userRpository.save(user);
	}

//	public void delete(Long userId) {
//		userRpository.delete(userId);
//	}

}
