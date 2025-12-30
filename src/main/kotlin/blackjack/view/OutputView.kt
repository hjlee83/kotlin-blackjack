package blackjack.view

import blackjack.domain.Dealer
import blackjack.domain.DealerProfit
import blackjack.domain.Participant
import blackjack.domain.PlayerProfit
import blackjack.domain.Result

object OutputView {
    fun initialDeal(playerNames: List<String>) = println("딜러와 ${playerNames.joinToString(", ") { it }}에게 2장을 나누었습니다.")

    fun dealerInitialCardList(dealer: Dealer) = println("${dealer.name}카드: ${dealer.cards.take(1).joinToString(", ") { it.toString() }}")

    fun dealerAdditionalCondition() = println("딜러는 16이하라 한장의 카드를 더 받았습니다.")

    fun cardList(participant: Participant) = println(createCardListMessage(participant))

    fun scoreResult(participants: List<Participant>) {
        participants.forEach { scoreResult(it) }
    }

    private fun scoreResult(participant: Participant) = println("${createCardListMessage(participant)} - 결과: ${participant.totalScore()}")

    private fun createCardListMessage(participant: Participant) =
        "${participant.name}카드: ${participant.cards.joinToString(", ") { it.toString() }}"

    fun finalProfit(result: Result) {
        println("## 최종 수익")
        dealerProfit(result.dealerProfit)
        playersProfit(result.playerProfits)
    }

    private fun playersProfit(playerProfits: List<PlayerProfit>) = playerProfits.forEach { println("${it.name} : ${it.profit}") }

    private fun dealerProfit(dealerProfit: DealerProfit) = println("딜러 : ${dealerProfit.profit}")
}
