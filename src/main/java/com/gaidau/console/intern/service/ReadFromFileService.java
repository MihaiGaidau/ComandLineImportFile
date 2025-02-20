package com.gaidau.console.intern.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gaidau.console.intern.domain.dto.RootDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ReadFromFileService implements CommandLineService {

    private final Logger log = LoggerFactory.getLogger(ReadFromFileService.class);


    private final InMenoryDBService inMenoryDBService;
    private final ExportProductService exportProductService;

    public ReadFromFileService(InMenoryDBService inMenoryDBService, ExportProductService exportProductService) {
        this.inMenoryDBService = inMenoryDBService;
        this.exportProductService = exportProductService;
    }


    @Override
    public RootDTO run(Object... args) {
        log.info("Reading from file...");
        var jsonFilePath = (String) args[0];
        log.info("Reading from file...{}", jsonFilePath);
        File file = new File(jsonFilePath);

        if (!file.exists()) {
            System.out.println("File not found: " + jsonFilePath);
            return null;
        }
        try {
            // Deserialize JSON to Java Object
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            // Deserialize JSON
            RootDTO rootDTO = objectMapper.readValue(file, RootDTO.class);
            inMenoryDBService.setProductsDTO(rootDTO.data().products());
//            log.info(inMenoryDBService.getProductsDTO().toString());
            log.info("Reading from file successful");
            exportProductService.run("C:\\Users\\Mihai\\Desktop\\Interview\\output","EXCEL");
            // Print products
            return rootDTO;
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
        return null;
    }

    @Override
    public LineCommand getLineCommand() {
        return LineCommand.READ;
    }


}
