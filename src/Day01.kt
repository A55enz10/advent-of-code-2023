fun main() {

    fun part1(input: List<String>): Int {

        return input.map { str -> str.filter { it.isDigit() } }
            .map { it.substring(0, 1) + it.substring(it.length - 1) }
            .sumOf { it.toInt() }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.getDigits() }
            .map { it.substring(0, 1) + it.substring(it.length - 1) }
            .sumOf { it.toInt() }
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

private fun String.getDigits(): String {
    val digitList =  arrayOf("zero","one","two","three","four","five","six","seven","eight","nine")
    var digitStr = ""
    var i = 0
    while (i < this.length) {
        val subStr = this.substring(i)
        if (subStr.first().isDigit())
            digitStr += subStr.first()
        else
            digitList.forEach{
                if (subStr.startsWith(it)) {
                    digitStr += digitList.indexOf(it)
                }
            }
        i++
    }
    return digitStr
}
