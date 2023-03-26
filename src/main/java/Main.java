import dao.DAO;
import dao.impl.*;
import entity.User;
import entity.cars.*;
import entity.clients.Client;
import entity.clients.ClientOrder;
import utils.HibernateUtil;

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
        Client client1 = new Client();
        Client client2 = new Client();
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        Model model = new Model();
        Model model1 = new Model();
        Model model2 = new Model();
        Color color = new Color();
        Color color1 = new Color();
        Color color2 = new Color();
        Color color3 = new Color();
        Engine engine = new Engine();
        Engine engine1 = new Engine();
        Engine engine2 = new Engine();
        Transmission transmission = new Transmission();
        Transmission transmission1 = new Transmission();
        Transmission transmission2 = new Transmission();
        ModelOption option = new ModelOption();
        ModelOption option1 = new ModelOption();
        ModelOption option2 = new ModelOption();
        ClientOrder order = new ClientOrder();
        ClientOrder order1 = new ClientOrder();
        ClientOrder order2 = new ClientOrder();

        user.setLogin("root");
        user.setPassword("12345");

        client = testData.getClient(client);
        client.getOrders().add(order);


        car = testData.getCar(car);

        model = testData.getModel(model);

        car.setCarModel(model);
        model.getSelectedModels().add(car);

        engine = testData.getEngine(engine);

        car.setCarEngine(engine);
        engine.getSelectedEngines().add(car);

        color = testData.getColor(color);

        car.setCarColor(color);
        color.getSelectedColors().add(car);

        transmission = testData.getTransmission(transmission);

        car.setCarTransmission(transmission);
        transmission.getSelectedTransmissions().add(car);

        option = testData.getOption(option);

        car.setCarOption(option);
        option.getSelectedOptions().add(car);

        order.setClient(client);
        car.setSelectedCar(order);
        order.getSelectedCars().add(car);


        client1 = testData.getClient1(client1);
        client2 = testData.getClient2(client2);
        car1 = testData.getCar1(car1);
        car2 = testData.getCar2(car2);
        model1 = testData.getModel1(model1);
        model2 = testData.getModel2(model2);
        car1.setCarModel(model1);
        model1.getSelectedModels().add(car1);
        car2.setCarModel(model2);
        model2.getSelectedModels().add(car2);
        engine1 = testData.getEngine1(engine1);
        engine2 = testData.getEngine(engine2);
        car1.setCarEngine(engine1);
        engine1.getSelectedEngines().add(car1);
        car2.setCarEngine(engine2);
        engine2.getSelectedEngines().add(car2);
        color1 = testData.getColor1(color1);
        color2 = testData.getColor2(color2);
        color3 = testData.getColor3(color3);
        car1.setCarColor(color3);
        color3.getSelectedColors().add(car1);
        car2.setCarColor(color1);
        color1.getSelectedColors().add(car2);
        transmission1 = testData.getTransmission1(transmission1);
        transmission2 = testData.getTransmission(transmission2);
        car1.setCarTransmission(transmission1);
        transmission1.getSelectedTransmissions().add(car1);
        car2.setCarTransmission(transmission2);
        transmission2.getSelectedTransmissions().add(car2);
        option1 = testData.getOption1(option1);
        option2 = testData.getOption(option2);
        car1.setCarOption(option2);
        option2.getSelectedOptions().add(car1);
        car2.setCarOption(option1);
        option1.getSelectedOptions().add(car2);
        order1.setClient(client1);
        car1.setSelectedCar(order1);
        order1.getSelectedCars().add(car1);
        order2.setClient(client2);
        car2.setSelectedCar(order2);
        order2.getSelectedCars().add(car2);

        userDAO.save(user);
        clientDAO.save(client);
//        clientDAO.save(client1);
//        clientDAO.save(client2);
        carDAO.save(car1);
        carDAO.save(car2);


    }
}
