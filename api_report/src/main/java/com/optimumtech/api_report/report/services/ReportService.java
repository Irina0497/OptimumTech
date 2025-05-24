package com.optimumtech.api_report.report.services;

import net.sf.jasperreports.engine.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
    public byte[] generateReport(String reportName)  throws JRException{
        try {
            //Cargar el reporte
            InputStream reportStream = this.getClass().getResourceAsStream("/reports/" + reportName + ".jasper");
            if (reportStream == null) {
                throw new IllegalArgumentException("No se encontró el reporte: " + reportName);
            }

            Map<String, Object> params = new HashMap<>();

            // Agregar parámetros al reporte 
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, new JREmptyDataSource());
            
            //exporta el reporte a PDF
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            
            throw new RuntimeException("Error al generar el reporte: " + e.getMessage(), e);
        }
    }
}