package blackjack.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class DealerTest : BehaviorSpec({
    Given("딜러카드") {
        val dealer = Dealer()

        Then("이름은 딜러다") {
            dealer.name shouldBe "딜러"
        }

        When("두장의 카드값이 합이 16이하면") {
            dealer.addCard(Card(CardEnums.Suit.DIAMOND, CardEnums.Rank.ACE))
            dealer.addCard(Card(CardEnums.Suit.SPADE, CardEnums.Rank.ACE))

            Then(" True") {
                dealer.isAdditionalDealCondition() shouldBe true
            }
        }

        When("두장의 카드값이 합이 16이상이면") {
            dealer.addCard(Card(CardEnums.Suit.DIAMOND, CardEnums.Rank.JACK))
            dealer.addCard(Card(CardEnums.Suit.SPADE, CardEnums.Rank.JACK))

            Then(" False") {
                dealer.isAdditionalDealCondition() shouldBe false
            }
        }
    }

})
