package blackjack.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class DeckTest :
    BehaviorSpec({

        Given("52장의 카드로 구성된 덱이 주어졌을 때") {
            val deck = Deck()
            When("모든 카드를 52번 꺼낸 후") {
                repeat(52) { deck.pop() }
                Then("덱이 비어있어 예외가 발생한다.") {
                    val exception =
                        shouldThrow<NoSuchElementException> {
                            deck.pop()
                        }

                    exception.message shouldBe "카드가 비어있습니다."
                }
            }
        }

        Given("새로운 덱이 주어졌을 때") {
            val deck = Deck()
            When("모든 카드를 꺼내서 수집하면") {
                val cards = mutableListOf<Card>()
                repeat(52) { cards.add(deck.pop()) }
                Then("모든 카드는 고유한 조합을 가지며 중복이 없다.") {
                    val uniqueCards = cards.map { Pair(it.suit, it.rank) }.toSet()
                    uniqueCards.size shouldBe 52
                }
            }
        }

        Given("덱이 생성될 때") {
            When("여러 번 덱을 생성하면") {
                val decks = (1..10).map { Deck() }
                val firstCards = decks.map { it.pop() }

                Then("각 덱의 첫 번째 카드가 셔플되어 서로 다르다.") {
                    firstCards.toSet().size != 1 // 낮은 확률로 10번의 덱의 셔플된 첫번째 카드 10개가 동일할수 있으나 확률적으로 동일하기 어렵다.
                }
            }
        }
    })
