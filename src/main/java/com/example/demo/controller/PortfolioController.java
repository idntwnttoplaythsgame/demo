package com.example.demo.controller;

import com.example.demo.model.portfolio.Portfolio;
import com.example.demo.model.ticker.Asset;
import com.example.demo.service.PortfolioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/portfolio")
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;

    @PostMapping
    public void addPortfolio(@RequestParam String name) {
        List<Asset> assets = new ArrayList<>();
        portfolioService.createPortfolio(new Portfolio(name, 0, assets));
    }


    @GetMapping
    public Portfolio getPortfolioById(@RequestParam String id) {
        return portfolioService.getPortfolioById(id);
    }

    @GetMapping
    @RequestMapping(value = "/portfolios")
    public List<Portfolio> getPortfolios(){
        return portfolioService.getAllPortfolios();
    }

    @PutMapping
    public void addAssetToPortfolio(@RequestParam String id, @RequestParam String assetId) {
        portfolioService.addAssetToPortfolio(id, assetId);
    }
}
