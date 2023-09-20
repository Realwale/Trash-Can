package com.wale.trash.service;

import com.wale.trash.entity.Documents;

import java.util.List;

public interface DocumentService {

    Documents deleteDocument(Long docId);

    List<Documents> getItemsInTrash();

    Documents permanentlyDeleteItem(Long docId);

    Documents saveDocument(Documents documents);

}
