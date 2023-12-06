package com.example.demo.service;

import com.example.demo.model.ticker.Asset;

public interface AssetService {
    void saveAsset(Asset asset);
    Asset getAssetById(String id);
}
