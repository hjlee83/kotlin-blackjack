package blackjack.view

import blackjack.model.Player

class OutView {

    fun initialDeal(playerNames: List<String>) {
        println("딜러와 ${playerNames.joinToString { "," }}에게 2장을 나누었습니다.")
    }

    fun cardList(player: Player) {
        println("${player.name}카드: ${player.cards.joinToString { it.toString() }}")
    }
}
