fun main() {

    fun part1(input: List<String>): Int {

        var total = 1
        val times = input[0]
            .split(":")[1]
            .toIntArray()
        val  distances = input[1]
            .split(":")[1]
            .toIntArray(" ")

        for (i in times.indices) {
            val raceTime = times[i]
            val raceDistance = distances[i]

            var winningCombinations = 0
            for (pressMillis in 1..<raceTime) {
                if (pressMillis * (raceTime-pressMillis) > raceDistance) winningCombinations++
            }

            if (winningCombinations > 0) total *= winningCombinations
        }

        return total
    }

    fun part2(input: List<String>): Int {

        val raceTime = input[0]
            .split(":")[1]
            .replace(" ", "")
            .toLong()
        val raceDistance = input[1]
            .split(":")[1]
            .replace(" ", "")
            .toLong()

        var winningCombinations = 0
        for (pressMillis in 1..<raceTime) {
            if (pressMillis * (raceTime-pressMillis) > raceDistance) winningCombinations++
        }

        return winningCombinations
    }

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}

