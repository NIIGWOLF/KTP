name := "ScalaTest"
version := "1.0"
scalaVersion := "2.13.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test 

val common = Seq( scalaVersion := "2.13.2")
lazy val root = project.in(file(".")).aggregate(subProject0, subProject1, subProject2, subProject3)
lazy val subProject0 = project.in(file("project\\sub-project-0")).settings(common, libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test)
lazy val subProject1 = project.in(file("project\\sub-project-1")).settings(common, libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test)
lazy val subProject2 = project.in(file("project\\sub-project-2")).settings(common, libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test)
lazy val subProject3 = project.in(file("project\\sub-project-3")).settings(common, libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test)
