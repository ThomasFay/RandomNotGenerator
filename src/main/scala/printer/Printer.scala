package printer

import java.time.LocalDate

object Printer {

  private val today: LocalDate = LocalDate.now

  private val name = "Exercices Aléatoires"
  private val subtitle = "Play me if you can"
  private val author = "Auteur: C'est l'IA"

  private val startingString = s"""<?xml version="1.0" encoding="UTF-8"?>
<museScore version="4.20">
  <programVersion>4.2.0</programVersion>
  <programRevision>eb8d33c</programRevision>
  <LastEID>48</LastEID>
  <Score>
    <Division>480</Division>
    <showInvisible>1</showInvisible>
    <showUnprintable>1</showUnprintable>
    <showFrames>1</showFrames>
    <showMargins>0</showMargins>
    <open>1</open>
    <metaTag name="arranger"></metaTag>
    <metaTag name="composer">Random Generation</metaTag>
    <metaTag name="copyright"></metaTag>
    <metaTag name="creationDate">${today.toString()}</metaTag>
    <metaTag name="lyricist"></metaTag>
    <metaTag name="movementNumber"></metaTag>
    <metaTag name="movementTitle"></metaTag>
    <metaTag name="platform">Linux</metaTag>
    <metaTag name="source"></metaTag>
    <metaTag name="subtitle"></metaTag>
    <metaTag name="translator"></metaTag>
    <metaTag name="workNumber"></metaTag>
    <metaTag name="workTitle">$name</metaTag>
    <Part id="1">
      <Staff id="1">
        <StaffType group="pitched">
          <name>stdNormal</name>
          </StaffType>
        <defaultClef>G8vb</defaultClef>
        </Staff>
      <trackName>Guitare classique</trackName>
      <Instrument id="guitar-nylon">
        <longName>Guitare classique</longName>
        <shortName>Guit.</shortName>
        <trackName>Guitare classique</trackName>
        <minPitchP>40</minPitchP>
        <maxPitchP>83</maxPitchP>
        <minPitchA>40</minPitchA>
        <maxPitchA>83</maxPitchA>
        <instrumentId>pluck.guitar.nylon-string</instrumentId>
        <clef>G8vb</clef>
        <singleNoteDynamics>0</singleNoteDynamics>
        <StringData>
          <frets>19</frets>
          <string>40</string>
          <string>45</string>
          <string>50</string>
          <string>55</string>
          <string>59</string>
          <string>64</string>
          </StringData>
        <Channel name="open">
          <program value="24"/>
          <synti>Fluid</synti>
          </Channel>
        <Channel name="mute">
          <program value="28"/>
          <synti>Fluid</synti>
          </Channel>
        </Instrument>
      </Part>
"""

  private val box = s"""      <VBox>
        <height>10</height>
        <eid>4294967418</eid>
        <Text>
          <eid>8589934598</eid>
          <style>title</style>
          <text>$name</text>
          </Text>
        <Text>
          <eid>12884901894</eid>
          <style>subtitle</style>
          <text>$subtitle</text>
          </Text>
        <Text>
          <eid>17179869190</eid>
          <style>composer</style>
          <text>$author</text>
          </Text>
        </VBox>

"""

  private val startStaff = """<Staff id = "1">"""
  private val endStaff = "</Staff>"

  private val close = """
    </Score>
  </museScore>
"""

  private val oneMeasure = """
      <Measure>
        <voice>
          <Rest>
            <eid>163208757273</eid>
            <durationType>measure</durationType>
            <duration>4/4</duration>
            </Rest>
          </voice>
        </Measure>
"""

  def printScore: String = {
    startingString ++
    startStaff ++
    box ++
    oneMeasure ++
    endStaff ++
      close
  }

}
