package converter;

import service.dto.CarDto;
import service.dto.ClientDto;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static utils.Util.*;

public class ConverterClient {

    public static ClientDto convertClient(HttpServletRequest req) {
        String id = req.getParameter(CLIENT_ID);
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String name = req.getParameter(NAME);
        String surname = req.getParameter(SURNAME);
        String cellPhone = req.getParameter(CELL_PHONE);
        String email = req.getParameter(EMAIL);
        ClientDto clientDto = ClientDto.builder()
                .login(login)
                .password(password)
                .name(name)
                .surname(surname)
                .cellPhone(cellPhone)
                .email(email)
                .build();
        if (id != null) {
            clientDto.setId(Integer.parseInt(id));
        }
        if (login != null) {
            clientDto.setLogin(login);
        }
        if (password != null) {
            clientDto.setPassword(password);
        }
        if (name != null) {
            clientDto.setName(name);
        }
        if (surname != null) {
            clientDto.setSurname(surname);
        }
        if (cellPhone != null) {
            clientDto.setCellPhone(cellPhone);
        }
        if (email != null) {
            clientDto.setEmail(email);
        }
        return clientDto;
    }
}
