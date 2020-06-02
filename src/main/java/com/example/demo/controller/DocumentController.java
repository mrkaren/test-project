package com.example.demo.controller;

import com.example.demo.dto.DocumentRequestDTO;
import com.example.demo.dto.DocumentResponseDTO;
import com.example.demo.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.service.DocumentService.mapToDocumentDTO;


@RestController
@RequestMapping("/document")
@AllArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/{id}")
    public ResponseEntity<DocumentResponseDTO> getAllDetails(@PathVariable("id") Long id) {
        return documentService.findById(id)
                .map(mapToDocumentDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> saveDocument(@RequestBody DocumentRequestDTO documentRequestDTO) {
        documentService.save(documentRequestDTO);
        return ResponseEntity.ok("document was successfully saved");
    }

}