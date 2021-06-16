enum class LootType{
    POTION, RING, ARMOR, KEY, ARTIFACT, WEAPON
}

class Loot(val name: String, val lootType: LootType) {

    override fun toString(): String {
        return "$name is a $lootType"
    }
}
