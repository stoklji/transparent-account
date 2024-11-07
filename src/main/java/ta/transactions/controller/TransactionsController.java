package ta.transactions.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ta.transactions.dto.TransactionDto;
import ta.transactions.service.TransactionService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Api(tags = "Transactions")
@AllArgsConstructor
public class TransactionsController {
    private final TransactionService transactionService;

    @ApiOperation(value = "Get all transaction by account number.")
    @RequestMapping(value = "/accounts/{accountNumber}/transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success")})
    public ResponseEntity<List<TransactionDto>> getTransactionsByAccountNumber(@NotNull @PathVariable("accountNumber") String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Path variable (\"accountNumber\") cannot be null or empty.");
        }

        List<TransactionDto> transactions = transactionService.findAllByAccountNumber(accountNumber);

        return ResponseEntity.ok(transactions);
    }
}
