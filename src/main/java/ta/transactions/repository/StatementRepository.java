package ta.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ta.transactions.entity.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {
}
