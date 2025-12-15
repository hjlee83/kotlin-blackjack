package blackjack.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class PlayerTest : BehaviorSpec({
    Given("김효건 플레이어에게") {
        val player = Player("김효건")
        When("다이아몬드 에이스 카드를 더하면") {
            player.addCard(Card(Suit.DIAMOND, Rank.ACE))
            Then("카드리스트에 카드가 추가된다.") {
                player.cardCount() shouldBe 1
            }
            Then("총 점수가 11점이 된다.") {
                player.totalScore() shouldBe 11
            }
        }
        When("하트 에이스 카드를 더하면") {
            player.addCard(Card(Suit.HEART, Rank.ACE))
            Then("카드가 총 2장이 된다.") {
                player.cardCount() shouldBe 2
            }
            Then("총 점수가 12점이 된다.") {
                player.totalScore() shouldBe 12
            }
        }
        When("하트 5 카드를 더하면") {
            player.addCard(Card(Suit.HEART, Rank.FIVE))
            Then("카드리스트에 카드가 또 추가된다.") {
                player.cardCount() shouldBe 3
            }
            Then("총 점수가 17점이 된다.") {
                player.totalScore() shouldBe 17
            }
        }
    }

    Given("플레이어에 다음과 같이 2장의 카드가 분배 됐을 때") {
        val player = Player("김효건")
        player.addCard(Card(Suit.DIAMOND, Rank.ACE))
        player.addCard(Card(Suit.HEART, Rank.FIVE))

        When("딜러와 점수는 같은데, 카드 수는 적으면") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.DIAMOND, Rank.ACE))
            dealer.addCard(Card(Suit.CLUB, Rank.THREE))
            dealer.addCard(Card(Suit.HEART, Rank.TWO))
            Then("이긴다.") {
                player.match(dealer) shouldBe RecordType.WIN
            }
        }

        When("딜러와 점수는 같고, 카드 수도 같으면") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.HEART, Rank.ACE))
            dealer.addCard(Card(Suit.SPADE, Rank.FIVE))
            Then("비긴다.") {
                player.match(dealer) shouldBe RecordType.DRAW
            }
        }

        When("딜러보다 점수가 높으면") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.DIAMOND, Rank.ACE))
            dealer.addCard(Card(Suit.CLUB, Rank.TWO))
            dealer.addCard(Card(Suit.HEART, Rank.TWO))
            Then("이긴다.") {
                player.match(dealer) shouldBe RecordType.WIN
            }
        }

        When("딜러보다 점수가 낮으면") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.DIAMOND, Rank.ACE))
            dealer.addCard(Card(Suit.CLUB, Rank.THREE))
            dealer.addCard(Card(Suit.HEART, Rank.THREE))
            Then("진다.") {
                player.match(dealer) shouldBe RecordType.LOSE
            }
        }
    }

    Given("플레이어에 다음과 같이 3장의 카드가 분배 됐을 때") {
        val player = Player("김효건")
        player.addCard(Card(Suit.DIAMOND, Rank.ACE))
        player.addCard(Card(Suit.HEART, Rank.FIVE))
        player.addCard(Card(Suit.HEART, Rank.ACE))

        When("딜러와 점수는 같고, 카드 수도 같으면") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.HEART, Rank.FOUR))
            dealer.addCard(Card(Suit.SPADE, Rank.FIVE))
            dealer.addCard(Card(Suit.SPADE, Rank.EIGHT))
            Then("비긴다.") {
                player.match(dealer) shouldBe RecordType.DRAW
            }
        }

        When("딜러보다 점수가 높으면") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.DIAMOND, Rank.ACE))
            dealer.addCard(Card(Suit.HEART, Rank.FOUR))
            dealer.addCard(Card(Suit.HEART, Rank.ACE))
            Then("이긴다.") {
                player.match(dealer) shouldBe RecordType.WIN
            }
        }

        When("딜러보다 점수가 낮으면") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.DIAMOND, Rank.ACE))
            dealer.addCard(Card(Suit.HEART, Rank.FIVE))
            dealer.addCard(Card(Suit.HEART, Rank.TWO))
            Then("진다.") {
                player.match(dealer) shouldBe RecordType.LOSE
            }
        }

        When("딜러와 점수는 같고, 카드 수도 많으면") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.HEART, Rank.ACE))
            dealer.addCard(Card(Suit.SPADE, Rank.SIX))
            Then("진다.") {
                player.match(dealer) shouldBe RecordType.LOSE
            }
        }
    }

    Given("플레이어가 버스트(21 초과)했을 때") {
        val player = Player("김효건")
        player.addCard(Card(Suit.DIAMOND, Rank.TEN))
        player.addCard(Card(Suit.CLUB, Rank.TEN))
        player.addCard(Card(Suit.HEART, Rank.TWO))

        When("딜러 점수와 관계없이") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.DIAMOND, Rank.TEN))
            dealer.addCard(Card(Suit.CLUB, Rank.TEN))
            Then("플레이어는 진다.") {
                player.match(dealer) shouldBe RecordType.LOSE
            }
        }

        When("딜러도 버스트했을 때") {
            val dealer = Dealer()
            dealer.addCard(Card(Suit.DIAMOND, Rank.TEN))
            dealer.addCard(Card(Suit.CLUB, Rank.TEN))
            dealer.addCard(Card(Suit.HEART, Rank.TWO))
            Then("플레이어는 진다.") {
                player.match(dealer) shouldBe RecordType.LOSE
            }
        }
    }

    Given("딜러가 버스트(21 초과)했을 때") {
        val dealer = Dealer()
        dealer.addCard(Card(Suit.DIAMOND, Rank.TEN))
        dealer.addCard(Card(Suit.CLUB, Rank.TEN))
        dealer.addCard(Card(Suit.HEART, Rank.TWO))

        When("플레이어 점수와 관계없이") {
            val player = Player("김효건")
            player.addCard(Card(Suit.DIAMOND, Rank.TEN))
            player.addCard(Card(Suit.CLUB, Rank.TEN))
            Then("플레이어는 이긴다.") {
                player.match(dealer) shouldBe RecordType.WIN
            }
        }

        When("플레이어가 21점일 때") {
            val player = Player("김효건")
            player.addCard(Card(Suit.DIAMOND, Rank.ACE))
            player.addCard(Card(Suit.CLUB, Rank.TEN))
            Then("플레이어는 이긴다.") {
                player.match(dealer) shouldBe RecordType.WIN
            }
        }
    }
})
