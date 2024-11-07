package ta.transactions.service;


import ta.transactions.dto.TransactionDto;

import javax.transaction.Transactional;
import java.util.List;


public interface TransactionService {
    @Transactional
    List<TransactionDto> findAllByAccountNumber(String accountNumber);
}
