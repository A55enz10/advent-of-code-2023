import java.lang.Math.min
import kotlin.math.pow

fun main() {

    fun part1(input: List<String>): Int {
        var totPoints = 0
        input.forEach { card ->
            val played = card.split(":")[1].split("|")[0].split(" ").map { str -> str.filter { it.isDigit() } }.filter { it.isNotEmpty() }
            val winning = card.split(":")[1].split("|")[1].split(" ").map { str -> str.filter { it.isDigit() } }.filter { it.isNotEmpty()}
            var numWinners = 0
            played.forEach{ number ->
                if (winning.contains(number)) numWinners++
            }
            val cardPoints = 2.0.pow(numWinners - 1.0).toInt()
            if (numWinners > 0) totPoints += cardPoints
        }

        return totPoints
    }

    fun getWinPoints(index: Int, cardPoints: Int, listCards: ArrayList<Int>): Int {
        var winPoints = 0
        if (cardPoints > 0) {
            // aggiungo questa scheda vincente...
            winPoints++
            // ...e ricorsivamente i punti delle schede successive
            for (i in index+1..min(index+cardPoints, listCards.size-1)) {
                winPoints +=  getWinPoints(i, listCards[i], listCards )
            }
        }
        return winPoints
    }

    fun part2(input: List<String>): Int {
//        var totPoints = 0
//
//        val listCards = ArrayList<Int>()
//        input.forEach{ card ->
//            var played = card.split(":")[1].split("|")[0].split(" ").map { str -> str.filter { it.isDigit() } }.filter { it.length > 0 }
//            var winning = card.split(":")[1].split("|")[1].split(" ").map { str -> str.filter { it.isDigit() } }.filter { it.length > 0 }
//            var numWinners = 0
//            played.forEach{ number ->
//                if (winning.contains(number)) numWinners++
//            }
//            var cardPoints = 0
//            if (numWinners > 0) cardPoints = numWinners
//            listCards.add(cardPoints)
//        }
//
//        var winPoints = 0
//        listCards.forEachIndexed { index, cardPoints ->
//            println ("PROCESSING CARD " + (index+1) + "...")
//            winPoints += getWinPoints(index, cardPoints, listCards)
//        }
//
//
//        return winPoints
        return 0
    }

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}

