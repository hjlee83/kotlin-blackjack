package blackjack.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class PlayerTest : BehaviorSpec({
    Given("김효건카드") {
        val player = Player("김효건")
        When("카드를 더하면") {
            player.addCard(Card(CardEnums.Suit.DIAMOND, CardEnums.Rank.ACE))
            Then("카드리스트에 카드가 추가된다.") {
                player.cards.size shouldBe 1
            }
        }
    }
})
