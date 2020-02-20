package org.azamat.service.impl;

import org.azamat.SpringBootStarter;
import org.azamat.model.Order;
import org.azamat.model.securitymodel.Role;
import org.azamat.model.securitymodel.Status;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.OrderRepository;
import org.azamat.repository.RoleRepository;
import org.azamat.repository.UserRepository;
import org.azamat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final OrderRepository orderRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.orderRepository = orderRepository;
    }

    @Autowired
    private HttpSession session;

    @Override
    public User registerUser(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER").orElse(new Role());
        List<Role> userRoles = new ArrayList<>();
        Order order = new Order();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setOrder(order);
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setCreated(Calendar.getInstance());
        order.setUser(user);
        User registeredUser = userRepository.save(user);

        return registeredUser;
    }

    @Override
    public Collection<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("getAll method - {} users found", result.size());

        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username).orElse(null);
        log.info("findByUsername method - user: {} found by username: {}", result, username);
        log.debug("findByUsername method - user: {} found by username: {}", result, username);

        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(new User());
        log.info("findById method - user: {} found by id: {}", result, id);
        log.debug("findById method - user: {} found by id: {}", result, id);

        return result;
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
        log.info("removeUser method - user with id: {} successfully deleted");
    }

    @Override
    public void update(User user) {
        User userSession = (User)session.getAttribute("connectedUser");
        User userFromDB = userRepository.findById(userSession.getId()).orElse(new User());
        userFromDB.setFirstName(user.getFirstName());
        userFromDB.setLastName(user.getLastName());
        userFromDB.setPatronymic(user.getPatronymic());
        userFromDB.setEmail(user.getEmail());
        userFromDB.setAddress(user.getAddress());
        userFromDB.setUpdated(Calendar.getInstance());
        userRepository.save(userFromDB);
    }
}
