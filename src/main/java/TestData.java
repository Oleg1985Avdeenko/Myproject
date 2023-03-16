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

    public Client getClient1(Client client){
        client.setLogin("client1");
        client.setPassword("56789");
        client.setName("Max");
        client.setSurname("Petrukevich");
        client.setCellPhone("+375445687258");
        client.setEmail("Petrukevich@gmail.com");
        return client;
    }
    public Client getClient2(Client client){
        client.setLogin("client2");
        client.setPassword("98765");
        client.setName("Vitali");
        client.setSurname("Barushko");
        client.setCellPhone("+37544468825");
        client.setEmail("Barushko@gmail.com");
        return client;
    }

    public Car getCar(Car car){
        car.setPrice(new BigDecimal(75950));
        car.setAvailability(true);
      return car;
    }
        public Car getCar1(Car car){
        car.setPrice(new BigDecimal(65875));
        car.setAvailability(true);
      return car;
    }
            public Car getCar2(Car car){
        car.setPrice(new BigDecimal(54200));
        car.setAvailability(true);
      return car;
    }


    public Model getModel(Model model){
        model.setModelName("Atlas");
        return model;
    }
    public Model getModel1(Model model){
        model.setModelName("CoolRay");
        return model;
    }
    public Model getModel2(Model model){
        model.setModelName("Emgrand");
        return model;
    }

    public Engine getEngine(Engine engine){
        engine.setType("16 tdi");
        engine.setVolume(1.6);
        return engine;
    }
    public Engine getEngine1(Engine engine){
        engine.setType("1.5 L");
        engine.setVolume(1.5);
        return engine;
    }

    public Color getColor(Color color){
        color.setColorName("black");
        return color;
    }
    public Color getColor1(Color color){
        color.setColorName("red");
        return color;
    }
    public Color getColor2(Color color){
        color.setColorName("green");
        return color;
    }
    public Color getColor3(Color color){
        color.setColorName("white");
        return color;
    }

    public Transmission getTransmission(Transmission transmission){
        transmission.setType("7 DCT");
        return transmission;
    }
    public Transmission getTransmission1(Transmission transmission){
        transmission.setType("CVT");
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
    public ModelOption getOption1(ModelOption option) {
        option.setSalon("Leather");
        option.setHeatedSeat(true);
        option.setCruiseControl(true);
        option.setSteeringWheelControl(true);
        option.setFogLight(false);
        return option;
    }
}
