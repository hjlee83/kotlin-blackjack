package blackjack.view

import blackjack.domain.Dealer
import blackjack.domain.DealerWinDrawLose
import blackjack.domain.Participant
import blackjack.domain.PlayerRecord
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

    fun winOrLose(result: Result) {
        println("## 최종 승패")
        playersRecords(result.playerRecords)
        dealerRecords(result.dealerRecord)
    }

    private fun playersRecords(playerRecords: List<PlayerRecord>) {
        playerRecords.forEach { println("${it.name} : ${it.recordType.displayName}") }
    }

    private fun dealerRecords(dealerWinDrawLose: DealerWinDrawLose) {
        println("딜러 : ${dealerWinDrawLose.winCount}승 ${dealerWinDrawLose.drawCount}무 ${dealerWinDrawLose.loseCount}패")
    }
}
