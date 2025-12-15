package blackjack.model

class Dealer() : Participant(DEALER_NAME) {
    fun isAdditionalDealCondition(): Boolean {
        return super.totalScore() <= ADDITION_CARD_BASE_SCORE
    }

    companion object {
        private const val DEALER_NAME = "딜러"
        private const val ADDITION_CARD_BASE_SCORE = 16
    }
}
