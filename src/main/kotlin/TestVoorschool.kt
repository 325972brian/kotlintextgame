///*
////fun main() {
////    val name = "Derik"
////    val lives = 2
////    val hitpoints = 300
////
////
/////////// Player script
////    open fun takeDamage(damage: Int) {
////        val remainingHitpoints = hitpoints - damage
////        if (remainingHitpoints > 0 ) {
////            hitpoints = remainingHitpoints
////            println("$name took $damage points of damage and has $hitpoints hitpoints lefgt")
////        } else {
////            if (lives < 1) {
////                lives -= 1
////                println("$name lost a life")
////            } else {
////                println ("$name is dead! $name has no more lives left")
////            }
////        }
////    }
////
////
////
////    fun runAway() : Boolean {
////        if (lives < 2) {
////            return true
////        } else {
////            return false
////        }
////    }
////// idiomatic if else kotlin
////    fun runAway2() : Boolean {
////    return lives < 2
////    }
////
//
//    open fun attack(player: Player, minDamage: Int, maxDamage: Int, attackTurns: Int){
//        var numberofAttacks = attackTurns
//        while (numberofAttacks != 0) {
//            val attackDamage = (minDamage..maxDamage).random()
//            player.takeDamage(attackDamage)
//            println("$username's took $attackDamage points of damage!")
//            numberofAttacks -= 1
//////            Thread.sleep(800)
//        }
//    }
//
//
////
////}*/
