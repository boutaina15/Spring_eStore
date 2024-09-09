package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.ConfigurationRepository;
import com.example.estore.EstoreApp.entities.Configuration;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConfigurationServiceImpl {

    private final ConfigurationRepository configurationRepository;

    public List<Configuration> getConfigurations(){
        return configurationRepository.findAll();
    }

    public Configuration addConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    public void deleteConfiguration(Long configurationId) {
        boolean exists = configurationRepository.existsById(configurationId);
        if (!exists) {
            throw new IllegalStateException("configuration with id " +configurationId+" does not exists");
        }
        configurationRepository.deleteById(configurationId);
        System.out.println("the configuration with id : "+configurationId+ " has been deleted succefully");

    }

    @Transactional
    public Configuration updateConfiguration(Long configurationId, Configuration configurationreq) {
        Configuration configuration = configurationRepository.findById(configurationId).orElseThrow(() -> new IllegalStateException("configuration does not exists"));
        if (configuration != null){
            configuration.setCreated_at(configurationreq.getCreated_at());
            configuration.setKey(configurationreq.getKey());
            configuration.setValue(configurationreq.getValue());
            configuration.setProduct(configurationreq.getProduct());


            System.out.println("the configuration  has been updated succefully");

        }
        return configurationRepository.save(configuration);


    }
}
