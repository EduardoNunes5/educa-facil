package br.com.eduardonunesdev.educafacil.mappers;

import br.com.eduardonunesdev.educafacil.dtos.enrollment.EnrollmentInformationDTO;
import br.com.eduardonunesdev.educafacil.dtos.enrollment.UserEnrollmentDTO;
import br.com.eduardonunesdev.educafacil.model.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnrollmentMapper {

    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

    @Mapping(target = "id.usuarioId", source = "usuarioId")
    @Mapping(target = "id.codigoCurso", source = "codigoCurso")
    @Mapping(target = "dataMatricula", ignore = true)
    Enrollment convertToEnrollment(UserEnrollmentDTO dto);

    @Mapping(target = "nome", source = "curso.nome")
    @Mapping(target = "codigo", source = "curso.codigo")
    EnrollmentInformationDTO convertToInformationDTO(Enrollment enrollment);
}
