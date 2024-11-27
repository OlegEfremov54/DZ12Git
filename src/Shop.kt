abstract class Shop(open var name:String, var remont:Boolean, var cklad:MutableList<Telefon>, var seyl:MutableList<Telefon>):TelefonShop {
    override fun toString(): String ="Магазин $name, проводит ремонт$remont "

    fun volumeCkladPrint() {
        println("    В магазине $name имеются на складе следующие телефоны")
        var totalPrice: Int = 0
        var lokalPrice: Int = 0
        var lokalCount: Int = 0
        var tele: Telefon? = null
        for (i in cklad.indices) {
            tele = cklad[i]
            lokalPrice = tele.count * tele.prise
            totalPrice = totalPrice + lokalPrice
            println("Марка ${tele.name} код продажи "+i+", в количестве ${tele.count}, по цене ${tele.prise}, на сумму " + lokalPrice)
            lokalCount = lokalCount + tele.count
        }
        println("")
        println("Всего в магазине " + cklad.size + " марок телефонов, в количестве " + lokalCount + " , на сумму " + lokalPrice)
        println("-------------------------------")
    }

    fun volumeSeylPrint() {
        println("    В магазине $name уже продано")
        var totalPrice: Int = 0
        var lokalPrice: Int = 0
        var lokalCount: Int = 0
        var tele: Telefon? = null
        for (i in seyl.indices) {
            tele = seyl[i]
            lokalPrice = tele.count * tele.prise
            totalPrice = totalPrice + lokalPrice
            println("[Марка ${tele.name}  продано штук  ${tele.count}, по цене ${tele.prise}")
            lokalCount = lokalCount + tele.count
        }
        println("")
        println("Всего в магазине уже  продано " + seyl.size + "  телефонов, в количестве " + lokalCount + " , на сумму " + lokalPrice)
        println("-------------------------------")
    }
    fun sely(){
        volumeCkladPrint()
        var kod:Int=0
        var rem:Int=0
    println("Выберите телефон указав его код продажи")
        kod= readln().toInt()
        if (0<kod && kod<cklad.size){
            var a:Telefon=Telefon("${cklad[kod.toInt()].name}", count = 1, prise = cklad[kod.toInt()].prise)
            seyl.add(a)
            cklad[kod.toInt()].count =cklad[kod.toInt()].count-1
            println("Поздрвляю! Вы купили телефон "+a.toString())
            println("*************")
            println("Ремонтировать что то будем? 1- Да, 2- Нет")
                rem=readln().toInt()
                when (rem){
                    1-> remontTelefInfo()
                    2-> println("Прекрасно что все исправно!")
                }
                println("Магазин $name прощается с вами")
            println("+++++++++++++++++++++++")

        }else {
            println("Такого кода нет")
        }
    }

    fun volumeCkladInfoCount(): Int {
        var lokalCount:Int=0
        var tele: Telefon? =null
        for (i in cklad.indices){
            tele=cklad[i]
            lokalCount=lokalCount+tele.count
        }
        return lokalCount
    }
    fun volumeCkladInfoPrise(): Int {
        var totalPrice:Int=0
        var lokalPrice:Int=0
        var lokalCount:Int=0
        var tele: Telefon? =null
        for (i in cklad.indices){
            tele=cklad[i]
            lokalPrice=tele.count*tele.prise
            totalPrice=totalPrice+lokalPrice
            lokalCount=lokalCount+tele.count
        }
        return totalPrice
    }

    fun remontTelefInfo(){
        if (remont){
            println("Магазин проводит ремонт телефонов")
            remontTelefon=remontTelefon+1
            println("Ваш телефон отремонтирован")
            println("")
        } else {
            println("Магазин не проводит ремонта телефонов")
        }
    }
    override fun welcome() {
        println("Вас приветствует магазин $name!!!")
    }

    override fun showStatistics() {
        volumeCkladPrint()
    }
    override fun  chooseCity() {
        volumeSeylPrint()
    }
    override fun  choosePhoneModel() {
        sely()
    }
}