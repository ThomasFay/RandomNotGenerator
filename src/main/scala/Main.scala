package main

import java.io.PrintWriter
import dataStruct._
import generator.Generator

object Main extends App {

  val out = "Out.mscx"

  val scoreGenerator = new Generator(Some(1000))

  new PrintWriter(out) {
    write(printer.Printer.printScore(scoreGenerator.generateScore(4,List(55,57,59,60,62,64,65,67))))
    close()
  }


}
