package service.mapping;

import entity.User;
import service.dto.UserDto;

public class MappingUser implements MappingService<User, UserDto> {
    @Override
    public User convertToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        return user;
    }

    @Override
    public UserDto convertToDTO(User entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setLogin(entity.getLogin());
        userDto.setPassword(entity.getPassword());
        return null;
    }
}
