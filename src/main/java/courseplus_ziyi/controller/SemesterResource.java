package courseplus_ziyi.controller;


import courseplus_ziyi.Model.Semester;
import courseplus_ziyi.Service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("semester")
public class SemesterResource {
	@Autowired
	private SemesterService service;

	@GetMapping
	public List<Semester> getAll() {
		return service.getAll();
	}

	@PostMapping("")
	public void save(@RequestBody Semester sem) {
		service.save(sem);
	}

	@GetMapping("/{id}")
	public Semester getById(@PathVariable int id) {
		return service.findById(id);
	}
	

	@PostMapping("/map")
	public void mapSubject(@RequestBody Semester sem) {
		System.out.println(sem);
		service.save(sem);
	}

}
