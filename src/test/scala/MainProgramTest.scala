package org.adevinta.app
import org.scalatest.funsuite.AnyFunSuite
import org.adevinta.app.Utilities._

class MainProgramTest extends AnyFunSuite {
  test("get list of files ending with .txt"){
    val listOfFiles = getListOfFiles("src/test/scala/dir1/dir2")
    assert(listOfFiles.length == 3)
  }

  test("convert string to list removing duplicates & special characters"){
    val ipString = inputStringParser("to be or not to be?")
    //println(ipString)
    assert(ipString.length == 4)
    assert(ipString == List[String]("to", "be", "or", "not"))
  }

  test("calculate percentage match in input string and list of files data"){
    val qsearch = percCalc(List[String]("src/test/scala/dir1/dir2/file1.txt", "src/test/scala/dir1/dir2/file2.txt"),List[String]("to", "be", "or", "not"))
    println(qsearch)
    assert(qsearch.length == 2)
    assert(qsearch(0)._2 == (80.0,5))
  }
}
