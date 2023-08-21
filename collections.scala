object Hello_world extends App {
def testSeq():Unit= {
  println("This is for Sequence: ");
  val sequence = Seq(1,2,3,4);
  val firstElement=sequence(0);
  val extendedSeq=0+:sequence:+5;
  val concat=sequence ++ Seq(1,2,3,4);
  val divisibleBy2=sequence.filter(_%2==0);
  val addBy1=sequence.map(_+1);
  println(s"sequence:- ${sequence}");
  println(s"firstElement:- ${firstElement}");
  println(s"extendedSeq:- ${extendedSeq}");
  println(s"Concatination:- ${concat}");
  println(s"divisibleBy2:- ${divisibleBy2}");
  println(s"sequence flatMap: ${sequence.flatMap(x=>Seq(x,x+1))}");
  println(s"List(List(1,2,3),List(4,5,6)) : ${List(List(1,2,3),List(4,5,6))}");
  println(s"List(List(1,2,3),List(4,5,6)).flatten : ${List(List(1,2,3),List(4,5,6)).flatten}");
  println(s"addBy1${addBy1}");
  val vector=Vector(1,2,3);
  println(s"vector:- ${vector}");
  println("This shows that when we are using a multiple high order functions then it goes from left to right : sequence.map(x=>{println(x+\"'\");x+1;}).map(x=>{println(x);x*2;}).filter(x=>x>1);")
  val multiF=sequence.map(x=>{println(x+"'");x+1;}).map(x=>{println(x);x*2;}).filter(x=>x>1);
  println(s"multiFunctions - : ${multiF}");
}
  def testMap(): Unit = {
    println("This is for Map: ");
    val map=Map(1->"hello", 2->"hey", 3-> "hy",4-> "hi");
    println(s"Map:- ${map}");
    println(s"hi appended with Map values:- ${map.mapValues(x=>x+"hi")}");
    println(s"hi appended with Map:- ${map.map(x=>x+"hi")}");
    println(s"Map values toUpper:- ${map.mapValues(_.toUpperCase())}");
    println(s"adding 1 to Mapvalues :- ${map.mapValues(_+1)}");
  }
  def testRFS(): Unit = {
    //for Reduce, fold, scan
    println("This is for Reduce, fold, scan methods.: ");
    val fst=List(1,2,3,4,5);
    val snd=List("A","B","C","D","E");
    println(s"1st :- ${fst}");
    println(s"2nd :- ${snd}");
    println("this is the way how reduce left works: from left to right and then the sum value is kept with lefts value.")
    println(s"ReduceLeft on fst :- ${fst.reduceLeft((x,y)=> {println(x+","+y);(x+y);})}");
    println("this is the way how reduce right works: from right to left and then the sum value is kept with right value.")
    println(s"ReduceRight on fst :- ${
      fst.reduceRight((x, y) => {
        println(x + "," + y); (x + y);
      })
    }");
    println("this is the way how reduce right works: from right to left and then the sum value is kept with right value.")
    println(s"ReduceRight on snd :- ${
      snd.reduceRight((x, y) => {
        println(x + "," + y);
        (x + y);
      })
    }");
    println(s"foldLeft on fst fst.foldLeft(100)(_+_) :- ${fst.foldLeft(100)(_+_)}");
    println(s"scanLeft on fst fst.scanLeft(100)(_ + _) :- ${fst.scanLeft(100)(_ + _)}");
    println(s"to find the Factorial of a number : (using reduceLeft/reduceRight) :-   "+ fst.reduceLeft(_*_));
  }
def testList(): Unit = {
  val f_list=List(1,23,34);
  var sec_list=List(3,2,4,5);
  sec_list=0::sec_list;
  sec_list=sec_list:+1;
  println(f_list);
  println(sec_list);
  }
def main(args:Array[String]){
//  testSeq();
//  testMap();
//  testRFS();
  testList();
  println("Hello, World");
}
}
