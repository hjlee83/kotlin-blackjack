package blackjack.domain

class Dealer : Participant(DEALER_NAME) {
    fun isAdditionalDealCondition(): Boolean = totalScore() <= DEALER_ADD_CARD_BASE_SCORE

    companion object {
        const val DEALER_NAME = "딜러"
        const val DEALER_ADD_CARD_BASE_SCORE = 16
    }
}
