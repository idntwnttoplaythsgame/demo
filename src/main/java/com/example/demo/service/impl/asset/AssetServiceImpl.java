package com.example.demo.service.impl.asset;

import com.example.demo.repository.asset.AssetRepository;
import com.example.demo.service.AssetService;
import com.example.demo.model.ticker.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetRepository repository;

    @Override
    public void saveAsset(Asset asset) {
        repository.save(asset);
    }

    @Override
    public Asset getAssetById(String id) {
        return repository.getAssetById(id);
    }
}
