package blackjack.domain

class DealerProfit(
    playerProfits: List<PlayerProfit>,
) {
    val profit: Double = playerProfits.sumOf { -it.profit }
}
