package com.example.demo.service;

import com.example.demo.dto.DocumentRequestDTO;
import com.example.demo.dto.DocumentResponseDTO;
import com.example.demo.entity.Document;

import java.util.Optional;
import java.util.function.Function;

public interface DocumentService {

    Optional<Document> findById(Long id);

    void save(DocumentRequestDTO documentRequestDTO);

    Function<Document, DocumentResponseDTO> mapToDocumentDTO = p -> DocumentResponseDTO.builder().id(p.getId()).name(p.getName()).parent(p.getParent()).children(p.getChildren()).build();

}
