package blackjack.domain

class Card(
    private val suit: Suit,
    private val rank: Rank,
) {
    fun score(): Int = rank.score

    fun isAce(): Boolean = rank == Rank.ACE

    override fun toString(): String = "${suit.displayName}${rank.displayName}"
}
