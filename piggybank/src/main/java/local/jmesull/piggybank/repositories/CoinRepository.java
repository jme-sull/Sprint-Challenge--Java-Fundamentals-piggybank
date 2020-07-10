package local.jmesull.piggybank.repositories;

import local.jmesull.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long>
{
}
