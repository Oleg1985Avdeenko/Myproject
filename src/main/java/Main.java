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

        TestData testData = new TestData();

        User user = new User();
        Client client = new Client();
        Color color = new Color();
        Engine engine = new Engine();
        Model model = new Model();
        ModelOption option = new ModelOption();
        Transmission transmission = new Transmission();
        Car car = new Car();
        ClientOrder order = new ClientOrder();

        user.setLogin("root");
        user.setPassword("12345");

//        client.setLogin("client1");
//        client.setPassword("client11");
//        client.setName("Oleg1");
//        client.setSurname("Avdeenko1");
//        client.setCellPhone("+375445323315");
//        client.setEmail("Avdeenko-oleg@gmail.com");
        client = testData.getClient(client);
        client.getOrders().add(order);

//        car.setPrice(new BigDecimal(75950));
//        car.setAvailability(true);
        car = testData.getCar(car);

//        model.setModelName("Atlas");
        model = testData.getModel(model);

        car.setCarModel(model);
        model.getSelectedModels().add(car);

//        engine.setType("16 gas");
//        engine.setVolume(1.6);
        engine = testData.getEngine(engine);

        car.setCarEngine(engine);
        engine.getSelectedEngines().add(car);

//        color.setColorName("black");
        color = testData.getColor(color);

        car.setCarColor(color);
        color.getSelectedColors().add(car);

//        transmission.setType("7 DCT");
        transmission = testData.getTransmission(transmission);

        car.setCarTransmission(transmission);
        transmission.getSelectedTransmissions().add(car);

//        option.setSalon("Leather");
//        option.setHeatedSeat(true);
//        option.setCruiseControl(true);
//        option.setSteeringWheelControl(true);
//        option.setFogLight(true);
        option = testData.getOption(option);

        car.setCarOption(option);
        option.getSelectedOptions().add(car);

        order.setClient(client);
        car.setSelectedCar(order);
        order.getSelectedCars().add(car);

        userDAO.save(user);
        clientDAO.save(client);

    }
}
