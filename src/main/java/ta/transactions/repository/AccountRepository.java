package ta.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ta.transactions.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
