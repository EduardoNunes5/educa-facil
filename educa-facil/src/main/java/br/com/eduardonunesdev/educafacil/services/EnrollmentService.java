package br.com.eduardonunesdev.educafacil.services;

import br.com.eduardonunesdev.educafacil.dtos.enrollment.EnrollmentInformationDTO;
import br.com.eduardonunesdev.educafacil.dtos.enrollment.UserEnrollmentDTO;
import br.com.eduardonunesdev.educafacil.mappers.EnrollmentMapper;
import br.com.eduardonunesdev.educafacil.model.Course;
import br.com.eduardonunesdev.educafacil.model.Enrollment;
import br.com.eduardonunesdev.educafacil.model.User;
import br.com.eduardonunesdev.educafacil.model.key.EnrollmentPK;
import br.com.eduardonunesdev.educafacil.repositories.MatriculaRepository;
import br.com.eduardonunesdev.educafacil.services.exceptions.BadRequestException;
import br.com.eduardonunesdev.educafacil.services.exceptions.ResourceExistsException;
import br.com.eduardonunesdev.educafacil.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final MatriculaRepository repository;
    private final EnrollmentMapper mapper = EnrollmentMapper.INSTANCE;
    private final CourseService courseService;
    private final UserService userService;

    @Transactional
    public EnrollmentInformationDTO enroll(User authUser, UserEnrollmentDTO dto){
        try {
            Enrollment enrollment = mapper.convertToEnrollment(dto);
            User userReference = userService.getUserReferenceById(authUser.getId());
            Course courseReference = courseService.getCourseIfActive(dto.codigoCurso());

            enrollment.enroll(userReference, courseReference);
            repository.save(enrollment);
            return mapper.convertToInformationDTO(enrollment);
        }
        catch (EmptyResultDataAccessException exception){
            throw new ResourceNotFoundException("Usuário ou curso não encontrados no sistema!");
        }
        catch (DuplicateKeyException dke) {
            throw new ResourceExistsException("Usuário já matriculado ao curso!");
        }

    }

    public boolean existsById(Long userId, String courseCode) {
        return repository.existsById(new EnrollmentPK(userId, courseCode));
    }

    private void doEnroll(Enrollment enrollment, User user, Course course){

    }

}
