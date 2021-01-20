# Payapay-Projek-PBO
Anggota:

1. Aprila Dwi Utami    (1917051012)   apriladwiutami

2. Nur Ayu Octarina    (1917051039)   nurayu1039

3. Fanirizki Sofiyana  (1917051050)   byebyeblue


# Pay Pay System
>Sistem PayPay
 adalah sistem yang digunakan untuk melakukan transaksi pembayaran. terdapat dua jenis akun yaitu personal dan bisnis. satu akun dapat memiliki satu atau lebih kartu.

## Desain
>Untuk melihat diagram, install plugin mermaid-diagram di https://github.com/Redisrupt/mermaid-diagrams
### Class Diagram
```mermaid
classDiagram
    Akun <|-- Personal
    Akun <|-- Bisnis
    Akun "1"--o"*" Card : has

    class Akun{
        <<abstract>>
        #int ID
        #String name
        #String address
        #String email
        #String NoHP
        -double Saldo
        +int nextID()
        +double getSaldo()
    }

    class Personal{
        -double KTP
        -String tgllahir
    }

    class Bisnis{
        -String TelpBisnis
        -String namaBisnis
        -String MataUang
    }

    class Card{
        -double CCN
        -int SecNum
        -String JenisKartu
        -String ExpDate
        -String AlamatPenagihan
        -int SecNum
        +deposit(double amt)
        +withdraw(double amt)  
    }
```
### ER Diagram
```mermaid
erDiagram
        AKUN ||..|| PERSONAL : is 
        AKUN ||--|| BISNIS : is 
        AKUN ||--|{CARD : "has"
        AKUN{
            int id
            string name
            string address
            string email
            string NoHP
            double Saldo
        }
        PERSONAL{
            double KTP
            string tgllahir
        }
        BISNIS{
            string TelpBisnis
            string namaBisnis
            string mataUang
        }
        CARD{
            double CCN
            string JenisKartu
            string ExpDate
            string alamatpenagihan
            int SecNum
        }
```
### Design Class Diagram for JavaFX and Database
```mermaid
classDiagram
    Akun <|-- Personal
    Akun <|-- Bisnis
    Akun "1"--o"*" Card : has 
    Akun o-- PaypayDataModel : Data Modeling 
    PaypayDataModel <-- PaypayController : Data Control 
    PaypayDataModel --> DBHelper : DB Connection 
    PaypayController <.. PaypayForm : Form Control

    class Akun{
        <<abstract>>
        #IntegerProperty ID
        #StringProperty name
        #StringProeprty address
        #StringProperty email
        #StringProperty NoHP
        -DoubleProperty saldo

        +IntegerProperty nextID()
        +DOubleProperty getSaldo()
    }

    class Personal{
        -DoubleProperty KTP
        -StringProperty tgllahir
    }

    class Bisnis{
        -StringProperty TelpBisnis
        -StringProperty namaBisnis
        -StringProperty mataUang
    }

    class Card{
        -DoubleProperty CCN
        -IntegerProperty SecNum
        -StringProperty JenisKartu
        -StringProperty ExpDate
        -StringProperty AlamatPenagihan
        -IntegerProperty SecNum
        +deposit(double amt)
        +withdraw(double amt)
    }

    class PaypayDataModel{
        Connection conn
        addAkun()
        addCard()
        getPersonals()
        getBisniss()
        nextID()
        nextCCN()
    }

    class PaypayController{
        Initialize()
        handleButtonAddCard()
        handleButtonAddAccount()
        loadDataPersonal()
        loadDataBisnis()
        loadDataCard()
        handleClearButton()
    }

    class DBHelper{
        getConnection()
        getConnection(String driver)
        createTable()
    }
    ```
