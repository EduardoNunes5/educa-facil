package br.com.eduardonunesdev.educafacil.controllers;

import br.com.eduardonunesdev.educafacil.dtos.course.CreateCourseDTO;
import br.com.eduardonunesdev.educafacil.dtos.course.CourseResponseDTO;
import br.com.eduardonunesdev.educafacil.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponseDTO createCourse(@RequestBody @Valid CreateCourseDTO dto){
        return service.createCourse(dto);
    }

    @PatchMapping("/{codigo}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateCourse(@PathVariable String codigo){
        service.deactivateCourse(codigo);
    }

    @GetMapping
    public Page<CourseResponseDTO> getPaginated(@PageableDefault Pageable pageable, @RequestParam(defaultValue = "true") Boolean status){
        return service.findAllPaginated(pageable, status);
    }
}
