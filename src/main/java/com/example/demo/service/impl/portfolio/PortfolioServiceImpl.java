package com.example.demo.service.impl.portfolio;

import com.example.demo.model.portfolio.Portfolio;
import com.example.demo.repository.portfolio.PortfolioRepository;
import com.example.demo.model.ticker.Asset;
import com.example.demo.service.AssetService;
import com.example.demo.service.PortfolioService;
import com.example.demo.service.kafka.KafkaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    PortfolioRepository repository;
    @Autowired
    AssetService service;

    @Override
    public void createPortfolio(Portfolio portfolio) {
        repository.save(portfolio);
    }

    @Override
    public Portfolio getPortfolioById(String id) {
        return repository.getPortfolioById(id);
    }

    @Override
    public void addAssetToPortfolio(String portfolioId, String assetId) {
        Optional<Portfolio> optionalPortfolio = repository.findById(portfolioId);
        Optional<Asset> asset = Optional.ofNullable(service.getAssetById(assetId));
        if (optionalPortfolio.isPresent()){
            Portfolio portfolio = optionalPortfolio.get();
            portfolio.getAssets().add(asset.get());
            portfolio.setAssets_count(portfolio.getAssets().size());
            repository.save(portfolio);
        }else {
            //message about mis
        }
    }

    @Override
    public List<Portfolio> getAllPortfolios() {
        List<Portfolio> portfolios = repository.findAll();
        getRequest();
        while (KafkaListener.getMap().isEmpty()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < portfolios.size(); i++){
            List<Asset> assets = portfolios.get(i).getAssets();
            for (int j = 0; j < assets.size(); j++) {
                assets.get(j).setPrice(KafkaListener.getMap().get(assets.get(j).getTicker()));
            }
        }
        return portfolios;
    }

    private void getRequest() {
        String url = "http://localhost:8080/api/quotes/stocks/list_stocks";
        RestTemplate template = new RestTemplate();
        template.execute(url, HttpMethod.GET, null, null);
    }
}
