import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Random, Success}
import Thread.sleep
import scala.concurrent.duration.{Duration, DurationInt}
object Futures {
  def getSquare(num:Int): Int = {
    num*num;
  }
  def FutureGetSquare(num:Int): Future[Int] = Future{
    num*num
  }
  def main(args: Array[String]): Unit = {
    println("before future");
    val f = Future {
      println("Hey")
      val sleeptime = 3000;
      if (sleeptime > 200) throw new Exception("bohot time le raha hai sleep time");
      sleep(sleeptime)
      println(s"sleeptime is $sleeptime")
    }
    println("after future");
    //    f.onComplete{
    //      case Success(value) => print("hogya");
    //      case Failure(e) => print(s"nahi hua kunki $e");
//  }
    f.andThen
    {
      case Success(value) => print("hogya");
      case Failure(e) => print(s"nahi hua kunki $e");
    }
    // we can also f.foreach(println)
//    this will print the messages or return the value to be computed for the future from this variable. Be it an exception


    // calling a method
    println("Calling new future for square")
    val square = Future{
      getSquare(4)
    }
    println("After Calling new future for square")
    square.foreach(println);
    // done with method

    // now method returning in future.
    println("")
    FutureGetSquare(5).onComplete{
      case Success(answer)=> println(s" From Future Method $answer ");
      case Failure(_) => println("Not yet printed");
    };
    def future(list: List[Int]):Future[Int] = {
      val ans=list.sum
      val answer=Future(ans)
//      print(answer)
      answer
    }
    val b = Future(List(1,2,3,4,5))
    (b.onComplete {
      case Success(value)=> print(s"${future(value)}")
      case Failure(e)=> print("failed");
    })
    val a = Future(5/0)
//    val result = c.map(_ * 2)
//    print(result)
    (a.onComplete {
      case Success(value) => print(s"Success")
      case Failure(e) => throw new Exception;
    })
    val v = {
      Future {
        Thread.sleep(1000)
      }
      Future {
        Thread.sleep(1000)
      }
      Future {
        Thread.sleep(1000)
      }
      Future {
        Thread.sleep(1000)
      }
      Future {
        Thread.sleep(1000)
        print("hello")
      }
    }
    val c=Future(Future(5));
    c.map(_.map(println))
    Thread.sleep(3000);
  }
}
