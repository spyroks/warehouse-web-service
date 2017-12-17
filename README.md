# Projekt aines Veebiteenused (IDU0075)

## Sisukord
* [Sissejuhatus](#sissejuhatus)
* [Teenuse põhiobjektid](#teenuse-põhiobjektid)
  - [Warehouse](#warehouse)
  - [Material](#material)
* [Teenuse põhioperatsioonid](#teenuse-põhioperatsioonid)
  - [Üldine info teenuse kohta](#Üldine-info-teenuse-kohta)
    + [API_TOKEN](#api_token)
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




## Teenuse põhiobjektid
Teenuse põhiobjektid millega tegeletakse on `Warehouse` ja `Material`.
Laos võib olla mitu materjali. Üldine struktuuri jaotus on järgnev:

~~~
Service
├── Warehouse
│   └── Material
└── Material
~~~

Teenuse materjalid võivad kuuluda ladule kuid see pole kohustuslik.





### Warehouse
Teenuse piiredes võivad olla mitu ladusid. Ladule võivad kuuluda mitu materjali. Laoga on ka seotud aadress mille kaudu seda saab leida.

Ladu iseloomustavad järgmised atribuudid:
* **id** - unikaalne numbriline identifikaator, genereeritakse automaatselt süsteemi poolt;
* **warehouseName** - ladu nimi;
* **warehouseAddress**  - ladu aadress;
* **warehouseCapacity**  - ladu ruumala;
* **warehouseArea** - ladu pindala;
* **warehouseMaterialList** - ladule kuuluvaid materjalid.

Näiteks võib olla järgnev ladu:
* **id** - 1
* **warehouseName** - Tallinn Ladu
* **warehouseAddress**  - Kalmistu tee 26
* **warehouseCapacity**  - 500.00 m<sup>3</sup>
* **warehouseArea** - 1000.00 m<sup>2</sup>
* **warehouseMaterialList** - []





### Material
Igal materjalil on nimi ja selle koostis.
Samuti materjalile määratakse selle tugevus (näiteks, akna koostises on klaas seega tugeves - nõrk).
Materjali kood genereeritakse loomisel ja võib! sisaldada informatsiooni.

Materjali iseloomustavad järgmised atribuudid:
* **id** - unikaalne numbriline identifikaator, genereeritakse automaatselt süsteemi poolt;
* **name** - materjali nimetus;
* **code** - materjali kood;
* **composition** - materjali koostis;
* **durability** - materjali tugevus.

Näiteks võib olla järgmine materjal:
* **id** - 5
* **name** - Window 
* **code** - WIN0001TLN20LDU
* **composition** - Glass, plastic
* **durability** - Low

***





## Teenuse põhioperatsioonid
Teenusel põhioperatsioonid mis on nii REST kui SOAP teenusel sarnased. Järgneb nimekiri lühikeste kirjeldustega võimalikest teenustest.

* **Ladu lisamine**
    - Saab lisada ladu
* **Ühe ladu küsimine**
    - Saab küsida andmeid ühe ladu kohta selle id järgi
* **Kõikide ladude küsimine**
    - Saab küsida andmeid kõikide ladude kohta
* **Materjali lisamine**
    - Saab lisada materjali
* **Ühe materjali küsimine**
    - Saab küsida andmeid ühe materjali kohta selle id järgi
* **Kõikide materjalide küsimine**
    - Saab küsida andmeid kõikide materjalide kohta
* **Materjali ladule lisamine**
    - Saab lisada olemasolevat materjali olemasolevasse lattu
* **Ühe ladu kõikide materjalide küsimine**
    - Saab küsida kõikide materjalide nimekiri ja selle andmeid ühe ladu kohta selle id järgi





### Üldine info teenuse kohta


#### API_TOKEN
Teenus kasutab autentimiseks `API_TOKEN`-it. Et saada endale `API_TOKEN` millega saab teenust kasutada tuleb seda küsida teenuse haldurilt.

**Näide:**
* Saadetakse materjali loomise päring `API_TOKEN` salajane
* Teenuses salvestatakse materjal id-ga 1
* Saadetakse materjali loomise päring `API_TOKEN` mittesalajane
* Uut materjali ei looda, sest api token on ebakorrektne
* Saadetakse postituse loomise päring `API_TOKEN` salajane
* Teenuses salvestatakse materjal id-ga 2

***
