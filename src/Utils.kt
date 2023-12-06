import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("data/$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

fun String.toIntArray(separator: String): List<Int> {
    return this.split(separator?: " ")
        .map{it.filter{it.isDigit()}}
        .filter{it.isNotEmpty()}
        .map{it.toInt()}
}

fun String.toIntArray(): List<Int> {
    return this.toIntArray(" ")
}
