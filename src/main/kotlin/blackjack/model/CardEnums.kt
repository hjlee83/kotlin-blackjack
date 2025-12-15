package blackjack.model

class CardEnums {
    enum class Suit(private val korean: String) {
        CLUB("클로버"),
        DIAMOND("다이아몬드"),
        HEART("하트"),
        SPADE("스페이드")
    }

    enum class Rank(private val score: Int) {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10),
    }
}