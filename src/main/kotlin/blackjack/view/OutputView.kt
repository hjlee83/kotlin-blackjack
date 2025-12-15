package blackjack.view

import blackjack.model.Dealer
import blackjack.model.Participant

class OutputView {
    fun initialDeal(playerNames: List<String>) {
        println("딜러와 ${playerNames.joinToString { it }}에게 2장을 나누었습니다.")
    }

    fun firstDealerCardList(player: Dealer) {
        println("${player.name}카드: ${player.cards.take(1).joinToString { it.toString() }}")
    }

    fun cardList(player: Participant) {
        println("${player.name}카드: ${player.cards.joinToString { it.toString() }}")
    }
}
