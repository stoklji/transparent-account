package ta.transactions.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "statement")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Statement {
    @Id
    @GeneratedValue
    private long statementId;

    @NotNull
    @Column(length = 20)
    @Size(max = 20)
    private String number;

    @NotNull
    @Column(length = 20)
    @Size(max = 20)
    private String period;

    @NotNull
    @Column(length = 1000)
    @Size(max = 1000)
    private String description;
}
