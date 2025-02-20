package com.gaidau.console.intern.report.product;

import com.gaidau.console.intern.domain.dto.ProductDTO;
import com.gaidau.console.intern.report.IReport;
import com.gaidau.console.intern.report.ReportFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class ProductExcelExportService implements IReport<List<ProductDTO>> {
    @Override
    public byte[] export(List<ProductDTO> object) throws Exception {
        List<ProductDTO> node = object;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            SXSSFWorkbook workbook = new SXSSFWorkbook(10);

            // Create a Sheet
            Sheet sheet = workbook.createSheet("Employee Data");

            // Create a Row (Header)
            Row headerRow = sheet.createRow(0);

            // Define Column Headers
            String[] columns = {"ID", "Title", "Status", "IS Gift Card", "vendor", "updatedAt", "publishedAt"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }
            var i = 1;
            for (var item : node) {
                Row row = sheet.createRow(i++);
                row.createCell(0).setCellValue(item.id());
                row.createCell(1).setCellValue(item.title());
                row.createCell(2).setCellValue(item.status());
                row.createCell(3).setCellValue(item.isGiftCard());
                row.createCell(4).setCellValue(item.vendor());
                row.createCell(5).setCellValue(isNull(item.updatedAt()) ? "" : item.updatedAt().toString());
                row.createCell(6).setCellValue(isNull(item.updatedAt()) ? "" : item.updatedAt().toString());
            }
            workbook.write(baos);
            workbook.dispose();
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ReportFormat getFormat() {
        return ReportFormat.EXCEL;
    }
}
