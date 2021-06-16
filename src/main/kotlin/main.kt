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
                        println("Press enter to leave the cell")
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



        val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

        when (userInput.first()) {
            "QUIT", "EXIT", "Q" -> System.exit(0)
            "1" -> level1()
            "2" -> level2()
            "3" -> level3()

            "INVENTORY", "INV" -> player.showInventory()
            else -> {
                println("You can type in 'help' to see a list of commands")
            }
        }
    }
}
fun repeatText1() {
    println("\nThere are 3 doors one on your left, one on the right and one at the end of the hallway.")
    println("Type 1 for the door on the left")
    println("Type 2 for the door on the right")
    println("Type 3 for the door at the end of the hallway")
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