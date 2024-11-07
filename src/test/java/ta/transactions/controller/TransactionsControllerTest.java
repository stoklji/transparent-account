package ta.transactions.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;
import ta.transactions.TransparentAccountApp;
import ta.transactions.dto.TransactionDto;
import ta.transactions.initData.InitDataUtil;
import ta.transactions.repository.AccountRepository;
import ta.transactions.repository.StatementRepository;
import ta.transactions.repository.TransactionRepository;
import ta.transactions.repository.TransactionTypeRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TransparentAccountApp.class)
class TransactionsControllerTest {
    @Autowired
    TransactionsController transactionsController;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    StatementRepository statementRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    @BeforeEach
    void setUp() {
        InitDataUtil.initData(accountRepository, statementRepository, transactionRepository, transactionTypeRepository);
    }

    @AfterEach
    void clear() {
        InitDataUtil.deleteAll(accountRepository, statementRepository, transactionRepository, transactionTypeRepository);
    }

    @Test
    void getTransactionsByExistingAccountNumberResponseOkWithTransactions() {
        ResponseEntity<List<TransactionDto>> response = transactionsController.getTransactionsByAccountNumber("2002222222");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(5, response.getBody().size());

        // first transaction
        TransactionDto firstTransaction = response.getBody().get(0);
        Assertions.assertAll(
                () -> assertNotNull(firstTransaction.getAmount()),
                () -> assertEquals("CZK", firstTransaction.getAmount().getCurrency()),
                () -> assertEquals(BigDecimal.valueOf(1594), firstTransaction.getAmount().getValue()),
                () -> assertEquals("PS221018SO314645", firstTransaction.getBankRef()),
                () -> assertEquals("2022-10-18", firstTransaction.getBookingDate()),
                () -> assertNotNull(firstTransaction.getCounterPartyAccount()),
                () -> assertEquals("PPF BANKA A.S.", firstTransaction.getCounterPartyAccount().getAccountName()),
                () -> assertEquals("0000009505020008", firstTransaction.getCounterPartyAccount().getAccountNumber()),
                () -> assertEquals("6000", firstTransaction.getCounterPartyAccount().getBankCode()),
                () -> assertEquals("DBIT", firstTransaction.getCreditDebitIndicator()),
                () -> assertNotNull(firstTransaction.getDetails()),
                () -> assertEquals("Platba elektřiny", firstTransaction.getDetails().getDetail1()),
                () -> assertEquals("20221018:0000003608", firstTransaction.getId()),
                () -> assertEquals("2022-10-18", firstTransaction.getPostingDate()),
                () -> assertEquals("PS221018SO314645", firstTransaction.getProductBankRef()),
                () -> assertEquals("12", firstTransaction.getSpecificSymbol()),
                () -> assertEquals("195", firstTransaction.getStatementNumber()),
                () -> assertEquals("2022", firstTransaction.getStatementPeriod()),
                () -> assertEquals("4831381", firstTransaction.getTransactionId()),
                () -> assertEquals("DPO", firstTransaction.getTransactionType()),
                () -> assertEquals(0, firstTransaction.getTransactionTypeCode()),
                () -> assertEquals("12", firstTransaction.getVariableSymbol())
        );

        TransactionDto secondTransaction = response.getBody().get(1);
        Assertions.assertAll(
                () -> assertNotNull(secondTransaction.getAmount()),
                () -> assertEquals("CZK", secondTransaction.getAmount().getCurrency()),
                () -> assertEquals(BigDecimal.valueOf(100), secondTransaction.getAmount().getValue()),
                () -> assertEquals("PS221018SO314645", secondTransaction.getBankRef()),
                () -> assertEquals("2022-10-18", secondTransaction.getBookingDate()),
                () -> assertNotNull(secondTransaction.getCounterPartyAccount()),
                () -> assertEquals("PPF BANKA A.S.", secondTransaction.getCounterPartyAccount().getAccountName()),
                () -> assertEquals("0000009504010019", secondTransaction.getCounterPartyAccount().getAccountNumber()),
                () -> assertEquals("6000", secondTransaction.getCounterPartyAccount().getBankCode()),
                () -> assertEquals("CRDT", secondTransaction.getCreditDebitIndicator()),
                () -> assertNotNull(secondTransaction.getDetails()),
                () -> assertEquals("Příspěvek", secondTransaction.getDetails().getDetail1()),
                () -> assertEquals("20221018:0000003607", secondTransaction.getId()),
                () -> assertEquals("2022-10-18", secondTransaction.getPostingDate()),
                () -> assertEquals("PS221018SO314645", secondTransaction.getProductBankRef()),
                () -> assertEquals("12", secondTransaction.getSpecificSymbol()),
                () -> assertEquals("195", secondTransaction.getStatementNumber()),
                () -> assertEquals("2022", secondTransaction.getStatementPeriod()),
                () -> assertEquals("4831425", secondTransaction.getTransactionId()),
                () -> assertEquals("DPO", secondTransaction.getTransactionType()),
                () -> assertEquals(1012209, secondTransaction.getTransactionTypeCode()),
                () -> assertEquals("12", secondTransaction.getVariableSymbol())
        );

        TransactionDto thirdTransaction = response.getBody().get(2);
        Assertions.assertAll(
                () -> assertNotNull(thirdTransaction.getAmount()),
                () -> assertEquals("CZK", thirdTransaction.getAmount().getCurrency()),
                () -> assertEquals(BigDecimal.valueOf(2000), thirdTransaction.getAmount().getValue()),
                () -> assertEquals("PS221019SO314823", thirdTransaction.getBankRef()),
                () -> assertEquals("2022-10-19", thirdTransaction.getBookingDate()),
                () -> assertNotNull(thirdTransaction.getCounterPartyAccount()),
                () -> assertEquals("PPF BANKA A.S.", thirdTransaction.getCounterPartyAccount().getAccountName()),
                () -> assertEquals("0000009503010009", thirdTransaction.getCounterPartyAccount().getAccountNumber()),
                () -> assertEquals("6000", thirdTransaction.getCounterPartyAccount().getBankCode()),
                () -> assertEquals("CRDT", thirdTransaction.getCreditDebitIndicator()),
                () -> assertNotNull(thirdTransaction.getDetails()),
                () -> assertEquals("Na dárky", thirdTransaction.getDetails().getDetail1()),
                () -> assertEquals("20221019:0000000221", thirdTransaction.getId()),
                () -> assertEquals("2022-10-19", thirdTransaction.getPostingDate()),
                () -> assertEquals("PS221019SO314823", thirdTransaction.getProductBankRef()),
                () -> assertEquals("61", thirdTransaction.getSpecificSymbol()),
                () -> assertEquals("196", thirdTransaction.getStatementNumber()),
                () -> assertEquals("2022", thirdTransaction.getStatementPeriod()),
                () -> assertEquals("4831700", thirdTransaction.getTransactionId()),
                () -> assertEquals("DPO", thirdTransaction.getTransactionType()),
                () -> assertEquals(1012209, thirdTransaction.getTransactionTypeCode()),
                () -> assertEquals("61", thirdTransaction.getVariableSymbol())
        );

        TransactionDto fourthTransaction = response.getBody().get(3);
        Assertions.assertAll(
                () -> assertNotNull(fourthTransaction.getAmount()),
                () -> assertEquals("CZK", fourthTransaction.getAmount().getCurrency()),
                () -> assertEquals(BigDecimal.valueOf(1999), fourthTransaction.getAmount().getValue()),
                () -> assertEquals("PS221019SO314822", fourthTransaction.getBankRef()),
                () -> assertEquals("2022-10-19", fourthTransaction.getBookingDate()),
                () -> assertNotNull(fourthTransaction.getCounterPartyAccount()),
                () -> assertEquals("PPF BANKA A.S.", fourthTransaction.getCounterPartyAccount().getAccountName()),
                () -> assertEquals("0000009505020008", fourthTransaction.getCounterPartyAccount().getAccountNumber()),
                () -> assertEquals("6000", fourthTransaction.getCounterPartyAccount().getBankCode()),
                () -> assertEquals("CRDT", fourthTransaction.getCreditDebitIndicator()),
                () -> assertNotNull(fourthTransaction.getDetails()),
                () -> assertEquals("Trvalý příkaz 8", fourthTransaction.getDetails().getDetail1()),
                () -> assertEquals("20221019:0000000220", fourthTransaction.getId()),
                () -> assertEquals("2022-10-19", fourthTransaction.getPostingDate()),
                () -> assertEquals("PS221019SO314822", fourthTransaction.getProductBankRef()),
                () -> assertEquals("12", fourthTransaction.getSpecificSymbol()),
                () -> assertEquals("196", fourthTransaction.getStatementNumber()),
                () -> assertEquals("2022", fourthTransaction.getStatementPeriod()),
                () -> assertEquals("4831701", fourthTransaction.getTransactionId()),
                () -> assertEquals("DPO", fourthTransaction.getTransactionType()),
                () -> assertEquals(0, fourthTransaction.getTransactionTypeCode()),
                () -> assertEquals("12", fourthTransaction.getVariableSymbol())
        );

        TransactionDto fifthTransaction = response.getBody().get(4);
        Assertions.assertAll(
                () -> assertNotNull(fifthTransaction.getAmount()),
                () -> assertEquals("CZK", fifthTransaction.getAmount().getCurrency()),
                () -> assertEquals(BigDecimal.valueOf(1500), fifthTransaction.getAmount().getValue()),
                () -> assertEquals("PS221019SO314822", fifthTransaction.getBankRef()),
                () -> assertEquals("2022-10-19", fifthTransaction.getBookingDate()),
                () -> assertNotNull(fifthTransaction.getCounterPartyAccount()),
                () -> assertEquals("PPF BANKA A.S.", fifthTransaction.getCounterPartyAccount().getAccountName()),
                () -> assertEquals("0000009505020008", fifthTransaction.getCounterPartyAccount().getAccountNumber()),
                () -> assertEquals("6000", fifthTransaction.getCounterPartyAccount().getBankCode()),
                () -> assertEquals("CRDT", fifthTransaction.getCreditDebitIndicator()),
                () -> assertNotNull(fifthTransaction.getDetails()),
                () -> assertEquals("Posílám peníze", fifthTransaction.getDetails().getDetail1()),
                () -> assertEquals("20221019:0000000219", fifthTransaction.getId()),
                () -> assertEquals("2022-10-19", fifthTransaction.getPostingDate()),
                () -> assertEquals("PS221019SO314822", fifthTransaction.getProductBankRef()),
                () -> assertEquals("12", fifthTransaction.getSpecificSymbol()),
                () -> assertEquals("196", fifthTransaction.getStatementNumber()),
                () -> assertEquals("2022", fifthTransaction.getStatementPeriod()),
                () -> assertEquals("4831716", fifthTransaction.getTransactionId()),
                () -> assertEquals("DPO", fifthTransaction.getTransactionType()),
                () -> assertEquals(1012209, fifthTransaction.getTransactionTypeCode()),
                () -> assertEquals("12", fifthTransaction.getVariableSymbol())
        );
    }

    @Test
    void getTransactionsByUnknownAccountNumberResponseOkWithEmptyBody() {
        ResponseEntity<List<TransactionDto>> response = transactionsController.getTransactionsByAccountNumber("1001111111");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(0, response.getBody().size());
    }

    @Test
    void getTransactionsByNullAccountNumberBadRequestResponse() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> transactionsController.getTransactionsByAccountNumber(null));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertEquals("Path variable (\"accountNumber\") cannot be null or empty.", exception.getReason());
    }

    @Test
    void getTransactionsByEmptyAccountNumberBadRequestResponse() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> transactionsController.getTransactionsByAccountNumber(""));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertEquals("Path variable (\"accountNumber\") cannot be null or empty.", exception.getReason());
    }
}