package blackjack.domain

class Player(
    name: String,
) : Participant(name) {
    fun match(dealer: Dealer): RecordType {
        val playerScore = totalScore()
        val dealerScore = dealer.totalScore()

        return when {
            playerScore > BLACKJACK_SCORE -> RecordType.LOSE
            dealerScore > BLACKJACK_SCORE -> RecordType.WIN
            playerScore > dealerScore -> RecordType.WIN
            playerScore < dealerScore -> RecordType.LOSE
            else -> compareCardCount(dealer)
        }
    }

    private fun compareCardCount(dealer: Dealer): RecordType =
        when {
            cardCount() < dealer.cardCount() -> RecordType.WIN
            cardCount() > dealer.cardCount() -> RecordType.LOSE
            else -> RecordType.DRAW
        }
}
