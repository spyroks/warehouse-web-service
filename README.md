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

Teenust kasutades saab lisada ja vaadata laod ja nende materjale.

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
Teenuse piiredes võivad olla mitu laod. Ladule võivad kuuluda mitu materjali. Laoga on ka seotud aadress mille kaudu seda saab leida.

Ladu iseloomustavad järgmised atribuudid:
* **id** - unikaalne numbriline identifikaator, genereeritakse automaatselt süsteemi poolt;
* **warehouseName** - ladu nimi;
* **warehouseAddress**  - ladu aadress;
* **warehouseCapacity**  - ladu ruumala;
* **warehouseArea** - ladu pindala;
* **warehouseMaterialList** - ladule kuuluvaid materjalid.

Näiteks võib olla järgnev ladu:
* **id** - 1;
* **warehouseName** - Tallinn Ladu;
* **warehouseAddress**  - Kalmistu tee 26;
* **warehouseCapacity**  - 500.00 m<sup>3</sup>;
* **warehouseArea** - 1000.00 m<sup>2</sup>;
* **warehouseMaterialList** - [].





### Material
Igal materjalil on nimi ja selle koostis.
Samuti materjalile määratakse selle tugevus (näiteks, akna koostises on klaas seega tugeves - nõrk).
Materjali kood genereeritakse loomisel tehases ja *võib!* sisaldada informatsiooni.

Materjali iseloomustavad järgmised atribuudid:
* **id** - unikaalne numbriline identifikaator, genereeritakse automaatselt süsteemi poolt;
* **name** - materjali nimetus;
* **code** - materjali kood;
* **composition** - materjali koostis;
* **durability** - materjali tugevus.

Näiteks võib olla järgmine materjal:
* **id** - 5;
* **name** - Window;
* **code** - WIN0001TLN20LDU;
* **composition** - Glass, plastic;
* **durability** - Low.

***





## Teenuse põhioperatsioonid
Teenusel põhioperatsioonid mis on nii REST kui SOAP teenusel sarnased. Järgneb nimekiri lühikeste kirjeldustega võimalikest teenustest.

* **Ladu lisamine**
    - Saab lisada ladu.
* **Ühe ladu küsimine**
    - Saab küsida andmeid ühe ladu kohta selle id järgi.
* **Kõikide ladude küsimine**
    - Saab küsida andmeid kõikide ladude kohta.
* **Materjali lisamine**
    - Saab lisada materjali.
* **Ühe materjali küsimine**
    - Saab küsida andmeid ühe materjali kohta selle id järgi.
* **Kõikide materjalide küsimine**
    - Saab küsida andmeid kõikide materjalide kohta.
* **Materjali ladule lisamine**
    - Saab lisada olemasolevat materjali olemasolevasse lattu.
* **Ühe ladu kõikide materjalide küsimine**
    - Saab küsida kõikide materjalide nimekiri ja selle andmeid ühe ladu kohta selle id järgi.





### Üldine info teenuse kohta

#### API_TOKEN
Teenus kasutab autentimiseks `API_TOKEN`-it. Et saada endale `API_TOKEN` millega saab teenust kasutada tuleb seda küsida teenuse haldurilt.

**Näide:**
* Saadetakse materjali loomise päring `API_TOKEN` salajane.
* Teenuses salvestatakse materjal id-ga 1.
* Saadetakse materjali loomise päring `API_TOKEN` mittesalajane.
* Uut materjali ei looda, sest api token on ebakorrektne.
* Saadetakse postituse loomise päring `API_TOKEN` salajane.
* Teenuses salvestatakse materjal id-ga 2.

***





## SOAP API kirjeldus
API on ligipääsetav aadressil `(hostname)/WarehouseWebApplication/WarehouseService`.
API kasutatav WSDL fail asub teenuse kaustas `src/conf/xml-resources/web-services/WarehouseWebService/wsdl/WarehouseService.wsdl` ning on saadaval ka *deploy*itud rakenduse URIle lisades `?wsdl` ehk `(hostname)/WarehouseWebApplication/WarehouseService?wsdl`.

