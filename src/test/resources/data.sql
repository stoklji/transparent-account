-- accounts
insert into account(accountId, name, number, code)
values (1, 'PPF BANKA A.S.', '2002222222', '6000');
insert into account(accountId, name, number, code)
values (2, 'PPF BANKA A.S.', '0000009504010019', '6000');
insert into account(accountId, name, number, code)
values (3, 'PPF BANKA A.S.', '0000009505020008', '6000');
insert into account(accountId, name, number, code)
values (4, 'PPF BANKA A.S.', '0000009503010009', '6000');

-- statements
insert into statement(statementId, number, description, period)
values (1, '196', 'statement1', '2022');
insert into statement(statementId, number, description, period)
values (2, '195', 'statement2', '2022');

-- transaction types
insert into transactionType(trxTypeId, type, code)
values (1, 'DPO', 0);
insert into transactionType(trxTypeId, type, code)
values (2, 'DPO', 1012209);

-- transactions
insert into transation(amount, currency, id, bankRef, transactionId, bookingDate, postingDate, creditDebitIndicatior,
                       ownAccountNumber, counterPartyAccount, detail1, productBankRef, transactionType, statement,
                       specificSymbol, variableSymbol)
values (1594, 'CZK', '20221018:0000003608', 'PS221018SO314645', '4831381',
        DATE '2022-10-18', DATE '2022-10-18', 'DBIT', '2002222222',
        3, 'Platba elektřiny', 'PS221018SO314645', 1, 2,
        '12', '12');
insert into transation(amount, currency, id, bankRef, transactionId, bookingDate, postingDate, creditDebitIndicatior,
                       ownAccountNumber, counterPartyAccount, detail1, productBankRef, transactionType, statement,
                       specificSymbol, variableSymbol)
values (100, 'CZK', '20221018:0000003607', 'PS221018SO314645', '4831425',
        DATE '2022-10-18', DATE '2022-10-18', 'CRDT', '2002222222',
        2, 'Příspěvek', 'PS221018SO314645', 2, 2,
        '12', '12');
insert into transation(amount, currency, id, bankRef, transactionId, bookingDate, postingDate, creditDebitIndicatior,
                       ownAccountNumber, counterPartyAccount, detail1, productBankRef, transactionType, statement,
                       specificSymbol, variableSymbol)
values (2000, 'CZK', '20221019:0000000221', 'PS221019SO314823', '4831700',
        DATE '2022-10-19', DATE '2022-10-19', 'CRDT', '2002222222',
        4, 'Na dárky', 'PS221019SO314823', 2, 1,
        '61', '61');
insert into transation(amount, currency, id, bankRef, transactionId, bookingDate, postingDate, creditDebitIndicatior,
                       ownAccountNumber, counterPartyAccount, detail1, productBankRef, transactionType, statement,
                       specificSymbol, variableSymbol)
values (1999, 'CZK', '20221019:0000000220', 'PS221019SO314822', '4831701',
        DATE '2022-10-19', DATE '2022-10-19', 'CRDT', '2002222222',
        3, 'Trvalý příkaz 8', 'PS221019SO314822', 1, 1,
        '12', '12');
insert into transation(amount, currency, id, bankRef, transactionId, bookingDate, postingDate, creditDebitIndicatior,
                       ownAccountNumber, counterPartyAccount, detail1, productBankRef, transactionType, statement,
                       specificSymbol, variableSymbol)
values (1500, 'CZK', '20221019:0000000219', 'PS221019SO314822', '4831716',
        DATE '2022-10-19', DATE '2022-10-19', 'CRDT', '2002222222',
        3, 'Posílám peníze', 'PS221019SO314822', 2, 1,
        '12', '12');
