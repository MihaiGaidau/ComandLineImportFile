package com.gaidau.console.intern.report.product;

import com.gaidau.console.intern.domain.dto.ProductDTO;
import com.gaidau.console.intern.report.IReport;
import com.gaidau.console.intern.report.ReportFormat;
import org.springframework.stereotype.Service;

@Service
public class ProductPdfExportService implements IReport<ProductDTO> {
    @Override
    public byte[] export(ProductDTO object) throws Exception {
        return new byte[0];
    }

    @Override
    public ReportFormat getFormat() {
        return ReportFormat.PDF;
    }
}