### SOAP API Operatsioonid
SOAP teenuses on võimalikud järgmised operatsioonid:
* [addWarehouse](#addwarehouse)
* [getWarehouse](#getwarehouse)
* [getWarehouseList](#getwarehouselist)
* [addMaterial](#addmaterial)
* [getMaterial](#getmaterial)
* [getMaterialList](#getmateriallist)
* [addWarehouseMaterial](#addwarehousematerial)
* [getWarehouseMaterialList](#getwarehousemateriallist)

### SOAP API Operatsioonide kirjeldused
Järgnevad SOAP teenuse operatsioonide kirjeldused.

Iga päring peab sisaldama korrektne `API_TOKEN`.





#### addWarehouse
Ladu lisamise operatsioon. Saab lisada ladu millel on nimi ja aadress, selle ruumala ja pindala.

##### Sisendandmete kirjeldus
Väljad päringus andmetüüpidega on järgnevad:
* `Warehouse`
    - `warehouseName` - `string`, ladu nimi;
    - `warehouseAddress` - `string`, ladu aadress;
    - `warehouseCapacity` - `double`, valiidne ladu ruumala (näiteks, 615.12 või 843 m<sup>3</sup>);
    - `warehouseArea` - `double`, valiidne ladu pindala (näiteks, 3333.334 või 1500 m<sup>2</sup>).

###### Näidis SOAP päring (request)
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:war="http://www.ttu.ee/idu0075/warehouse">
   <soapenv:Header/>
   <soapenv:Body>
      <war:addWarehouseRequest>
         <war:token>salajane</war:token>
         <war:warehouseName>Tallinn Ladu</war:warehouseName>
         <war:warehouseAddress>Kalmistu tee 26</war:warehouseAddress>
         <war:warehouseCapacity>500</war:warehouseCapacity>
         <war:warehouseArea>1000</war:warehouseArea>
      </war:addWarehouseRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Väljundandmete kirjeldus
Väljad vastuses andmetüüpidega on järgnevad:
* `Warehouse`
    - `id` - `integer`, loodud ladu unikaalne identifikaator, genereeritakse süsteemi poolt;
    - `warehouseName` - `string`, loodud ladu nimi;
    - `warehouseAddress` - `string`, loodud ladu aadress;
    - `warehouseCapacity` - `double`, loodud ladu ruumala;
    - `warehouseArea` - `double`, loodud ladu pindala;
    - `warehouseMaterialList` - `warehouseMaterialListType`, tühi materjalide nimekiri.

###### Näidis SOAP vastus (response)
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <addWarehouseResponse xmlns="http://www.ttu.ee/idu0075/warehouse">
         <id>1</id>
         <warehouseName>Tallinn Ladu</warehouseName>
         <warehouseAddress>Kalmistu tee 26</warehouseAddress>
         <warehouseCapacity>500.0</warehouseCapacity>
         <warehouseArea>1000.0</warehouseArea>
         <warehouseMaterialList/>
      </addWarehouseResponse>
   </S:Body>
</S:Envelope>
~~~





#### getWarehouse
Ladu küsimise operatsioon. Ladu saab otsida selle unikaalse identifikaatori ehk `id` järgi.

##### Sisendandmete kirjeldus
Päringus on ainult üks väärtus:
* `id` - `integer`, küsitava ladu id.

###### Näidis SOAP päring (request)
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:war="http://www.ttu.ee/idu0075/warehouse">
   <soapenv:Header/>
   <soapenv:Body>
      <war:getWarehouseRequest>
         <war:token>salajane</war:token>
         <war:id>1</war:id>
      </war:getWarehouseRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Väljundandmete kirjeldus
Väljad vastuses andmetüüpidega on järgnevad:
* `Warehouse`
    - `id` - `integer`, küsitava ladu unikaalne identifikaator, genereeritakse süsteemi poolt;
    - `warehouseName` - `string`, küsitava ladu nimi;
    - `warehouseAddress` - `string`, küsitava ladu aadress;
    - `warehouseCapacity` - `double`, küsitava ladu ruumala;
    - `warehouseArea` - `double`, küsitava ladu pindala;
    - `warehouseMaterialList` - `warehouseMaterialListType`, küsitava ladu materjalide nimekiri. Kui laos pole materjale siis see on tühi, vastupidisel juhul tagastab materjale mis kuuluvad sellele ladule.

###### Näidis SOAP vastus (response)
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <getWarehouseResponse xmlns="http://www.ttu.ee/idu0075/warehouse">
         <id>1</id>
         <warehouseName>Tallinn Ladu</warehouseName>
         <warehouseAddress>Kalmistu tee 26</warehouseAddress>
         <warehouseCapacity>500.0</warehouseCapacity>
         <warehouseArea>1000.0</warehouseArea>
         <warehouseMaterialList/>
      </getWarehouseResponse>
   </S:Body>
</S:Envelope>
~~~





#### getWarehouseList
Kõikide ladude küsimise operatsioon. Operatsioonil on olemas mittekohustuslik (`optional`) päringu parameeter. See parameeter toimib nagu küsimise sorteerija. Vastuseks tagastatakse kõik laod selle parameetri järgi.

##### Sisendandmete kirjeldus
Päringus on ainult üks väärtus:
* `hasRelatedMaterials` - `string`, küsimise sorteerija piiranguga (`restiction`). Ainus vastuvõetav väärtus on `jah` või `ei`. Pannes `jah` tagastab kõik laod millel on materjalid, `ei` - kõik tühjad laod. Kui jätta tühjaks siis sorteerimine ei toimu ning tagastatakse kõik laod.

###### Näidis SOAP päring (request)
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:war="http://www.ttu.ee/idu0075/warehouse">
   <soapenv:Header/>
   <soapenv:Body>
      <war:getWarehouseListRequest>
         <war:token>salajane</war:token>
         <!--Optional:-->
         <war:hasRelatedMaterials>ei</war:hasRelatedMaterials>
      </war:getWarehouseListRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Väljundandmete kirjeldus
Vastuseks on nimekiri salvestatud ladudest. Väljad vastuses andmetüüpidega on järgnevad:
* `Warehouses` - Nimekiri ladudest.
    - `Warehouse` - Üks ladu, langeb kokku [getWarehouse operatsiooni](#getwarehouse) vastusega:
        + `id` - `integer`;
        + `warehouseName` - `string`;
        + `warehouseAddress` - `string`;
        + `warehouseCapacity` - `double`;
        + `warehouseArea` - `double`.

###### Näidis SOAP vastus (response)
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <getWarehouseListResponse xmlns="http://www.ttu.ee/idu0075/warehouse">
         <warehouse>
            <id>1</id>
            <warehouseName>Tallinn Ladu</warehouseName>
            <warehouseAddress>Kalmistu tee 26</warehouseAddress>
            <warehouseCapacity>500.0</warehouseCapacity>
            <warehouseArea>1000.0</warehouseArea>
            <warehouseMaterialList/>
         </warehouse>
         <warehouse>
            <id>2</id>
            <warehouseName>Laki Ladu</warehouseName>
            <warehouseAddress>Suur-Sõjamäe 33a</warehouseAddress>
            <warehouseCapacity>615.12</warehouseCapacity>
            <warehouseArea>3333.34</warehouseArea>
            <warehouseMaterialList/>
         </warehouse>
      </getWarehouseListResponse>
   </S:Body>
</S:Envelope>
~~~





#### addMaterial
Materjali lisamise operatsioon. Saab lisada materjali millel on nimi ja kood, selle koostis ja tugevus.

##### Sisendandmete kirjeldus
Väljad päringus andmetüüpidega on järgnevad:
* `Material`
    - `name` - `string`, materjali nimi;
    - `code` - `string`, materjali kood. Kood genereeritakse loomisel tehases ja *võib!* sisaldada informatsiooni;
    - `composition` - `string`, materjali koostis (näiteks, aken koosneb klaasist ja plastikust);
    - `durability` - `string`, materjali tugevus (näiteks, akna koostises on klaas seega tugeves - nõrk).

###### Näidis SOAP päring (request)
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:war="http://www.ttu.ee/idu0075/warehouse">
   <soapenv:Header/>
   <soapenv:Body>
      <war:addMaterialRequest>
         <war:token>salajane</war:token>
         <war:name>Window</war:name>
         <war:code>WIN0001TLN20LDU</war:code>
         <war:composition>Glass, plastic</war:composition>
         <war:durability>Low</war:durability>
      </war:addMaterialRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Väljundandmete kirjeldus
Väljad vastuses andmetüüpidega on järgnevad:
* `Material`
    - `id` - `integer`, loodud materjali unikaalne identifikaator, genereeritakse süsteemi poolt;
    - `name` - `string`, loodud materjali nimi;
    - `code` - `string`, loodud materjali kood;
    - `composition` - `string`, loodud materjali koostis;
    - `durability` - `string`, loodud materjali tugevus.

###### Näidis SOAP vastus (response)
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <addMaterialResponse xmlns="http://www.ttu.ee/idu0075/warehouse">
         <id>1</id>
         <name>Window</name>
         <code>WIN0001TLN20LDU</code>
         <composition>Glass, plastic</composition>
         <durability>Low</durability>
      </addMaterialResponse>
   </S:Body>
</S:Envelope>
~~~





#### getMaterial
Materjali küsimise operatsioon. Materjali saab otsida selle unikaalse identifikaatori ehk `id` järgi.

##### Sisendandmete kirjeldus
Päringus on ainult üks väärtus:
* `id` - `integer`, küsitava materjali id.

###### Näidis SOAP päring (request)
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:war="http://www.ttu.ee/idu0075/warehouse">
   <soapenv:Header/>
   <soapenv:Body>
      <war:getMaterialRequest>
         <war:token>salajane</war:token>
         <war:id>1</war:id>
      </war:getMaterialRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Väljundandmete kirjeldus
Väljad vastuses andmetüüpidega on järgnevad:
* `Material`
    - `id` - `integer`, küsitava materjali unikaalne identifikaator, genereeritakse süsteemi poolt;
    - `name` - `string`, küsitava materjali nimi;
    - `code` - `string`, küsitava materjali kood;
    - `composition` - `string`, küsitava materjali koostis;
    - `durability` - `string`, küsitava materjali tugevus.

###### Näidis SOAP vastus (response)
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <getMaterialResponse xmlns="http://www.ttu.ee/idu0075/warehouse">
         <id>1</id>
         <name>Window</name>
         <code>WIN0001TLN20LDU</code>
         <composition>Glass, plastic</composition>
         <durability>Low</durability>
      </getMaterialResponse>
   </S:Body>
</S:Envelope>
~~~





#### getMaterialList
Kõikide materjalide küsimise operatsioon. Vastuseks tagastatakse kõik materjalid.

##### Sisendandmete kirjeldus
Päringus peale `API_TOKEN`-i väärtuseid ei ole.

###### Näidis SOAP päring (request)
~~~xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:war="http://www.ttu.ee/idu0075/warehouse">
   <soapenv:Header/>
   <soapenv:Body>
      <war:getMaterialListRequest>
         <war:token>salajane</war:token>
      </war:getMaterialListRequest>
   </soapenv:Body>
</soapenv:Envelope>
~~~

##### Väljundandmete kirjeldus
Vastuseks on nimekiri salvestatud materjalidest. Väljad vastuses andmetüüpidega on järgnevad:
* `Materials` - Nimekiri materjalidest.
    - `Material` - Üks materjal, langeb kokku [getMaterial operatsiooni](#getmaterial) vastusega.
        + `id` - `integer`;
        + `code` - `string`;
        + `name` - `string`;
        + `composition` - `string`;
        + `durability` - `string`.

###### Näidis SOAP vastus (response)
~~~xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <getMaterialListResponse xmlns="http://www.ttu.ee/idu0075/warehouse">
         <material>
            <id>1</id>
            <name>Window</name>
            <code>WIN0001TLN20LDU</code>
            <composition>Glass, plastic</composition>
            <durability>Low</durability>
         </material>
         <material>
            <id>2</id>
            <name>Door</name>
            <code>DOO0001LAK33LDU</code>
            <composition>Wood</composition>
            <durability>Medium</durability>
         </material>
      </getMaterialListResponse>
   </S:Body>
</S:Envelope>
~~~
