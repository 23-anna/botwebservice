package utm.pr.botwebservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utm.pr.botwebservice.entity.User;
import utm.pr.botwebservice.repository.IUserRepository;
import utm.pr.botwebservice.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private IUserRepository userRepository;

//    @GetMapping("/")
//    public String getAll(Model model) {
//        List<User> userList = userService.getAll();
//        model.addAttribute("taskList", userList);
//        model.addAttribute("taskSize", userList.size());
//        return "index";
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String deleteTask(@PathVariable int id) {
//        userService.delete(id);
//        return "redirect:/";
//    }
//
//    @PostMapping("/add")
//    public String addTask(@ModelAttribute User task) {
//        userService.save(task);
//        return "redirect:/";
//    }

    @GetMapping("/login")
    public String doLogin() {
        return "login";
    }

    @GetMapping("/signup")
    public String doSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByLogin(user.getLogin());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "signup";
        }

        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
