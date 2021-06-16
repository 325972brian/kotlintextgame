open class Enemy (val name: String, var hitpoints: Int, var lives: Int, var damageInflicted: Int) {

    fun takeDamage(damage: Int) {
        val remainingHitpoints = hitpoints - damage
        if (remainingHitpoints > 0) {
            hitpoints = remainingHitpoints
            println("$name took $damage points of damage and has $hitpoints hitpoints left.")
        } else {
            if (lives > 0) {
                lives -= 1
                println("$name has lost a life.")
            } else {
                println("$name is dead,")
            }
        }
    }

    override fun toString(): String {
        return "Name: $name, Hitpoints: $hitpoints, Lives: $lives"
    }
}