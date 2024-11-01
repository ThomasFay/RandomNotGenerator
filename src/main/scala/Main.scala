package main

import java.io.PrintWriter
import dataStruct._
import generator.Generator

object Main extends App {

  val measure = Measure(16,List(Note(62,2),Note(64,2),Note(64,4),Rest(4),Note(56,4)))

  val out = "Out.mscx"

  val scoreGenerator = new Generator(Some(1000))

  new PrintWriter(out) {
    write(printer.Printer.printScore(scoreGenerator.generateScore(4,List(62,64,66,68))))
    close()
  }


}
