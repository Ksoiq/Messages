const val MINUTE = 60
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun main() {
    print("Введите время в секундах: \n")
    val time = readLine()?.toInt()
    print("Пользователь был(а) в сети:  ${time?.let { agoToText(it) }}")
}

fun agoToText(time: Int): String = when (time) {
    in 0..MINUTE -> "только что"
    in MINUTE + 1..HOUR -> when (time.div(MINUTE)) {
        1, 21, 31, 41, 51 -> "${time.div(MINUTE)} минуту назад"
        2, 3, 4, 22, 23, 24, 32, 34, 42, 43, 44, 52, 53, 54 -> "${time.div(MINUTE)} минуты назад"
        else -> "${time.div(MINUTE)} минут назад"
    }
    in HOUR + 1..DAY - HOUR -> when (time.div(HOUR)) {
        1, 21 -> "${time.div(HOUR)} час назад"
        2, 3, 4, 22, 23 -> "${time.div(HOUR)} часа назад"
        else -> "${time.div(HOUR)} часов назад"
    }
    in DAY - HOUR..DAY * 2 -> "сегодня"
    in DAY * 2 + 1..DAY * 3 -> "вчера"
    in DAY * 3 + 1..Int.MAX_VALUE -> "давно"
    else -> {
        error("Ошибка")
    }
}






