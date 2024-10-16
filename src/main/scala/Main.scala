package main

import java.io.PrintWriter



object Main extends App {

  val out = "Out.mscx"

  new PrintWriter(out) {
    write(printer.Printer.printScore)
    close()
  }


}
