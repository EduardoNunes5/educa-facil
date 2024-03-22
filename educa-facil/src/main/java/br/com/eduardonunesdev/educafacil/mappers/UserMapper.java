package br.com.eduardonunesdev.educafacil.mappers;

import br.com.eduardonunesdev.educafacil.dtos.CreateUserDTO;
import br.com.eduardonunesdev.educafacil.dtos.CreateUserResponseDTO;
import br.com.eduardonunesdev.educafacil.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    CreateUserResponseDTO convertToResponse(User user);

    User convertToEntity(CreateUserDTO dto);
}
