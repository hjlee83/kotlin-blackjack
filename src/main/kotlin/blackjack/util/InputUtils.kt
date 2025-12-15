package blackjack.util

object InputUtils {
    fun <T> retryInput(prompt: () -> T): T {
        while (true) {
            try {
                return prompt()
            } catch (_: Exception) {
                println("다시 입력해주세요.")
            }
        }

    }
}