package blackjack.domain

class Dealer : Participant(DEALER_NAME) {
    fun isAdditionalDealCondition(): Boolean = totalScore() <= DEALER_ADD_CARD_BASE_SCORE
}
