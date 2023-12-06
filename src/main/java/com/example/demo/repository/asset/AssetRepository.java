package com.example.demo.repository.asset;

import com.example.demo.model.ticker.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends MongoRepository<Asset, String> {
    //void saveAsset(Asset asset);
    Asset getAssetById(String id);
}
