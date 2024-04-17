package courseplus_ziyi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentResource {
	@RequestMapping("")
	public String index() {
		return "Student Resource";
	}
}
