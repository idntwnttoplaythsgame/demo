package com.example.demo.service.kafka;

import com.example.demo.model.ticker.Asset;
import lombok.Getter;
import org.bson.json.JsonObject;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KafkaListener {

    @Getter
    private static Map<String, String> map = new HashMap<>();

    @org.springframework.kafka.annotation.KafkaListener(topics = "topicStock", groupId = "my-group")
    void listener(String data) throws JSONException {
        parseJson(data);
    }

    private void parseJson (String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray assetArray = jsonArray.getJSONArray(i);
            map.put(assetArray.get(0).toString(), assetArray.get(1).toString());
        }
    }
}
