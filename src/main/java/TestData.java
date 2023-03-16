import entity.cars.*;
import entity.clients.Client;

import java.math.BigDecimal;

public class TestData {

    public Client getClient(Client client){
        client.setLogin("client");
        client.setPassword("54321");
        client.setName("Oleg");
        client.setSurname("Avdeenko");
        client.setCellPhone("+375445323315");
        client.setEmail("Avdeenko-oleg@gmail.com");
        return client;
    }

    public Car getCar(Car car){
        car.setPrice(new BigDecimal(75950));
        car.setAvailability(true);
      return car;
    }

    public Model getModel(Model model){
        model.setModelName("Atlas");
        return model;
    }

    public Engine getEngine(Engine engine){
        engine.setType("16 gas");
        engine.setVolume(1.6);
        return engine;
    }

    public Color getColor(Color color){
        color.setColorName("black");
        return color;
    }

    public Transmission getTransmission(Transmission transmission){
        transmission.setType("7 DCT");
        return transmission;
    }

    public ModelOption getOption(ModelOption option) {
        option.setSalon("Leather");
        option.setHeatedSeat(true);
        option.setCruiseControl(true);
        option.setSteeringWheelControl(true);
        option.setFogLight(true);
        return option;
    }
}
