package dataStruct

case class Measure(duration: Int, contents: List[Content]) {
  require(
    contents.map(_.duration).sum <= duration,
    "Measure duration is too short for the number of note"
  )
  require(
    List(8, 12, 16).contains(duration),
    s"Measure with duration = $duration is not supported yet"
  )

  def timeSig: String = {
    s"""<TimeSig>
<sigN>${duration / 4}</sigN>
<sigD>4</sigD>
</TimeSig>
"""
  }

  def toXml(fst: Boolean): String = {
    val contentsToXml = contents.map(_.toXml).mkString("\n")
    val time          = if (fst) timeSig else ""
    s"""<Measure>
<voice>
$time
$contentsToXml
</voice>
</Measure>
"""
  }
}
