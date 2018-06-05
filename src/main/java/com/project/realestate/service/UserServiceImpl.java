package com.project.realestate.service;

import com.project.realestate.entity.Contact;
import com.project.realestate.entity.User;
import com.project.realestate.exception.ConfirmationException;
import com.project.realestate.exception.TokenInvalidException;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.exception.UsernameExistException;
import com.project.realestate.model.UserUpdate;
import com.project.realestate.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ContactService contactService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public User getUserById(String id) throws UserNotFoundException {
        User user = usersRepository.findUserById(id);
        if( user== null) {
            throw new UserNotFoundException("User does not exist");
        }
        return user;
    }

    @Override
    public User getUSerByEmail(String email) throws UserNotFoundException {
        User user = usersRepository.findUserByUsername(email);
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public void updateFirstToken(User updateUser) throws UserNotFoundException {
        User user = usersRepository.findUserByUsername(updateUser.getUsername());
        if(user == null ) {
            throw new UserNotFoundException("User not found");
        }
        usersRepository.save(user);

    }

    @Override
    public void register(User user) throws UsernameExistException {
        User userCheck = usersRepository.findUserByUsername(user.getUsername());
        if(userCheck != null)
            throw new UsernameExistException("Username is exist");
        createUser(user);
        emailService.sendMailConfirmation(user);
    }

    private void createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setActive(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().toString());
        contact.setAddress("");
        contact.setContactName("");
        contact.setEmail("");
        contact.setPhone("");
        contact.setMainContact(true);
        contact.setUserByUserId(user);
        contactService.saveContact(contact);

    }

    @Override
    public void confirmRegistration(String token) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException {
        String userId = jwtTokenService.verifyToken(token);
        User user = getUserById(userId);
        if(user == null) {
            throw new TokenInvalidException("Token invalid");
        }
        user.setActive(true);
        user.setToken(token);
        updateFirstToken(user);
    }

    @Override
    public void saveUser(User updateUser) {
        User user = usersRepository.findUserByUsername(updateUser.getUsername());
        updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        if(user == null)
            throw new UsernameNotFoundException("Username does not exist");

        usersRepository.save(updateUser);
    }

    @Override
    public void resetPassword(String token) throws TokenInvalidException, UsernameExistException, UserNotFoundException, ConfirmationException {
        String userId = jwtTokenService.verifyToken(token);
        User user = getUserById(userId);
        usersRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public void updateUser(UserUpdate userUpdate) {
        User user = usersRepository.findUserById(userUpdate.getId());
//        user.setUsername(userUpdate.getUsername());
//        usersRepository.save(user);
        Contact contact = contactService.getContactByUserByUserId(user);
        contact.setPhone(userUpdate.getPhone());
//        contact.setEmail(userUpdate.getEmail());
        contact.setAddress(userUpdate.getAddress());
        contactService.saveContact(contact);
    }

}
