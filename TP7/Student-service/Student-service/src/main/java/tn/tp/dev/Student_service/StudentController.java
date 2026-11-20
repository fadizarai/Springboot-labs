package tn.tp.dev.Student_service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final WebClient webClient;

    private List<Student> students = List.of(
            new Student("1", "Amine", "1"),
            new Student("2", "Salma", "2"),
            new Student("3", "Yassine", "3")
    );

    public StudentController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping
    public Flux<StudentResponse> getAllStudents() {
        return Flux.fromIterable(students)
                .flatMap(s -> webClient.get()
                        .uri("/courses/" + s.getCourseId())
                        .retrieve()
                        .bodyToMono(Course.class)
                        .map(c -> new StudentResponse(
                                s.getId(),
                                s.getName(),
                                c
                        ))
                );
    }
}