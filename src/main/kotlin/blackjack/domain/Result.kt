package blackjack.domain

class Result(
    dealer: Dealer,
    players: List<Player>,
) {
    val playerRecords: List<PlayerRecord> =
        players.map { PlayerRecord(it.name, it.match(dealer)) }

    val dealerRecord: DealerWinDrawLose = DealerWinDrawLose(playerRecords)
}
