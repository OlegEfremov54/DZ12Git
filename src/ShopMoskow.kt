class ShopMoskow(name:String, remont: Boolean, cklad: MutableList<Telefon>, seyl: MutableList<Telefon>,):
    Shop(name, remont, cklad, seyl) {
    override var name="Москва"
    override fun choosePhoneModel() {
        println("")
    }
    override fun welcome() {
        println("Вас приветствует магазин $name!!!")
    }
}