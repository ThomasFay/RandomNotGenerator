package generator

import scala.util.Random
import dataStruct._
import scala.annotation.tailrec

class Generator(seed: Option[Long] = None) {

  private val rand = new Random(seed.getOrElse(System.currentTimeMillis()))

  private def generateNote(possiblePitches: List[Int], noteDuration: Int): Content = {

    val possibleNotes: List[Option[Int]] = None :: possiblePitches.map(Some(_))
    val pitchOpt                         = rand.shuffle(possibleNotes).head
    pitchOpt match {
      case None    => Rest(noteDuration)
      case Some(p) => Note(p, noteDuration)
    }
  }

  private def generateMeasure(possiblePitches: List[Int], duration: Int): Measure = {
    @tailrec
    def generateTheMesure(
      leavingDuration: Int = duration,
      contents: List[Content] = List()
    ): List[Content] = {
      println(leavingDuration)
      if (leavingDuration <= 0) {
        contents
      } else {
        val noteDuration = 4
        val newNote      = generateNote(possiblePitches, noteDuration)
        generateTheMesure(leavingDuration - noteDuration, newNote :: contents)
      }
    }
    Measure(duration, generateTheMesure())
  }

  def generateScore(nbMeasure: Int, possiblePitches: List[Int]): List[Measure] = {
    @tailrec
    def generateTheScore(
      nbMeasureLeft: Int = nbMeasure,
      score: List[Measure] = List()
    ): List[Measure] = {
      if (nbMeasureLeft == 0) {
        score
      } else {
        generateTheScore(nbMeasureLeft - 1, generateMeasure(possiblePitches, 16) :: score)
      }
    }
    generateTheScore()
  }

}
