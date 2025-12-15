package blackjack.domain

import blackjack.domain.RecordType.DRAW
import blackjack.domain.RecordType.LOSE
import blackjack.domain.RecordType.WIN

class Player(
    name: String,
) : Participant(name) {
    fun match(dealer: Dealer): RecordType {
        val playerScore = totalScore()
        val dealerScore = dealer.totalScore()

        return when {
            playerScore > BLACKJACK_SCORE -> LOSE
            dealerScore > BLACKJACK_SCORE -> WIN
            playerScore > dealerScore -> WIN
            playerScore < dealerScore -> LOSE
            else -> compareCardCount(dealer)
        }
    }

    private fun compareCardCount(dealer: Dealer): RecordType =
        when {
            cards.size < dealer.cards.size -> WIN
            cards.size > dealer.cards.size -> LOSE
            else -> DRAW
        }
}
