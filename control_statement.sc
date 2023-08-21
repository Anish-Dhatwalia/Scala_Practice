object control_statement
{
  private def forloop(): Unit = {
    for (i<-List(1,2,3,4,5))
      {
        println("simple for loop: "+i)
      }
    for(i<- 1 to 5) {
      println("for loop using to: " + i)
    }
    for (i <- 1 until 5) {
      println("for loop using until: " + i)
    }
    for (i <- 1 until 5;j<- 1 until 3) {
      println("Nested for loop: i " + i + ", j: "+j)
    }
    for (i <- 1 until 5; if i>1) {
      println("for loop with condition if i>1: i " + i )
    }
    val result=for {i <- List(1,2,44,3,4,679,990) if i<4} yield {
      i*i  // Return a list of squares.
    }
    println("result of for loop with yield:- "+ result)
  }

  def main(args: Array[String]): Unit = {
    forloop()
  }
}