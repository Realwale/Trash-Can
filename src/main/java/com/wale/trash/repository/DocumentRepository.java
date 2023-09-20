package com.wale.trash.repository;

import com.wale.trash.controller.enums.DocStatus;
import com.wale.trash.entity.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Documents, Long> {
    List<Documents> findByStatus(DocStatus docStatus);

}
