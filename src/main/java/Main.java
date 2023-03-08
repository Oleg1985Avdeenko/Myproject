import dao.*;
import dao.interfaces.DAO;
import entity.User;
import entity.cars.*;
import entity.clients.Client;
import entity.clients.ClientOrder;
import utils.HibernateUtil;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        fillTestData();

        HibernateUtil.ENTITY_MANAGER_FACTORY.close();
    }

    private static void fillTestData() {
        DAO<User> userDAO = new DaoUserImpl();
        DAO<Client> clientDAO = new DaoClientImpl();
        DAO<ClientOrder> clientOrderDAO = new DaoClientOrderImpl();
        DAO<Car> carDAO = new DaoCarImpl();
        DAO<Color> colorDAO = new DaoColorImpl();

        User user = new User();
        Client client = new Client();
        Color color = new Color();
        Engine engine = new Engine();
        Model model = new Model();
        ModelOpnion opnion = new ModelOpnion();
        Transmission transmission = new Transmission();
        Car car = new Car();
        ClientOrder order = new ClientOrder();

        user.setLogin("root");
        user.setPassword("12345");

        client.setLogin("client1");
        client.setPassword("client11");
        client.setName("Oleg1");
        client.setSurname("Avdeenko1");
        client.setCellPhone("+375445323315");
        client.setEmail("Avdeenko-oleg@gmail.com");
        client.getOrders().add(order);

        color.setColorName("black");
        color.setCarColor(car);

        engine.setType("16 gas");
        engine.setVolume(1.6);
        engine.setCarEngine(car);

        model.setModelName("Atlas");
        model.setCarModel(car);


        opnion.setSalon("Leather");
        opnion.setHeatedSeat(true);
        opnion.setCruiseControl(true);
        opnion.setSteeringWheelControl(true);
        opnion.setFogLight(true);
        opnion.setCarOption(car);

        transmission.setType("7 DCT");
        transmission.setCarTransmission(car);

        car.setPrice(new BigDecimal(75950));
        car.setAvailability(true);
        car.getSelectedColors().add(color);
        car.getSelectedEngines().add(engine);
        car.getSelectedModels().add(model);
        car.getSelectedOptions().add(opnion);
        car.getSelectedTransmissions().add(transmission);
        car.setSelectedCar(order);

        order.setClient(client);
        order.getSelectedCars().add(car);


        userDAO.save(user);
        clientDAO.save(client);
      //  colorDAO.save(color);
      //  carDAO.save(car);

    }
}
