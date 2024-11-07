package ta.transactions.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private long accountId;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String name;

    @NotNull
    @Column(length = 20)
    @Size(max = 20)
    private String number;

    @NotNull
    @Column(length = 4)
    @Size(max = 4)
    private String code;
}
