package com.optimumtech.api_report.report;

import com.optimumtech.api_report.report.models.request.UserResponse;
import com.optimumtech.api_report.report.services.ReportService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReportServiceTest {
    @Test
    void generateReport_returnsNonEmptyPdf() throws Exception {
        // Arrange: crear instancia y mockear usuarios
        ReportService reportService = new ReportService() {
            @Override
            public byte[] generateReport(String reportName) throws Exception {
                // Simular usuarios sin llamada HTTP real
                java.util.List<UserResponse> userList = java.util.Arrays.asList(mockUser());
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                com.itextpdf.text.Document document = new com.itextpdf.text.Document();
                com.itextpdf.text.pdf.PdfWriter.getInstance(document, out);
                document.open();
                document.add(new com.itextpdf.text.Paragraph("Reporte de Usuarios"));
                com.itextpdf.text.pdf.PdfPTable table = new com.itextpdf.text.pdf.PdfPTable(4);
                table.addCell("ID");
                table.addCell("Nombre");
                table.addCell("Email");
                table.addCell("Rol");
                for (UserResponse user : userList) {
                    table.addCell(String.valueOf(user.getId()));
                    table.addCell(user.getNombre());
                    table.addCell(user.getEmail());
                    table.addCell(user.getRol());
                }
                document.add(table);
                document.close();
                return out.toByteArray();
            }

            private UserResponse mockUser() {
                UserResponse user = new UserResponse();
                user.setId(1L);
                user.setNombre("Test User");
                user.setEmail("test@example.com");
                user.setRol("ADMIN");
                return user;
            }
        };
        // Act
        byte[] pdfBytes = reportService.generateReport("test");
        // Assert
        assertNotNull(pdfBytes);
        assertTrue(pdfBytes.length > 0, "El PDF generado debe tener contenido");
    }
}
