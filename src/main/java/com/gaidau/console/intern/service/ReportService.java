package com.gaidau.console.intern.service;

import com.gaidau.console.intern.report.IReport;
import com.gaidau.console.intern.report.ReportFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ReportService<T> {

    private final Logger log = LoggerFactory.getLogger(ReportService.class);

    protected Map<ReportFormat, IReport> map;

    public ReportService(List<IReport> list) {
        this.map = list.stream().collect(Collectors.toMap(IReport::getFormat, Function.identity()));
    }

    public byte[] generateReport(T object, ReportFormat format) {
        log.info("Request to generate report of '{}' format.", format);
        try {
            return map.get(format).export(object);
        } catch (Exception e) {
            log.error("ERROR on generating file: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
