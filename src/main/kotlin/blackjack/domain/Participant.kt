package blackjack.domain

abstract class Participant(val name: String) {
    private val _cards = mutableSetOf<Card>()

    val cards: Set<Card>
        get() = _cards

    fun addCard(card: Card) {
        _cards.add(card)
    }

    fun totalScore(): Int {
        var totalScore = cards.sumOf { it.score() }

        val aceCount = cards.count { it.isAce() }

        repeat(aceCount) {
            if (totalScore + ACE_ADDITIONAL_SCORE <= BLACKJACK_SCORE) {
                totalScore += ACE_ADDITIONAL_SCORE
            }
        }

        return totalScore
    }
}
