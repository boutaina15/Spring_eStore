package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.Configuration;

import java.util.List;

public interface ConfigurationService {


    List<Configuration> getConfigurations();

    void deleteConfiguration(Long configurationId);

    Configuration updateConfiguration(Long configurationId, Configuration configurationreq);

    Configuration addConfiguration(Configuration configuration);

}
