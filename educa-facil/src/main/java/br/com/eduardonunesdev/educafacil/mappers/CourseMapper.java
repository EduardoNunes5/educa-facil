package br.com.eduardonunesdev.educafacil.mappers;

import br.com.eduardonunesdev.educafacil.dtos.course.CreateCourseDTO;
import br.com.eduardonunesdev.educafacil.dtos.course.CourseResponseDTO;
import br.com.eduardonunesdev.educafacil.model.Course;
import br.com.eduardonunesdev.educafacil.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target = "nome", source = "dto.nome")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "createdAt", ignore = true)
    Course convertToEntity(CreateCourseDTO dto, User user);

    @Mapping(target = "instrutor.nome", source = "user.nome")
    @Mapping(target = "instrutor.email", source = "user.email")
    @Mapping(target = "instrutor.role", source = "user.role")
    @Mapping(target = "nome", source = "course.nome")
    CourseResponseDTO convertToCourseResponse(Course course);

}
