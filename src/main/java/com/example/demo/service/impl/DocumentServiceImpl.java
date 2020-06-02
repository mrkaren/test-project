package com.example.demo.service.impl;

import com.example.demo.dto.DocumentRequestDTO;
import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public Optional<Document> findById(Long id) {
        return documentRepository.findById(id);
    }

    @Override
    public void save(DocumentRequestDTO documentRequestDTO) {
        Document document = convertToDocument(documentRequestDTO);
        documentRepository.save(document);
    }

    private Document convertToDocument(DocumentRequestDTO documentRequestDTO) {
        return Document.builder()
                .name(documentRequestDTO.getName())
                .parent(findParent(documentRequestDTO.getParentId()))
                .build();
    }

    private Document findParent(Long id) {
        if (id != null) {
            return documentRepository.findById(id).orElse(null);
        } else {
            return null;
        }
    }

}
