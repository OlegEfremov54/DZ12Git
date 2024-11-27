//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
internal var remontTelefon =0
var sumsung:Int=50
var apple:Int=100
var hyavey:Int=500
var shopMos= mutableListOf(Telefon("Самсунг",10,10000),
    Telefon("Эпл",5,150000),
    Telefon("Хуавей",15,60000))

var shopPit= mutableListOf(Telefon("Самсунг",5,15000),
    Telefon("Эпл",5,110000),
    Telefon("Хуавей",1,70000))
var seylP:MutableList<Telefon> = mutableListOf()
var seylM:MutableList<Telefon> = mutableListOf()
var ostatok:Int=sumsung+apple+hyavey
var skladSbyt:Int=sumsung+apple+hyavey
var seyl:Int=0
var shop1:Shop=ShopMoskow("Москва", true,shopMos,seylM)
var shop2:Shop=ShopPiter("Питер",false,shopPit,seylP)
fun main() {
    do {
        var status: Int = 0
        ostatok=skladSbyt -seyl
        println("Приветствую Вас в сети продаж и ремонта Телефонов *Ух!Позвоню*")
        println("Всего в сети есть готовых к продаже телефонов:" + ostatok)
        println("Продано: "+seyl)
        println("Отремонтировано: " + remontTelefon)
        println("Выберите что будем делать? ")
        println("1- Покупать телефон")
        println("2 - Ремонтировать телефон")
        println("3 - Выход из программы")
        status = readln().toInt()
        when (status) {
            1 -> {println("1")
                chooseCity()?.sely()
            seyl=seyl+1
            }
            2 -> {println("2")
                chooseCity()?.remontTelefInfo()
            }
            3 -> break
        }
    }
        while (status != 3)
        println("")
        println("Выход из программы.")
    println("Всего за время работы программы продано:"+seyl)
    println("Отремонтировано: "+remontTelefon)
    println("Остатки на складах")
    shop1.volumeCkladPrint()
    shop1.volumeSeylPrint()
    shop2.volumeCkladPrint()
    shop2.volumeSeylPrint()

}

fun  chooseCity(): Shop? {
    var chusShop:Int=0
    println("Выберите магазин")
    println("1- Москва, 2- Питер")
    var choosShop: Shop? =null
    chusShop=readln().toInt()
    when (chusShop) {
        1 -> {choosShop= shop1 }
        2 -> {choosShop= shop2 }
        else -> println("Не корректный выбор города")
    }
    return choosShop
}


