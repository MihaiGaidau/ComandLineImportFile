package com.gaidau.console.intern.service;

import com.gaidau.console.intern.domain.dto.RootDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements CommandLineService {

    private final ReadFromFileService readFromFileService;

    public ProductService(ReadFromFileService readFromFileService) {
        this.readFromFileService = readFromFileService;
    }

    @Override
    public RootDTO run(Object... args) {
        var dto = readFromFileService.run(args);


        return dto;
    }

    @Override
    public LineCommand getLineCommand() {
        return LineCommand.SAVE;
    }
}
