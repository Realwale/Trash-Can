package com.wale.trash.controller;

import com.wale.trash.entity.Documents;
import com.wale.trash.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/documents")
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<Documents> saveDocument(@RequestBody Documents documents){
        return new ResponseEntity<>(documentService.saveDocument(documents), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Documents> deleteDocument(@PathVariable("id") Long docId){
        Documents deletedDoc = documentService.deleteDocument(docId);
        if (deletedDoc != null){
            return ResponseEntity.ok(deletedDoc);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/trash")
    public ResponseEntity<List<Documents>> getDocInTrash(){
        return ResponseEntity.ok(documentService.getItemsInTrash());
    }

    @DeleteMapping("trash/{id}")
    public ResponseEntity<Documents> permanentlyDeleteItem(@PathVariable("id") Long docId){
        Documents deletedDoc = documentService.permanentlyDeleteItem(docId);

        if (deletedDoc != null){
            return ResponseEntity.ok(deletedDoc);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

}
