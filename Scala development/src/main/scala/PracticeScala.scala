object PracticeScala {
// second last
def secondLast(list: List[Int]): Int = {
  list match {
    case list :: _ :: Nil => {
      list
    }
    case _ :: ls => {
      val secondlastelement = secondLast(ls);
      secondlastelement;
    }
  }
}

  // find kth element
  def findkthele(k:Int,list: List[Int]): Int = {
    if(k==0)
      {
        list match {
          case list::x=>
          return list;
        }
      }
    list match {
      case list :: Nil => {
        list
      }
      case list :: ls => {
        findkthele(k-1,ls);
      }
    }
  }
//
//  flatten
  def flatten[T](list: List[Any]): List[T] = {
//    var flatList:List[T]=Nil
    list flatMap (x =>
      x match{
        case listAny: List[List[_]] => flatten(listAny)
        case listInt: List[T] => listInt
        case singleVal:T => List(singleVal)
      }
)

}
//  // reverse
  def reverse(list: List[Int]): List[Int] = {
    list match {
      case list :: Nil => {
        List(list);
      }
      case list :: ls=> {
        (reverse(ls):+(list))
      }
    }
  }
  // last
  def last(list:List[Int]):Int={
    list match {
      case last :: Nil =>
        last
      case _ :: ls => {
        last(ls)
      }
    }
  }
  def main(args: Array[String]) : Unit = {
    println(last(List(1,2,3,4,5,6,7)));
    println(secondLast(List(1,2,3,4,5,6)));

    println(reverse(List(1,2,3,4,5,6)))
    println(findkthele(3,List(1,2,3,4,5,6)))
    println(List(1,2,3,4).size)
    println(flatten(List(List(1,2,3),List(2,3,List(4,8)),2,3,6,8,6,7,8,Nil,8,2)))
    println(flatten(List('a','b','c',List('e','o'),List('f',List('w','r')))))
  }
}
