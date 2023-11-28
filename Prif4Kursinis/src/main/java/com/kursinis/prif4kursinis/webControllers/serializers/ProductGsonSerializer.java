package com.kursinis.prif4kursinis.webControllers.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.kursinis.prif4kursinis.model.Product;

import java.lang.reflect.Type;

public class ProductGsonSerializer implements JsonSerializer<Product> {
    @Override
    public JsonElement serialize(Product product, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", product.getId());
        jsonObject.addProperty("title", product.getTitle());
        jsonObject.addProperty("description", product.getDescription());
        jsonObject.addProperty("manufacturer", product.getManufacturer());
        jsonObject.addProperty("warehouse", product.getWarehouse().getTitle());

        return jsonObject;
    }
}
