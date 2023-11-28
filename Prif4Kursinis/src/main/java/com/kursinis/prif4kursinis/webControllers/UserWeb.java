package com.kursinis.prif4kursinis.webControllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kursinis.prif4kursinis.hibernateControllers.CustomHib;
import com.kursinis.prif4kursinis.model.Customer;
import com.kursinis.prif4kursinis.model.Manager;
import com.kursinis.prif4kursinis.model.User;
import com.kursinis.prif4kursinis.webControllers.serializers.CustomerGsonSerializer;
import com.kursinis.prif4kursinis.webControllers.serializers.LocalDateGsonSerializer;
import com.kursinis.prif4kursinis.webControllers.serializers.ManagerGsonSerializer;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Properties;

@Controller
public class UserWeb {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("coursework-shop");
    CustomHib customHib = new CustomHib(entityManagerFactory);

    //Useris pagal id, GET su PathVariable
    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getUserById(@PathVariable(name = "id") int id){

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class, new LocalDateGsonSerializer());
        builder.registerTypeAdapter(Manager.class, new ManagerGsonSerializer());
        builder.registerTypeAdapter(Customer.class, new CustomerGsonSerializer());
        //builder.registerTypeAdapter(User.class, new UserGsonSerializer());
        Gson gson = builder.create();




        User user = customHib.getEntityById(User.class, id);

        return user != null ? gson.toJson(user) : "";


        //return customHib.getEntityById(User.class, id).toString();
    }

    //Useris pagal login ir psw su RequestParam (labai blogai, bet tik kaip pvz bus)
//    @RequestMapping(value = "getUserByCredentials", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public String getUserByCredentials(@RequestParam(name = "login") String login, @RequestParam(name = "psw") String password){
//        return customHib.getUserByCredentials(login, password) == null ? "No such user" : customHib.getUserByCredentials(login, password).toString();
//    }

    @RequestMapping(value = "/user/getUserByCredentials", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getUserByCredentials(@RequestBody String data){

        System.out.println(data);
        Gson parser = new Gson();
        Properties properties = parser.fromJson(data, Properties.class);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class, new LocalDateGsonSerializer());
        builder.registerTypeAdapter(Manager.class, new ManagerGsonSerializer());
        builder.registerTypeAdapter(Customer.class, new CustomerGsonSerializer());
        Gson gson = builder.create();

        User user = customHib.getUserByCredentials(properties.getProperty("login"), properties.getProperty("psw"));

        return user != null ? gson.toJson(user) : "";
  }


    @RequestMapping(value = "/user/updateUser", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String updateUserFromAndroid(@RequestBody String data){

        Gson parser = new Gson();
        Properties properties = parser.fromJson(data, Properties.class);

        var id = Integer.parseInt(properties.getProperty("id"));
        var name = properties.getProperty("name");
        var surname = properties.getProperty("surname");
        var password = properties.getProperty("password");


        User user = customHib.getEntityById(User.class, id);

        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);

        customHib.update(user);

        user = customHib.getEntityById(User.class, id);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class, new LocalDateGsonSerializer());
        builder.registerTypeAdapter(Manager.class, new ManagerGsonSerializer());
        builder.registerTypeAdapter(Customer.class, new CustomerGsonSerializer());
        Gson gson = builder.create();

        return user != null ? gson.toJson(user) : "";
    }

}
