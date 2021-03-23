package cryptography.api.repository;

import cryptography.api.model.TBCryptography;
import org.springframework.data.repository.CrudRepository;

public interface CryptographyRepository extends CrudRepository<TBCryptography, Long> {
}
