# Projekt aines Veebiteenused (IDU0075)

## Sisukord
* [Sissejuhatus](#sissejuhatus)
* [Teenuse põhiobjektid](#teenuse-põhiobjektid)
  - [Warehouse](#warehouse)
  - [Material](#material)
* [Teenuse põhioperatsioonid](#teenuse-põhioperatsioonid)
  - [Üldine info teenuse kohta](#Üldine-info-teenuse-kohta)
    + [API_TOKEN](#api_token)
    + [Päringu ID](#päringu-id)
* [SOAP API kirjeldus](#soap-api-kirjeldus)
  - [SOAP API Operatsioonid](#soap-api-operatsioonid)
  - [SOAP API Operatsioonide kirjeldused](#soap-api-operatsioonide-kirjeldused)
* [REST API kirjeldus](#rest-api-kirjeldus)
  - [REST API Operatsioonid](#rest-api-operatsioonid)
  - [REST API Operatsioonide kirjeldused](#rest-api-operatsioonide-kirjeldused)





## Sissejuhatus
Antud dokumentatsioonis on kirjeldatud aine Veebiteenused projekti teenust. Projekti tulemuseks on ladu SOAP ja REST teenus (`WarehouseWebService`), klientrakendus ning dokumentatsioon.

Teenus on realiseeritud kasutades [Netbeansi](https://netbeans.org) ning [Glassfishi serverit](https://glassfish.java.net). Teenuse rakendus asub kaustas `WarehouseWebApplication` ja klientrakendus asub kaustas `WarehouseApplication`.

Teenust kasutades saab lisada ja vaadata ladusid ja nende materjale.

**Autor**: Denis Rästas 155552IAPB

***
