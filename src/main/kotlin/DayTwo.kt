import java.io.File

class DayTwo {

    private val input = "src/main/data/day2/input.txt"
    private val inputTest = "src/main/data/day2/inputTest.txt"

    private fun readFileAsTextUsingInputStream(fileName: String) = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)
    private var data: String = readFileAsTextUsingInputStream(input)
    private val rounds = data.split("\n")

    private val scores = mapOf(
        "X" to 1,
        "A" to 1,
        "Y" to 2,
        "B" to 2,
        "Z" to 3,
        "C" to 3,
        "WIN" to 6,
        "DRAW" to 3,
        "LOSS" to 0
        )

    fun partOne(): Int {

        var totalPoints = 0

        rounds.forEach { round ->
            val opponent = round.split(" ")[0]
            val i = round.split(" ")[1]

            totalPoints += scores[i]!!

            when (i) {
                "X" -> {
                    totalPoints += when (opponent) {
                        "A" -> {
                            scores["DRAW"]!!
                        }
                        "B" -> {
                            scores["LOSS"]!!
                        }
                        else -> {
                            scores["WIN"]!!
                        }
                    }
                }
                "Y" -> {
                    totalPoints += when (opponent) {
                        "A" -> {
                            scores["WIN"]!!
                        }
                        "B" -> {
                            scores["DRAW"]!!
                        }
                        else -> {
                            scores["LOSS"]!!
                        }                        }
                }
                "Z" -> {
                    totalPoints += when (opponent) {
                        "A" -> {
                            scores["LOSS"]!!
                        }
                        "B" -> {
                            scores["WIN"]!!
                        }
                        else -> {
                            scores["DRAW"]!!
                        }
                    }
                }
            }
        }


        return totalPoints
    }

    fun partTwo(): Int {

        var totalPoints = 0

        rounds.forEach { round ->
            val opponent = round.split(" ")[0]
            val i = round.split(" ")[1]
            
            when (opponent) {
                "A" -> {
                    totalPoints += when (i) {
                        "X" -> {
                            scores["LOSS"]!! + scores["C"]!!
                        }
                        "Y" -> {
                            scores["DRAW"]!! + scores["A"]!!
                        }
                        else -> {
                            scores["WIN"]!! + scores["B"]!!
                        }
                    }
                }
                "B" -> {
                    totalPoints += when (i) {
                        "X" -> {
                            scores["LOSS"]!! + scores["A"]!!
                        }
                        "Y" -> {
                            scores["DRAW"]!! + scores["B"]!!
                        }
                        else -> {
                            scores["WIN"]!! + scores["C"]!!
                        }
                    }
                }
                "C" -> {
                    totalPoints += when (i) {
                        "X" -> {
                            scores["LOSS"]!! + scores["B"]!!
                        }
                        "Y" -> {
                            scores["DRAW"]!! + scores["C"]!!
                        }
                        else -> {
                            scores["WIN"]!! + scores["A"]!!
                        }
                    }
                }
            }
        }


        return totalPoints
    }
}