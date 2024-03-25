package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.dtos.course.CreateCourseDTO;
import br.com.eduardonunesdev.educafacil.dtos.course.CreateCourseResponseDTO;
import br.com.eduardonunesdev.educafacil.enums.UserRole;
import br.com.eduardonunesdev.educafacil.mappers.CourseMapper;
import br.com.eduardonunesdev.educafacil.model.Course;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.repositories.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CursoRepository repository;
    private final UserService userService;
    private final CourseMapper mapper = CourseMapper.INSTANCE;

    public CreateCourseResponseDTO createCourse(CreateCourseDTO dto){
        User user = userService.getUserByIdAndRole(dto.instrutorId(), UserRole.INSTRUTOR);
        Course course = mapper.convertToEntity(dto);
        course.setUser(user);
        repository.save(course);
        return mapper.convertToCourseResponse(course, user);
    }

    public boolean existsByCodigo(String codigo){
        return repository.existsById(codigo);
    }

}
