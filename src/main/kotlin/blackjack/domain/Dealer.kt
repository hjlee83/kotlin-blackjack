package blackjack.domain

class Dealer : Participant(NAME) {
    fun isAdditionalDealCondition(): Boolean = totalScore() <= ADD_CARD_BASE_SCORE

    override fun addCard(card: Card) {
        require(cardCount() < MAX_CARD_COUNT) {
            "딜러는 카드를 ${MAX_CARD_COUNT}장 초과해서 가질 수 없습니다."
        }
        super.addCard(card)
    }

    companion object {
        const val NAME = "딜러"
        const val ADD_CARD_BASE_SCORE = 16
        const val MAX_CARD_COUNT = 3
    }
}
