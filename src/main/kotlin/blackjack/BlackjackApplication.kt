package blackjack

import blackjack.model.Dealer
import blackjack.model.Deck
import blackjack.model.Player
import blackjack.util.InputUtils
import blackjack.view.InputView
import blackjack.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val deck = Deck()

    val playerNames = InputUtils.retryInput { inputView.playerNames() }

    val dealer = Dealer()
    val players = playerNames.map { Player(it) }
    outputView.initialDeal(playerNames)

    (players + dealer).forEach { // 처음
        it.addCard(deck.pop())
        it.addCard(deck.pop())
    }

    outputView.firstDealerCardList(dealer)
    players.forEach { outputView.cardList(it) }

    players.forEach {
        while (inputView.decideDealCard(it)) {
            it.addCard(deck.pop())
            outputView.cardList(it)
        }
    }
}
