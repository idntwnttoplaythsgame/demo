package com.example.demo.controller;

import com.example.demo.model.ticker.Asset;
import com.example.demo.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public void addAsset(@RequestParam String ticker) {
        assetService.saveAsset(new Asset(ticker));
    }

    @GetMapping
    public Asset getAsset(@RequestParam String id) {
        return assetService.getAssetById(id);
    }
}




