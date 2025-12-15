package blackjack.view

class InputView {
    fun readPlayerNames(): List<String> {
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
        val playerNames =
            readlnOrNull()
                ?.split(",")
                ?.map { it.trim() }

        require(playerNames != null && playerNames.isNotEmpty() && playerNames.all { it.isNotBlank() }) { "올바른 참가자 이름을 입력해주세요." }
        return playerNames
    }
}
