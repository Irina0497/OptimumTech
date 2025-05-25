package com.optimumtech.api_report.report.services;

import com.optimumtech.api_report.report.models.request.UserResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ReportService {

    private final String USERS_API_URL = "http://localhost:8081/usuario/";

    public byte[] generateReport(String reportName) throws Exception {
        // 1. Obtener los usuarios
        RestTemplate restTemplate = new RestTemplate();
        UserResponse[] usuarios = restTemplate.getForObject(USERS_API_URL, UserResponse[].class);
        List<UserResponse> userList = Arrays.asList(usuarios);

        // 2. Crear PDF
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        // Agregar imagen 
        try {
            Image img = Image.getInstance(getClass().getResource("leaf_banner_violet.png"));
            // C:\Users\tabat\OneDrive\Escritorio\AAAAAAAAAAAAAAA\OptimumTech-reporte\OptimumTech-reporte\api_report\src\main\resources\leaf_banner_violet.png 
            img.scaleToFit(100, 100); // ajusta tamaño según convenga
            img.setAlignment(Element.ALIGN_CENTER);
            document.add(img);
        } catch (Exception e) {
            // Si no encuentra la imagen, simplemente sigue sin detener el reporte
            System.err.println("No se pudo cargar la imagen: " + e.getMessage());
        }


        // Título con estilo
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.DARK_GRAY);
        Paragraph title = new Paragraph("Reporte de Usuarios", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20f);
        document.add(title);

        // Tabla con 4 columnas y ancho configurado
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1f, 3f, 4f, 2f});

        // Encabezados con fondo y texto blanco
        Stream.of("ID", "Nombre", "Email", "Rol").forEach(header -> {
            PdfPCell cell = new PdfPCell(new Phrase(header, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)));
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8f);
            table.addCell(cell);
        });

        // Filas con color alternado y padding
        boolean odd = true;
        for (UserResponse user : userList) {
            BaseColor bgColor = odd ? BaseColor.WHITE : new BaseColor(230, 230, 230);
            odd = !odd;

            PdfPCell cellId = new PdfPCell(new Phrase(String.valueOf(user.getId())));
            cellId.setBackgroundColor(bgColor);
            cellId.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellId.setPadding(5f);

            PdfPCell cellNombre = new PdfPCell(new Phrase(user.getNombre()));
            cellNombre.setBackgroundColor(bgColor);
            cellNombre.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellNombre.setPadding(5f);

            PdfPCell cellEmail = new PdfPCell(new Phrase(user.getEmail()));
            cellEmail.setBackgroundColor(bgColor);
            cellEmail.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellEmail.setPadding(5f);

            PdfPCell cellRol = new PdfPCell(new Phrase(user.getRol()));
            cellRol.setBackgroundColor(bgColor);
            cellRol.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellRol.setPadding(5f);

            table.addCell(cellId);
            table.addCell(cellNombre);
            table.addCell(cellEmail);
            table.addCell(cellRol);
        }

        document.add(table);
        document.close();

        return out.toByteArray();
    }
}


// package com.optimumtech.api_report.report.services;

// import com.optimumtech.api_report.report.models.request.UserResponse;
// import com.itextpdf.text.*;
// import com.itextpdf.text.pdf.*;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import java.io.ByteArrayOutputStream;
// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Stream;


// @Service
// public class ReportService {

//     private final String USERS_API_URL = "http://localhost:8081/usuario/";

//     public byte[] generateReport(String reportName) throws Exception {
//         // 1. Obtener los usuarios
//         RestTemplate restTemplate = new RestTemplate();
//         UserResponse[] usuarios = restTemplate.getForObject(USERS_API_URL, UserResponse[].class);
//         List<UserResponse> userList = Arrays.asList(usuarios);

//         // 2. Crear PDF
//         ByteArrayOutputStream out = new ByteArrayOutputStream();
//         Document document = new Document();
//         PdfWriter.getInstance(document, out);
//         document.open();

//         document.add(new Paragraph("Reporte de Usuarios", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
//         document.add(Chunk.NEWLINE);

//         // 3. Crear tabla
//         PdfPTable table = new PdfPTable(4); // columnas: ID, Nombre, Email, Rol
//         table.setWidthPercentage(100);
//         table.setWidths(new float[]{1, 3, 4, 2});

//         // Encabezados
//         Stream.of("ID", "Nombre", "Email", "Rol").forEach(header -> {
//             PdfPCell cell = new PdfPCell(new Phrase(header));
//             cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//             table.addCell(cell);
//         });

//         // Datos
//         for (UserResponse user : userList) {
//             table.addCell(String.valueOf(user.getId()));
//             table.addCell(user.getNombre());
//             table.addCell(user.getEmail());
//             table.addCell(user.getRol());
//         }

//         document.add(table);
//         document.close();

//         return out.toByteArray();
//     }
// }
