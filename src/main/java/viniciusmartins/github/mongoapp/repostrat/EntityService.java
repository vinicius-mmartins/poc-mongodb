package viniciusmartins.github.mongoapp.repostrat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import viniciusmartins.github.mongoapp.entity.Pessoa;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntityService {

    private final Repo repo;

    public void insert(Pessoa pessoa) {
        repo.save(pessoa);
    }

    public List<Pessoa> getAll() {
        return repo.findAll();
    }

    public Pessoa update(Pessoa pessoa) {
        return repo.save(pessoa);
    }

}
