package dataStruct

sealed abstract class Content(val duration : Int) {
  require(duration > 0)
  require(duration <= 16)
  require(List(1,2,4,8,16).contains(duration))
  def durationToString = {
    duration match {
      case d if (d == 1) => "16th"
      case d if (d == 2) => "eighth"
      case d if (d == 4) => "quarter"
      case d if (d == 8) => "half"
      case d if (d == 16)  => "whole"
      case _ => require(false,"This duration is not supported yet")
    }
  }

  def toXml : String
}

case class Note(pitch : Int,
  override val duration : Int) extends Content(duration) {

  override def toXml : String = s"""
<Chord>
<durationType>$durationToString</durationType>
<Note>
<pitch>$pitch</pitch>
</Note>
</Chord>
"""


}


case class Rest(override val duration : Int) extends Content(duration) {
  override def toXml : String = s"""<Rest>
<durationType>$durationToString</durationType>
</Rest>
"""
}
