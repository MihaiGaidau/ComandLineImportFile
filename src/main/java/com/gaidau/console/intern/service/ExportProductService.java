package com.gaidau.console.intern.service;

import com.gaidau.console.intern.domain.dto.RootDTO;
import com.gaidau.console.intern.report.ReportFormat;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ExportProductService implements CommandLineService {

    private final ReportService reportService;
    private final InMenoryDBService inMenoryDBService;


    public ExportProductService(ReportService reportService, InMenoryDBService inMenoryDBService) {
        this.reportService = reportService;
        this.inMenoryDBService = inMenoryDBService;
    }


    @Override
    public RootDTO run(Object... args) {
        String savePath = (String) args[0];
        String reportFormat = (String) args[1];
        var format = ReportFormat.valueOf(reportFormat);

        var bytes = reportService.generateReport(inMenoryDBService.getProductsDTO().nodes(), format);
        String filePath = savePath +"."+format.getValue();

        // Write the byte array to the file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytes);
            System.out.println("File saved successfully at " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LineCommand getLineCommand() {
        return LineCommand.EXPORT;
    }


}
