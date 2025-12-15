package blackjack.model

class Card(val suit: CardEnums.Suit, val rank: CardEnums.Rank) {
    override fun toString(): String = "${suit.korean}${rank.displayName}"
}
