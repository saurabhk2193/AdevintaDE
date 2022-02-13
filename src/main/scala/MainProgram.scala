package org.adevinta.app
import org.adevinta.app.Utilities._

object MainProgram {
  // MAIN PROGRAM
  def main(args:Array[String]) : Unit = {
    //check arguments
    if (args.length == 0) {
      print("file path not present")
      System.exit(0)
    }

    val path = args(0)

    //val flist = getListOfFiles("src/main/scala/dir1/dir2")
    val flist = getListOfFiles(path)
    println(flist)
    if (flist.length == 0){
      print("no txt file present")
      System.exit(0)
    }


    while (true){
      print("search > ")
      val input = scala.io.StdIn.readLine()

      if(input == ":quit"){
        System.exit(0)
        print("hello")
      }
      else {
        val listOfWords = inputStringParser(input)
        //ready code -->
        println(listOfWords)
        val qsearch = percCalc(flist,listOfWords)
        //println("final output : " + qsearch)
        //ready code --> println(" FINAL OUTPUT ")
        printOutput(qsearch)
      }
    }
  }

}

