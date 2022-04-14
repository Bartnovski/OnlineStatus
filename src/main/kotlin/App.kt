const val TIME_PAST_IN_SEC: UInt = 76_245U

fun main() {
    val timePastText = agoToText(TIME_PAST_IN_SEC)
    println(timePastText)
}

fun agoToText(timePast: UInt): String = when (timePast) {

    in 0U..60U -> "был(а) только что"
    in 61U..60U * 60U -> "был(а) ${timePast / 60U} ${phraseMinutes(timePast / 60U)} назад"
    in 60U * 60U + 1U..24U * 60U * 60U ->
        "был(а) ${timePast / 3600U} ${phraseHours(timePast / (60U * 60U))} назад"
    in 24U * 60U * 60U + 1U..2U * 24U * 60U * 60U -> "был(а) сегодня"
    in 2U * 24U * 60U * 60U + 1U..3U * 24U * 60U * 60U -> "был(а) вчера"
    else -> "был(а) давно"
}

fun phraseMinutes(timePast: UInt): String {
    if ((timePast == 1U) || ((timePast % 10U) == 1U)) return "минуту"
    return if (((timePast == 2U) || (timePast % 10U) == 2U) ||
        ((timePast == 3U) || (timePast % 10U) == 3U) ||
        ((timePast == 4U) || (timePast % 10U) == 4U)
    ) "минуты"
    else return "минут"
}

fun phraseHours(timePast: UInt): String {
    if ((timePast == 1U) || ((timePast % 10U) == 1U)) return "час"
    return if (((timePast == 2U) || (timePast % 10U) == 2U) ||
        ((timePast == 3U) || (timePast % 10U) == 3U) ||
        ((timePast == 4U) || (timePast % 10U) == 4U)
    ) "часа"
    else return "часов"
}