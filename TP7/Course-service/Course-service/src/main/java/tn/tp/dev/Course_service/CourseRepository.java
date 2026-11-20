package tn.tp.dev.Course_service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CourseRepository {

    private final Map<String, tn.tp.dev.Course_service.Course> courses = new HashMap<>();

    public CourseRepository() {
        courses.put("1", new Course("1", "WebFlux", 30));
        courses.put("2", new Course("2", "Microservices", 40));
        courses.put("3", new Course("3", "Spring Cloud", 35));
    }

    public Flux<Course> findAll() {
        return Flux.fromIterable(courses.values());
    }

    public Mono<Course> findById(String id) {
        return Mono.justOrEmpty(courses.get(id));
    }
}