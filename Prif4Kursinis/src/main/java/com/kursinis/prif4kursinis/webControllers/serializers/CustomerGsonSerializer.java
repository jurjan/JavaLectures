package com.kursinis.prif4kursinis.webControllers.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.kursinis.prif4kursinis.model.Customer;

import java.lang.reflect.Type;

public class CustomerGsonSerializer implements JsonSerializer<Customer> {
    @Override
    public JsonElement serialize(Customer customer, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", customer.getId());
        jsonObject.addProperty("name", customer.getName());
        jsonObject.addProperty("surname", customer.getSurname());
        jsonObject.addProperty("login", customer.getLogin());
        jsonObject.addProperty("address", customer.getAddress());
        jsonObject.addProperty("cardNo", customer.getCardNo());


        return jsonObject;
    }
}
