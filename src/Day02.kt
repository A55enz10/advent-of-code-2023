import kotlin.math.max

fun main() {

    fun part1(input: List<String>): Int {

        val maxRed = 12
        val maxGreen = 13
        val maxBlue = 14

        var count = 0
        input.forEach { row ->
            var isPossible = true
            row.split(":")[1]
                .split(";").forEach { game ->
                    game.split(",").forEach {
                        if (it.contains("red"))
                            isPossible = isPossible && (it.trim().split(" ")[0].toInt() <= maxRed)
                        if (it.contains("blue"))
                            isPossible = isPossible && (it.trim().split(" ")[0].toInt() <= maxBlue)
                        if (it.contains("green"))
                            isPossible = isPossible && (it.trim().split(" ")[0].toInt() <= maxGreen)
                    }
                }
            if (isPossible) count += row.split(":")[0].split(" ")[1].toInt()
        }

        return count
    }

    fun part2(input: List<String>): Int {

        var count = 0
        input.forEach { row ->
            var minRed = 0
            var minGreen = 0
            var minBlue = 0
            row.split(":")[1]
                .split(";").forEach { game ->
                    game.split(",").forEach {
                        val num = it.trim().split(" ")[0].toInt()
                        if (it.contains("red"))
                            minRed =  max(minRed, num)
                        if (it.contains("blue"))
                            minBlue = max(minBlue, num)
                        if (it.contains("green"))
                            minGreen = max(minGreen, num)
                    }
                }
            count += minRed * minBlue * minGreen
        }

        return count
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

