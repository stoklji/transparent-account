package ta.transactions.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "transactionType")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TransactionType {
    @Id
    @GeneratedValue
    private long trxTypeId;

    @NotNull
    @Column(length = 20)
    @Size(max = 20)
    private String type;

    @NotNull
    private int code;
}
