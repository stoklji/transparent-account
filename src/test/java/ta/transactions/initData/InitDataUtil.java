package ta.transactions.initData;

import ta.transactions.entity.Account;
import ta.transactions.entity.Statement;
import ta.transactions.entity.Transaction;
import ta.transactions.entity.TransactionType;
import ta.transactions.repository.AccountRepository;
import ta.transactions.repository.StatementRepository;
import ta.transactions.repository.TransactionRepository;
import ta.transactions.repository.TransactionTypeRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public final class InitDataUtil {
    public static void initData(AccountRepository accountRepository, StatementRepository statementRepository, TransactionRepository transactionRepository, TransactionTypeRepository transactionTypeRepository) {
        deleteAll(accountRepository, statementRepository, transactionRepository, transactionTypeRepository);

        createAccounts(accountRepository);
        createStatements(statementRepository);
        createTransactionTypes(transactionTypeRepository);
        createTransactions(accountRepository, statementRepository, transactionTypeRepository, transactionRepository);
    }


    private static void createAccounts(AccountRepository accountRepository) {
        accountRepository.save(Account.builder()
                .number("2002222222")
                .name("PPF BANKA A.S.")
                .code("6000")
                .build());

        accountRepository.save(Account.builder()
                .number("0000009504010019")
                .name("PPF BANKA A.S.")
                .code("6000")
                .build());

        accountRepository.save(Account.builder()
                .number("0000009505020008")
                .name("PPF BANKA A.S.")
                .code("6000")
                .build());

        accountRepository.save(Account.builder()
                .number("0000009503010009")
                .name("PPF BANKA A.S.")
                .code("6000")
                .build());
    }

    private static void createStatements(StatementRepository statementRepository) {
        statementRepository.save(Statement.builder()
                .statementId(1L)
                .number("196")
                .description("statement1")
                .period("2022")
                .build());

        statementRepository.save(Statement.builder()
                .statementId(2L)
                .number("195")
                .description("statement2")
                .period("2022")
                .build());
    }

    private static void createTransactionTypes(TransactionTypeRepository transactionTypeRepository) {
        transactionTypeRepository.save(TransactionType.builder()
                .trxTypeId(1L)
                .type("DPO")
                .code(0)
                .build());

        transactionTypeRepository.save(TransactionType.builder()
                .trxTypeId(2L)
                .type("DPO")
                .code(1012209)
                .build());
    }

    private static void createTransactions(AccountRepository accountRepository, StatementRepository statementRepository, TransactionTypeRepository transactionTypeRepository, TransactionRepository transactionRepository) {
        Account account = accountRepository.findAll().stream().filter(acc -> "0000009505020008".equals(acc.getNumber())).findFirst().orElse(null);
        TransactionType transactionType = transactionTypeRepository.findAll().stream().filter(type -> type.getCode() == 0).findFirst().orElse(null);
        Statement statement = statementRepository.findAll().stream().filter(stmt -> "195".equals(stmt.getNumber())).findFirst().orElse(null);
        transactionRepository.save(Transaction.builder()
                .amount(new BigDecimal(1594))
                .currency("CZK")
                .id("20221018:0000003608")
                .bankRef("PS221018SO314645")
                .transactionId("4831381")
                .bookingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 18).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .postingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 18).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .creditDebitIndicator("DBIT")
                .ownAccountNumber("2002222222")
                .counterPartyAccount(account)
                .detail1("Platba elektřiny")
                .productBankRef("PS221018SO314645")
                .transactionType(transactionType)
                .statement(statement)
                .specificSymbol("12")
                .variableSymbol("12")
                .build());

        account = accountRepository.findAll().stream().filter(acc -> "0000009504010019".equals(acc.getNumber())).findFirst().orElse(null);
        transactionType = transactionTypeRepository.findAll().stream().filter(type -> type.getCode() == 1012209).findFirst().orElse(null);
        transactionRepository.save(Transaction.builder()
                .amount(new BigDecimal(100))
                .currency("CZK")
                .id("20221018:0000003607")
                .bankRef("PS221018SO314645")
                .transactionId("4831425")
                .bookingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 18).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .postingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 18).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .creditDebitIndicator("CRDT")
                .ownAccountNumber("2002222222")
                .counterPartyAccount(account)
                .detail1("Příspěvek")
                .productBankRef("PS221018SO314645")
                .transactionType(transactionType)
                .statement(statement)
                .specificSymbol("12")
                .variableSymbol("12")
                .build());

        statement = statementRepository.findAll().stream().filter(stmt -> "196".equals(stmt.getNumber())).findFirst().orElse(null);
        account = accountRepository.findAll().stream().filter(acc -> "0000009503010009".equals(acc.getNumber())).findFirst().orElse(null);
        transactionRepository.save(Transaction.builder()
                .amount(new BigDecimal(2000))
                .currency("CZK")
                .id("20221019:0000000221")
                .bankRef("PS221019SO314823")
                .transactionId("4831700")
                .bookingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 19).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .postingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 19).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .creditDebitIndicator("CRDT")
                .ownAccountNumber("2002222222")
                .counterPartyAccount(account)
                .detail1("Na dárky")
                .productBankRef("PS221019SO314823")
                .transactionType(transactionType)
                .statement(statement)
                .specificSymbol("61")
                .variableSymbol("61")
                .build());

        account = accountRepository.findAll().stream().filter(acc -> "0000009505020008".equals(acc.getNumber())).findFirst().orElse(null);
        transactionType = transactionTypeRepository.findAll().stream().filter(type -> type.getCode() == 0).findFirst().orElse(null);
        transactionRepository.save(Transaction.builder()
                .amount(new BigDecimal(1999))
                .currency("CZK")
                .id("20221019:0000000220")
                .bankRef("PS221019SO314822")
                .transactionId("4831701")
                .bookingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 19).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .postingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 19).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .creditDebitIndicator("CRDT")
                .ownAccountNumber("2002222222")
                .counterPartyAccount(account)
                .detail1("Trvalý příkaz 8")
                .productBankRef("PS221019SO314822")
                .transactionType(transactionType)
                .statement(statement)
                .specificSymbol("12")
                .variableSymbol("12")
                .build());

        account = accountRepository.findAll().stream().filter(acc -> "0000009505020008".equals(acc.getNumber())).findFirst().orElse(null);
        transactionType = transactionTypeRepository.findAll().stream().filter(type -> type.getCode() == 1012209).findFirst().orElse(null);
        transactionRepository.save(Transaction.builder()
                .amount(new BigDecimal(1500))
                .currency("CZK")
                .id("20221019:0000000219")
                .bankRef("PS221019SO314822")
                .transactionId("4831716")
                .bookingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 19).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .postingDate(Date.from(LocalDate.of(2022, Month.OCTOBER, 19).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .creditDebitIndicator("CRDT")
                .ownAccountNumber("2002222222")
                .counterPartyAccount(account)
                .detail1("Posílám peníze")
                .productBankRef("PS221019SO314822")
                .transactionType(transactionType)
                .statement(statement)
                .specificSymbol("12")
                .variableSymbol("12")
                .build());
    }

    public static void deleteAll(AccountRepository accountRepository, StatementRepository statementRepository, TransactionRepository transactionRepository, TransactionTypeRepository transactionTypeRepository) {
        transactionRepository.deleteAll();
        accountRepository.deleteAll();
        statementRepository.deleteAll();
        transactionTypeRepository.deleteAll();
    }
}
