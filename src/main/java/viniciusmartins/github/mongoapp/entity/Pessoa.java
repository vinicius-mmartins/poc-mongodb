package viniciusmartins.github.mongoapp.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Builder
@Document("pessoas")
public class Pessoa {

    @Id
    private String id;
    private String nome;
    @Field("meios_pagamento")
    private List<MeioPag> meioPagList;

    @Getter
    @Setter
    @Builder
    public static class MeioPag {
        private String id;
        private String nome;
        private Map<String, String> campos;

        @JsonAnySetter
        public void setCampos(String key, String value) {
            campos.put(key, value);
        }
    }

}

