Feature: Classwork

  @ScenarioGuru02
  Scenario Outline: TC02 kullanici sutun basligi ile liste alabilmeli

    Given kullanici "guruUrl" anasayfasinda
    And "<Basliklar>" sutunundaki tum degerleri yazdirir
    Examples:
      | Basliklar          |
      | Company            |
      | Group              |
      | Prev Close (Rs)    |
      | Current Price (Rs) |
      | % Change           |

    Scenario: kullanici sayfayi kapatir
      Given sayfayi kapatir
