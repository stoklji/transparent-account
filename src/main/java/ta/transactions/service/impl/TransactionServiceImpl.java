package ta.transactions.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ta.transactions.repository.TransactionRepository;
import ta.transactions.dto.TransactionDto;
import ta.transactions.entity.Transaction;
import ta.transactions.service.TransactionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public List<TransactionDto> findAllByAccountNumber(String accountNumber) {
        List<Transaction> transactions = transactionRepository.findByOwnAccountNumber(accountNumber);

        return transactions.stream().map(TransactionDto::new).collect(Collectors.toList());
    }
}
