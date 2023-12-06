package com.example.demo.service;

import com.example.demo.model.portfolio.Portfolio;
import com.example.demo.model.ticker.Asset;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Set;

public interface PortfolioService {
    void createPortfolio(Portfolio portfolio);
    Portfolio getPortfolioById(String id);
    void addAssetToPortfolio(String portfolioId, String assetId);
    List<Portfolio> getAllPortfolios();
}
