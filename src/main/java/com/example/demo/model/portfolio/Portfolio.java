package com.example.demo.model.portfolio;

import com.example.demo.model.ticker.Asset;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Set;

@Data
@Document("portfolios")
public class Portfolio {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("assets_count")
    private int assets_count;

    @Field("assets")
    private List<@Valid Asset> assets;

    public Portfolio(String name, int assets_count, List<@Valid Asset> assets) {
        this.name = name;
        this.assets_count = assets_count;
        this.assets = assets;
    }
}
