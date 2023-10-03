package com.maveric.api.serviceimpl;


	import java.util.List;

	import java.util.Optional;

	 

	import org.springframework.beans.factory.annotation.Autowired;

	import org.springframework.stereotype.Service;

	import com.maveric.api.service.Userservice;
	import com.maveric.api.Model.User;
	import com.maveric.api.Repository.Userrepo;
	
	
 

	@Service

	
		public class Userserviceimpl implements Userservice{
	 

	    @Autowired

	    private Userrepo userrepo;

	 

	    @Override

	    public User createUser(User user) {

	        return userrepo.save(user);

	    }

	 

	    @Override
	    public User getUserById(Long userId) {

	        Optional<User> optionaluser = userrepo.findById(userId);

	        return optionaluser.get();

	    }
	 

	    @Override

	    public List<User> getAllUsers() {

	        return userrepo.findAll();

	    }

	 

	    @Override

	    public User updateUser(User user) {

	        User existingUser = userrepo.findById(user.getId()).get();

	        existingUser.setFirstName(user.getFirstName());

	        existingUser.setLastName(user.getLastName());

	        existingUser.setEmail(user.getEmail());

	        User updatedUser = userrepo.save(existingUser);

	        return updatedUser;

	    }

	 

	    @Override

	    public void deleteUser(Long userId) {

	    	userrepo.deleteById(userId);

	    }

	}

