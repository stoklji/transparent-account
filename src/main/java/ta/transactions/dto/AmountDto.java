package ta.transactions.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmountDto {
    private String currency;
    private BigDecimal value;
}
