class Player(val name: String, var lives: Int = 3, var hitpoints: Int = 30){
             var weapon: Weapon = Weapon("fists",10)
             val inventory = ArrayList<Loot>()

    fun show()
    {
        if(lives < 0){
            println("$name is dead!")
        }else{
            println("$name is alive!")
        }
    }

    override  fun toString(): String {
        return  """
            name:  $name
            life:  $lives
            hitpoints: $hitpoints
            weaponName: ${weapon.name}
            weaponDamage: ${weapon.damageInflicted}
                """
    }

    fun showInventory()
    {
        println("======================================\n")
        println("$name's Inventory:")
        for (InventoryItem in inventory){
            println(InventoryItem)
        }
        println("\n======================================\n")
    }

    open fun takeDamage(damage: Int) {
        val remainingHitpoints = hitpoints - damage
        if (remainingHitpoints > 0 ) {
            hitpoints = remainingHitpoints
            println("$name took $damage points of damage and has $hitpoints hitpoints left")
        } else {
            if (lives < 1) {
                lives -= 1
                println("$name lost a life")
            } else {
                println ("$name is dead! $name has no more lives left")
            }
        }
    }
}