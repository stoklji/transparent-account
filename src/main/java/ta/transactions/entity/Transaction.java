package ta.transactions.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private long trxId;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @Column(length = 3)
    @Size(max = 3)
    private String currency;

    @NotNull
    @Column(length = 20)
    @Size(max = 20)
    private String id;

    @NotNull
    @Column(length = 20)
    @Size(max = 20)
    private String bankRef;

    @NotNull
    @Column(length = 20)
    @Size(max = 20)
    private String transactionId;

    private Date bookingDate;

    @NotNull
    private Date postingDate;

    @Column(length = 4)
    @Size(max = 4)
    private String creditDebitIndicator;

    @Column(length = 20)
    @Size(max = 20)
    private String ownAccountNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account counterPartyAccount;

    @Column(length = 50)
    @Size(max = 50)
    private String detail1;

    @Column(length = 50)
    @Size(max = 50)
    private String detail2;

    @Column(length = 50)
    @Size(max = 50)
    private String detail3;

    @Column(length = 50)
    @Size(max = 50)
    private String detail4;

    @Column(length = 50)
    @Size(max = 50)
    private String productBankRef;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "trxTypeId")
    private TransactionType transactionType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "statementId")
    private Statement statement;

    @Column(length = 10)
    @Size(max = 10)
    private String constantSymbol;

    @Column(length = 10)
    @Size(max = 10)
    private String specificSymbol;

    @Column(length = 10)
    @Size(max = 10)
    private String variableSymbol;
}
