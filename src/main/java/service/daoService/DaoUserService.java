package service.daoService;

import dao.DaoUserImpl;
import dao.interfaces.DAO;
import entity.User;
import service.Service;
import service.dto.UserDto;
import service.mapping.MappingService;
import service.mapping.MappingUser;

import java.util.List;
import java.util.stream.Collectors;

public class DaoUserService implements Service<UserDto> {

    private final DAO<User> userDAO = new DaoUserImpl();

    private final MappingService<User, UserDto> mappingUser = new MappingUser();


    @Override
    public UserDto save(UserDto userDto) {
        User user = mappingUser.convertToEntity(userDto);
        userDAO.save(user);
        userDto.setId(user.getId());
        return mappingUser.convertToDTO(user);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = mappingUser.convertToEntity(userDto);
        userDAO.update(user);
        return mappingUser.convertToDTO(user);
    }

    @Override
    public UserDto findById(UserDto userDto) {
        User user = mappingUser.convertToEntity(userDto);
       user = userDAO.findById(user);
        return mappingUser.convertToDTO(user);
    }

    @Override
    public void delete(UserDto userDto) {
        userDAO.findById(mappingUser.convertToEntity(userDto));
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userDAO.findAll(User.builder().build());
        return users.stream()
                .map(mappingUser::convertToDTO)
                .collect(Collectors.toList());
    }
}
