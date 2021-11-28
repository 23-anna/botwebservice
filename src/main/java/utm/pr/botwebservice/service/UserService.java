package utm.pr.botwebservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import utm.pr.botwebservice.entity.User;
import utm.pr.botwebservice.repository.IUserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

//    public List<User> getAll() {
//        return userRepository.findAll(Sort.by(Sort.Order.asc("date"),
//                Sort.Order.desc("priorityId")));
//    }

    public User save(User task) {
        return userRepository.save(task);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
