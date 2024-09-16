package viniciusmartins.github.mongoapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import viniciusmartins.github.mongoapp.entity.Pessoa;
import viniciusmartins.github.mongoapp.repostrat.EntityService;
import viniciusmartins.github.mongoapp.repostrat.Repo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
public class RepoTest {

    @Autowired
    private EntityService entityService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private Repo repo;

    @Test
    void insert() throws Exception {
        entityService.insert(
                Pessoa.builder()
                        .nome("Jão")
                        .meioPagList(
                                List.of(Pessoa.MeioPag.builder()
                                                .nome("PIX")
                                                .id(UUID.randomUUID().toString())
                                                .campos(Map.of(
                                                        "chavePix","iosdajjoidsajiodspji"
                                                ))
                                                .build(),
                                        Pessoa.MeioPag.builder()
                                                .nome("CONTA_BANCARIA")
                                                .id(UUID.randomUUID().toString())
                                                .campos(Map.of(
                                                        "agencia","001",
                                                        "conta", "01023"
                                                )).build()
                                ))
                        .build()
        );
    }

    @Test
    void getAll() throws JsonProcessingException {
        System.out.println(
                mapper.writeValueAsString(entityService.getAll())
        );
    }

    @Test
    void updateNome() {
        Pessoa byId = repo.findById("66e872e2c5be811bfdcfb41f").get();
        byId.setNome("updated");
        entityService.update(byId);
    }

    @Test
    void updateMeioPag() {
        // apagar um meio pagamento e modificar a chave pix ao msm tempo
    }


}
