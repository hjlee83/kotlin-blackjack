package blackjack

import blackjack.util.InputUtils
import blackjack.view.InputView

fun main() {
    val playerNames = InputUtils.retryInput { InputView().readPlayerNames() }
}



