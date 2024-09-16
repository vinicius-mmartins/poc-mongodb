package viniciusmartins.github.mongoapp.repostrat;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import viniciusmartins.github.mongoapp.entity.Pessoa;

@Repository
public interface Repo extends MongoRepository<Pessoa, String> {
}
