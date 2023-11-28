package com.kursinis.prif4kursinis.webControllers.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.kursinis.prif4kursinis.model.Manager;

import java.lang.reflect.Type;

public class ManagerGsonSerializer implements JsonSerializer<Manager> {
    @Override
    public JsonElement serialize(Manager manager, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", manager.getId());
        jsonObject.addProperty("name", manager.getName());
        jsonObject.addProperty("medical", manager.getMedCertificate());
        jsonObject.addProperty("surname", manager.getSurname());

        return jsonObject;
    }
}
