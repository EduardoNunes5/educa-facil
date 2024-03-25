package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.dtos.course.CourseResponseDTO;
import br.com.eduardonunesdev.educafacil.dtos.course.CreateCourseDTO;
import br.com.eduardonunesdev.educafacil.enums.UserRole;
import br.com.eduardonunesdev.educafacil.mappers.CourseMapper;
import br.com.eduardonunesdev.educafacil.model.Course;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.repositories.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CursoRepository repository;
    private final UserService userService;
    private final CourseMapper mapper = CourseMapper.INSTANCE;

    public CourseResponseDTO createCourse(CreateCourseDTO dto) {
        User user = userService.getUserByIdAndRole(dto.instrutorId(), UserRole.INSTRUTOR);
        Course course = mapper.convertToEntity(dto, user);
        course.setUser(user);
        repository.save(course);
        return mapper.convertToCourseResponse(course);
    }

    public boolean existsByCodigo(String codigo) {
        return repository.existsById(codigo);
    }

    public void deactivateCourse(String codigo) {
        repository.deactivateCourse(codigo);
    }

    public Page<CourseResponseDTO> findAllPaginated(Pageable pageable, Boolean status) {
        return repository.findByStatus(pageable, status)
                .map(mapper::convertToCourseResponse);
    }
}
