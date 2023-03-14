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

        car.setId(1);
        car.setPrice(new BigDecimal(75950));
        car.setAvailability(true);

        color.setId(45);
        color.setColorName("black");

        engine.setId(46);
        engine.setType("16 gas");
        engine.setVolume(1.6);

        model.setId(25);
        model.setModelName("Atlas");

        opnion.setId(26);
        opnion.setSalon("Leather");
        opnion.setHeatedSeat(true);
        opnion.setCruiseControl(true);
        opnion.setSteeringWheelControl(true);
        opnion.setFogLight(true);

        transmission.setId(42);
        transmission.setType("7 DCT");

        car.setCarColor(color);
        car.setCarEngine(engine);
        car.setCarModel(model);
        car.setCarOption(opnion);
        car.setCarTransmission(transmission);
        car.setSelectedCar(order);

        color.getSelectedColors().add(car);

        engine.getSelectedEngines().add(car);

        model.getSelectedModels().add(car);

        opnion.getSelectedOptions().add(car);


        transmission.getSelectedTransmissions().add(car);


        order.setClient(client);
        order.getSelectedCars().add(car);


        userDAO.save(user);
        clientDAO.save(client);
      //  colorDAO.save(color);
       // carDAO.save(car);

    }
}
