package main

import java.io.PrintWriter
import dataStruct._


object Main extends App {

  val measure = Measure(16,List(Note(62,2),Note(64,2),Note(64,4),Rest(4),Note(56,4)))

  val out = "Out.mscx"

  new PrintWriter(out) {
    write(printer.Printer.printScore(List(measure)))
    close()
  }


}
