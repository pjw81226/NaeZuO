package com.naezuo.goods.infrastructure.repository;

import com.naezuo.goods.domain.EditorFile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoEditorRepository extends MongoRepository<EditorFile, String> {
    List<EditorFile> findByUserId(String userId);
}
