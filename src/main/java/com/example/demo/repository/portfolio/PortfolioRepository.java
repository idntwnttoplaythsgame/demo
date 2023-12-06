package com.example.demo.repository.portfolio;

import com.example.demo.model.portfolio.Portfolio;
import com.example.demo.model.ticker.Asset;
import jakarta.validation.Valid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PortfolioRepository extends MongoRepository<Portfolio, String> {
    //void savePortfolio(Portfolio portfolio);
    Portfolio getPortfolioById(String id);
    //Set<@Valid Asset> getAssets();

}
