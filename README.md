# transparent-account

## Spuštění aplikace
src/main/java/ta/transaction obsahuje třídu TransaparenAccountApp

Při spuštění mainu se spustí SpringBoot aplikace a nasadí se swagger na adrese http://localhost:8080/swagger-ui/.

Zde bude viditelný GET endpoint z Transactions Controlleru.

Provolaním endpointu pomocí Postmana či SoapUI vrátí prázné response body se statusem OK, protože použitá H2 databáze není naplněna daty.

## Technologie

Aplikace je napsaná v Javě 17 s použitím SpringBootu 2.5.5, hibernate, springfox 3.0.0 a H2 databází.

Technologie nejsou nejnovější, ovšem verze aplikace se SpringBoot 3.3.5 a springdoc 2.6.0 se mi nepodařilo správně spustit.

## Unit testy

Pro TransactionController jsou vytvořený unit testy pro ověření funkčnosti.

Testovací data jsou vložena pomocí InitDataUtil, kde je využit save z JPA Repository.

(Šlo by vytvořit si vytvořit restovou službu, pro initData a využít InitDataUtil k inicializaci dat. Pak by vytvořená GET služba vracela naplněné body response, jako je v zadání úlohy)

Původně jsem chtěla, aby se data načítala z data.sql v resourses v package pro testy. Bohužel se nepodařilo správně nastavit application.properties, obojí jsem zde nechala na ukázku (snad se dozvím, co jsem udělala špatně pro poučení).

