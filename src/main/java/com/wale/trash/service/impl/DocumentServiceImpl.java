package com.wale.trash.service.impl;

import com.wale.trash.controller.enums.DocStatus;
import com.wale.trash.entity.Documents;
import com.wale.trash.repository.DocumentRepository;
import com.wale.trash.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository repository;

    @Override
    public Documents deleteDocument(Long docId) {
        Documents documents = repository.findById(docId).orElseThrow(()-> new RuntimeException("Not found"));

        if (documents != null){
            documents.setStatus(DocStatus.TRASH);
            repository.save(documents);
        }
        return documents;
    }

    @Override
    public List<Documents> getItemsInTrash() {
        return repository.findByStatus(DocStatus.TRASH);
    }

    @Override
    @Transactional
    public Documents permanentlyDeleteItem(Long docId) {
        Documents documents = repository.findById(docId).orElseThrow(()-> new RuntimeException("Not found"));

        if (documents != null){
            repository.delete(documents);
        }
        return documents;
    }

    @Override
    public Documents saveDocument(Documents documents) {
        return repository.save(documents);
    }
}
