package br.com.mvc.mudi.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.mvc.mudi.dto.UserDto;
import br.com.mvc.mudi.model.User;
import br.com.mvc.mudi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;


@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<UserDto> users = userService.getAllUsers();
		model.addAttribute("title", "Users");
		model.addAttribute("users", users);
		return "users";
	}
	
	@GetMapping("/users/{id}")
	public UserDto getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

    @PostMapping("/users")
	public String saveUsers(Model model, Authentication authentication, User newUser) {
        if (authentication != null) {
			UserDto userDto = userService.getLoginUser();
			model.addAttribute("user", userDto);
		}
		//model.addAttribute("title", "Home");
        userService.createUser(newUser);
		return "users";
	}

}