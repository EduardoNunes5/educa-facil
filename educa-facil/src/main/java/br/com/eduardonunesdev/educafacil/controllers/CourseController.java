package br.com.eduardonunesdev.educafacil.controllers;

import br.com.eduardonunesdev.educafacil.dtos.course.CreateCourseDTO;
import br.com.eduardonunesdev.educafacil.dtos.course.CreateCourseResponseDTO;
import br.com.eduardonunesdev.educafacil.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCourseResponseDTO createCourse(@RequestBody @Valid CreateCourseDTO dto){
        return service.createCourse(dto);
    }
}
