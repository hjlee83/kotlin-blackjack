package blackjack.model

abstract class Participant(val name: String) {
    private val _cards = mutableSetOf<Card>()

    val cards: Set<Card>
        get() = _cards

    fun addCard(card: Card) {
        _cards.add(card)
    }

    fun totalScore(): Int {
        // ACE를 1로 했을때의 점수
        var sum = cards.sumOf { it.rank.score }

        val aceCount =
            cards.count {
                it.rank == CardEnums.Rank.ACE
            }

        (1..aceCount).forEach { _ ->
            if (sum + 10 > 21) {
                return sum
            } else {
                sum += 10
            }
        }

        return sum
    }
}
