package blackjack.model

class Deck {
    private val _cards = mutableSetOf<Card>()

    val cards: Set<Card>
        get() = _cards

    init {
        CardEnums.Suit.entries.flatMap { suit ->
            CardEnums.Rank.entries.map { rank ->
                Card(suit, rank)
            }
        }.shuffled().toCollection(_cards)
    }

    fun pop(): Card = _cards.pop()

    private fun MutableSet<Card>.pop(): Card {
        val firstCard = first()
        remove(firstCard)
        return firstCard
    }
}


