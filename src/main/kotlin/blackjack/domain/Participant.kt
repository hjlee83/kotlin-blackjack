package blackjack.domain

abstract class Participant(val name: String) {
    private val _cards = mutableSetOf<Card>()

    val cards: Set<Card>
        get() = _cards.toSet()

    fun addCard(card: Card) {
        _cards.add(card)
    }

    fun totalScore(): Int {
        var score = cards.sumOf { it.score() }
        val aceCount = cards.count { it.isAce() }

        repeat(aceCount) {
            if (score + ACE_ADDITIONAL_SCORE <= BLACKJACK_SCORE) {
                score += ACE_ADDITIONAL_SCORE
            }
        }

        return score
    }

    fun cardCount() = cards.size

    fun isBust(): Boolean = totalScore() > BLACKJACK_SCORE

    fun isBlackjack(): Boolean = cardCount() == BLACKJACK_CARD_COUNT && totalScore() == BLACKJACK_SCORE

    companion object {
        const val ACE_ADDITIONAL_SCORE = 10
    }
}
