package blackjack.domain

class DealerWinDrawLose(
    playerRecords: List<PlayerRecord>,
) {
    val winCount: Int = playerRecords.count { it.recordType == RecordType.LOSE }
    val drawCount: Int = playerRecords.count { it.recordType == RecordType.DRAW }
    val loseCount: Int = playerRecords.count { it.recordType == RecordType.WIN }
}
