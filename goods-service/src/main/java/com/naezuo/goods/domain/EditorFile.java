package com.naezuo.goods.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@Builder
@Document(collection = "editor_data") // MongoDB 컬렉션 이름
public class EditorFile {
    @Id
    private String id;
    private String userId; // 프론트에서 전달받는 userId
    private String data; // JSON 데이터를 Map 형태로 저장
}
