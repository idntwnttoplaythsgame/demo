package com.example.demo.model.ticker;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document("assets")
public class Asset {
    @Id
    private String id;
    @Field("ticker")
    private String ticker;
    private String price;

    public Asset(String id, String ticker, String price) {
        this.id = id;
        this.ticker = ticker;
        this.price = price;
    }

    public Asset(String ticker) {
        this.ticker = ticker;
    }
}
