package org.adevinta.app

import java.io.File
import scala.collection.mutable.LinkedHashMap
import scala.util.control.Breaks.{break, breakable}

object Utilities {
  def getListOfFiles(dir: String): List[String] = {
    val file = new File(dir)
    file.listFiles.filter(_.isFile)
      .filter(_.getName.endsWith(".txt"))
      .map(_.getPath).toList
  }
  //ready code -->
  def inputStringParser(ip: String): List[String] = {
    val ipWords: List[String] = ip.replaceAll("[^a-zA-Z0-9 ]", "").split(" ")
      .map(_.trim).filter(_.nonEmpty)
      .map(_.toLowerCase()).toList
    ipWords.distinct
  }

  def percCalc(fpath: List[String], ipstr: List[String]): Seq[(String,(Double, Int))] = {
    var fileMap = LinkedHashMap[String,(Double,Int)]()
    //ready code --> println(fileMap)
    val iplength = ipstr.length
    //ready code --> println("input length >>" + iplength)

    breakable {
      for (path <- fpath) {
        val fileParserStr = scala.io.Source.fromFile(path).getLines().mkString(" ")
        val fileParserList = inputStringParser(fileParserStr)

        val diffSet = ipstr.toSet &~ fileParserList.toSet
        val matchSet = ipstr.toSet & fileParserList.toSet

        val diffSetLength = diffSet.size
        val matchSetLength = matchSet.size



        val filename = path.split("\\\\").last

        val fileParserListLen = fileParserList.length


        val perc:Double = (matchSetLength.toDouble/fileParserList.length.toDouble)*100

        if(perc !=0){
          fileMap = fileMap ++List(filename -> (perc,fileParserListLen))
        }
      }


    }

    val newMap = fileMap.toSeq.sortBy {case (k,(a,b)) => (a,b) }.reverse

    fileMap.clear()
    newMap
  }

  def printOutput(fSeq:Seq[(String,(Double, Int))]): Unit ={
    if(fSeq.length == 0){
      println("No matches found")
    }
    else{
      var i = 1
      println("Ranked output")
      breakable{
        for((k,v) <- fSeq){
          println(i + ". " + k + " : " +v._1+"%")
          i =i+1
          if (i==11){
            break
          }
        }
      }
    }
  }

}
