package tn.tp.dev.Course_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<Course> getAllCourses() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Course> getCourseById(@PathVariable String id) {
        return repository.findById(id);
    }
}