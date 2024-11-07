package ta.transactions.dto;

import lombok.*;
import ta.transactions.entity.Transaction;

import java.math.RoundingMode;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {
    private AmountDto amount;
    private String bankRef;
    private String bookingDate;
    private CounterPartyAccountDto counterPartyAccount;
    private String creditDebitIndicator;
    private DetailsDto details;
    private String id;
    private String ownAccountNumber;
    private String postingDate;
    private String productBankRef;
    private String specificSymbol;
    private String statementNumber;
    private String statementPeriod;
    private String transactionId;
    private String transactionType;
    private Integer transactionTypeCode;
    private String variableSymbol;

    public TransactionDto(Transaction transaction) {
        this.amount = new AmountDto(transaction.getCurrency(), transaction.getAmount().setScale(0, RoundingMode.HALF_EVEN));
        this.bankRef = transaction.getBankRef();
        this.bookingDate = new SimpleDateFormat("yyyy-MM-dd").format(transaction.getBookingDate());
        this.counterPartyAccount = new CounterPartyAccountDto(transaction.getCounterPartyAccount());
        this.creditDebitIndicator = transaction.getCreditDebitIndicator();
        this.details = new DetailsDto(transaction.getDetail1());
        this.id = transaction.getId();
        this.ownAccountNumber = transaction.getOwnAccountNumber();
        this.postingDate = new SimpleDateFormat("yyyy-MM-dd").format(transaction.getPostingDate());
        this.productBankRef = transaction.getProductBankRef();
        this.specificSymbol = transaction.getSpecificSymbol();
        this.statementNumber = transaction.getStatement().getNumber();
        this.statementPeriod = transaction.getStatement().getPeriod();
        this.transactionId = transaction.getTransactionId();
        this.transactionType = transaction.getTransactionType().getType();
        this.transactionTypeCode = transaction.getTransactionType().getCode();
        this.variableSymbol = transaction.getVariableSymbol();
    }
}
