package blackjack.model

class CardEnums {
    enum class Suit(private val korean: String) {
        CLUB("클로버"),
        DIAMOND("다이아몬드"),
        HEART("하트"),
        SPADE("스페이드"),
    }

    enum class Rank(private val displayName: String, val score: Int) {
        ACE("A", 1),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 10),
        QUEEN("Q", 10),
        KING("K", 10),
    }
}
