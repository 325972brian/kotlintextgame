fun main(args: Array<String>) {
    val ANSI_RED = "\u001B[31m"
    val ANSI_RESET = "\u001B[0m"
    val ANSI_CYAN = "\u001b[0;96m"
    val ANSI_PURPLE = "\u001b[35m"
    val ANSI_YELLOW = "\u001b[1;33m"
    val ANSI_VIBRANT_YELLOW = "\u001b[1;93m"
    val ANSI_GREEN = "\u001b[1;92m"

    println("You have been framed for murder and woke up in " + ANSI_PURPLE + "Prison" + ANSI_RESET + ", your goal is to get out of prison as soon as possible.")
    println(ANSI_PURPLE + "Together" + ANSI_RESET + " with your cellmates you got a chance to escape.")
    println("But watch out, there could be " + ANSI_PURPLE + "UNDERCOVERS" + ANSI_RESET + " amongst your cellmates " + ANSI_PURPLE + "he" + ANSI_RESET + " , choose wisely with who you escape with, " + ANSI_CYAN + "and" + ANSI_RESET + " find out who framed you.")

    println("\nWhat is your name?")
    var username = readLine()


    while (username!!.isBlank()) {
        println("Please enter a valid username")
        username = readLine()
    }
    val player = Player("$username", 4, 30)
    // Begin items
    val fistWeapon = Weapon("Fist", 8)
    val fistWeaponItem = Loot("Fist", LootType.WEAPON)

    val cloth = Loot("Inmitate cloth", LootType.ARMOR)
    val redPotion = Loot("Health Potion", LootType.POTION)

    // Collectible items
    val card1 = Loot("Card 1", LootType.KEY)

    val brickItem = Weapon("Brick", 16)
    val brickItemItems = Loot("Brick", LootType.WEAPON)

    // World 2
    val bloodOfdarkness = Weapon("Blood of darkness", 40)
    val bloodOfdarknessItem = Loot("Blood of darkness", LootType.WEAPON)

    val holyBlood = Loot("Holy Blood", LootType.ARTIFACT)
    val holyWater = Loot("Holy Water", LootType.ARTIFACT)

    val key2 = Loot("Key 2", LootType.KEY)


    // Begin Items
    player.inventory.add(cloth)
    player.weapon = fistWeapon
    player.inventory.add(redPotion)
    player.inventory.add(fistWeaponItem)

    // Begin var
    var level1 = true
    var card1Data = false
    var mummyBoss = true
    // World 2
    var level12 = true
    var level22 = true
    var level32 = true

    // Enemies
    val zombie = James("James", 10, 1, 5)

    // World 2
    val guard1 = Enemy("Guard", 10, 1, 5)
    val guard2 = Enemy("Guard", 10,2, 4)
    val officer = Enemy("Officer", 18, 2, 4)


    // Game start
    println("So $username started his plan to escape prison")

    println("\n\n$username You just woke up in " + ANSI_PURPLE + "Prison" + ANSI_RESET + " , your plan is to" + ANSI_RED + "\nknock out a bodyguard together with one of your cellmates" + ANSI_RESET)
    println("Press enter to continue text")
    readLine()

    println("\nYou want to tell someone you're plan on escaping prison, who do you talk to?")
    println("Type 1 to talk to James")
    println("Type 2 to talk to Michael")
    println("Type 3 to talk to Kennen")


    //------------------End of the start------------------
    var playing = true
    var world = 1
    while (world == 1) {

        fun level1() {
            println("James is suspicious and is ready to knock $username out!\nPrepare for combat.")
            println("Type in 1 to fight.")
            while (level1) {
                var fight = readLine()
                if (fight == "1") {
                    zombie.takeDamage(player.weapon.damageInflicted)
                    if (zombie.lives < 1) {
                        println("James is defeated by $username.")
                        println(ANSI_GREEN + "Hmmm what is this " + ANSI_CYAN + "$username" + ANSI_GREEN + " picked up an 'Brick'" + ANSI_RESET)
                        player.weapon = brickItem
                        player.inventory.add(brickItemItems)
                        println("Press enter to ask someone else")
                        readLine()
                        level1 = false
                    } else {
                        player.takeDamage(zombie.damageInflicted)
                    }
                } else {
                    println("Sorry I didn't quite catch that, type in 1 to hit the enemy")
                }
            }
        }

        fun level2() {
            println(ANSI_YELLOW + "Michael is willing to help escape if" + ANSI_RESET + "\n$username" + ANSI_YELLOW + " solves this math question...")
            while (mummyBoss) {
                println(ANSI_YELLOW + "To get Michael to help you have to solve this math question,")
                println(ANSI_VIBRANT_YELLOW + "what is the answer to: 56+14+31")
                var choosemummy = readLine()
                if (choosemummy == "101") {
                    println(ANSI_GREEN + "That's correct, Michael will now help you")
                    println(ANSI_RESET + "You picked up a card, talk to kennen...")
                    mummyBoss = false
                    player.inventory.add(card1)
                    card1Data = true
                    println("Press enter to leave the room")
                    readLine()
                } else {
                    println(ANSI_RED + "Oh no! That's the wrong answer, try again")
                    println(ANSI_VIBRANT_YELLOW + "before Michael changes his mind!\n")
                }

            }


        }

        fun level3() {
            if (card1Data != true) {
                println("Kennen won't help you without a card")
                println("Choose another option!")
            } else {
                println("You're entering the hallway...")
                world = 2
            }
        }

        fun repeatText1() {
            println("\nYou want to tell someone you're plan on escaping prison, who do you talk to?")
            println("Type 1 to talk to James")
            println("Type 2 to talk to Michael")
            println("Type 3 to talk to Kennen")
        }


        val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

        when (userInput.first()) {
            "QUIT", "EXIT", "Q" -> System.exit(0)
            "1" -> level1()
            "2" -> level2()
            "3" -> level3()
            "HELP" -> showHelp()
            "INVENTORY", "INV" -> player.showInventory()
            "AGAIN" -> repeatText1()

            "INVENTORY", "INV" -> player.showInventory()
            else -> {
                println("You can type in 'help' to see a list of commands")
            }
        }
    }


//world 2

    println("There is a foul smell down here in the basement, this time there are three rooms.\nOne in front of you which reeks of blood.\nOne right of you, it looks like a torture chamber.")
    println("And one left of you, it smells like hell.") // fix text
    println("\nType 1 for the door on the left.\nType 2 for the door on the right. \nType 3 for the door in front of you.")
    while (world == 2) {

        fun level12() {
            println("You see an skeleton, prepare to fight.")
            println("Type in 1 to fight.")
            while (level12) {
                var fight = readLine()
                if (fight == "1") {
                    guard1.takeDamage(player.weapon.damageInflicted)
                    if (guard1.lives < 1) {
                        println("The guard is defeated by $username.")
                        println(ANSI_GREEN + "Hmmm what is this " + ANSI_CYAN + "$username" + ANSI_GREEN + " took the red glowing sword " + ANSI_RED + "'Blood of darkness'" + ANSI_RESET)
                        println(ANSI_CYAN + "An demon weapon against demons this might work." + ANSI_RESET)
                        player.weapon = bloodOfdarkness
                        player.inventory.add(bloodOfdarknessItem)
                        println("Press enter to leave the room")
                        readLine()

                        level12 = false
                    } else {
                        player.takeDamage(guard1.damageInflicted)
                    }
                } else {
                    println("The player typed something that doesn't work maybe type in 1 to hit the enemy.")
                }

            }
        }

        fun level22() {
            println(
                "There is an human in the room $username looked closer " +
                        ANSI_CYAN + "'By the gods what has " + ANSI_PURPLE + "Bladimir" + ANSI_CYAN + " done to him.'" + ANSI_RESET +
                        "\nSuddenly the mutilated corpse woke up and came towards $username"
            )
            while (level22) {
                var fight = readLine()
                if (fight == "1") {
                    guard2.takeDamage(player.weapon.damageInflicted)
                    if (guard2.lives < 1) {
                        println("The guard is defeated by $username.")
                        println(ANSI_CYAN + "$username" + ANSI_GREEN + " took the health potion'" + ANSI_RESET)
                        println(ANSI_CYAN + "Dammit this can't be allowed to exist may the gods look over him, BLADMIR YOUR NEXT!!!!" + ANSI_RESET)
                        println("$username left the room in anger")
                        player.inventory.add(redPotion)
                        println("Press enter to leave the room")
                        readLine()

                        level22 = false
                    } else {
                        player.takeDamage(guard2.damageInflicted)
                    }
                } else {
                    println("MMMMmmm it seems this doesn't work maybe type in 1 to hit the enemy.")
                }

            }

        }

        fun level32() {
            println("It reeks of blood but somehow you feel a holy presence in the room. \nThere are two pedestals, one with Holy Water and one with Holy Blood.")
            println("$username grabbed the Holy Blood.")
            player.inventory.add(holyBlood)
            println("Press enter to continue text")
            readLine()
            println("Suddenly an angel appeared 'You dare take the Holy Blood of Hesus, are you worthy to take on evil?'\n'I SHALL TEST YOU MORTAL!!!'")
            while (level32) {
                var fight = readLine()
                if (fight == "1") {
                    officer.takeDamage(player.weapon.damageInflicted)
                    if (officer.lives < 1) {
                        println("Officer is defeated by $username")
                        println("Very well mortal I shall let you take the Holy water and the Holy blood but if you fail I will make you feel my wrath!")
                        println("$username got the Holy Water")
                        player.inventory.add(holyWater)
                        println("\n$username found an key in the room he picked it up.\nSuddenly a trap door opened from below and he fell trough it.")
                        player.inventory.add(key2)
                        println("You're entering the 2nd floor.")
                        println("Press enter to continue")
                        readLine()

                        level32 = false
                        world = 3
                    } else {
                        player.takeDamage(officer.damageInflicted)
                    }
                } else {
                    println("Hey player that command doesn't work try typing in 1 to fight")
                }

            }

        }

        fun repeatText2() {
            println("\nType 1 for the door on the left.\nType 2 for the door on the right\nType 3 for the door in front of you")
        }


        val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

        when (userInput.first()) {
            "QUIT", "EXIT", "Q" -> System.exit(0)
            "1" -> level12()
            "2" -> level22()
            "3" -> level32()
            "HELP" -> showHelp()
            "INVENTORY", "INV" -> player.showInventory()
            "AGAIN" -> repeatText2()
            else -> {
                println("You can type in 'help' to see a list of commands")
            }
        }
    }
//////////// World 3 ////////////
    while (world == 3) {
        println("END OF DEMO")

        fun repeatText3() {
            println("Oeps no spoilers here (¬‿¬)")
        }

        val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

        when (userInput.first()) {
            "QUIT", "EXIT", "Q" -> System.exit(0)
//            "1" -> level12()
//            "2" -> level22()
//            "3" -> level32()
            "HELP" -> showHelp()
            "INVENTORY", "INV" -> player.showInventory()
            "AGAIN" -> repeatText3()
            else -> {
                println("You can type in 'help' to see a list of commands")
            }
        }
    }

}

fun playerInput(): String {
    var input: String? = null
    while (input == null) {
        print("> ")
        input = readLine()
    }
    return input.toLowerCase()
}

//test

fun showHelp() {
    println("-------------------------------------------")
    println("Type q, exit or quit to quit the game.")
    println("\nYou can right click and clear all text.")
    println("\nType in inventory or inv to see your inventory.")
    println("\nType in again to repeat the room guide text.")
    println("--------------------TIPS-------------------")
    println("\nYou automatically use the best weapon in your inventory.")
    println("-------------------------------------------")
}