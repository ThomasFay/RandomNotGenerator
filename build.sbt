ThisBuild / scalaVersion := "2.13.11"
ThisBuild / organization := "org.fayolle"
ThisBuild / version      := "0.1"

lazy val root = (project in file("."))
  .settings(
    name := "Random Note Generator"
  )
