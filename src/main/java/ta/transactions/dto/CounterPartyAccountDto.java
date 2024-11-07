package ta.transactions.dto;

import lombok.*;
import ta.transactions.entity.Account;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CounterPartyAccountDto {
    private String accountName;
    private String accountNumber;
    private String bankCode;

    public CounterPartyAccountDto(Account account) {
        this.accountName = account.getName();
        this.accountNumber = account.getNumber();
        this.bankCode = account.getCode();
    }
}
