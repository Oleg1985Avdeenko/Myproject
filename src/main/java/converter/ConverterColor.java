package converter;

import service.dto.ColorDto;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.*;

public class ConverterColor {

    public static ColorDto convertColor(HttpServletRequest req) {
        String id = req.getParameter(COLOR_ID);
        String color = req.getParameter(COLOR_NAME);
        ColorDto colorDto = ColorDto.builder()
                .colorName(color)
                .build();
        if (id != null) {
            colorDto.setId(Integer.parseInt(id));
        }
        if (color != null) {
            colorDto.setColorName(color);
        }
        return colorDto;
    }
}
