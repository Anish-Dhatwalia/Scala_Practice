object TrappingRainWater {
  def next(ints: List[Int]):List[Int]={
    ints match {
    case nxt::next1=> next1;
  }
  }
  def ans(ints: List[Int], ints1: List[Int], ints2: List[Int]): Int = {
    if(ints==Nil) {
      0
    };
    else{

      val sum=ans(next(ints),ints1.tail,ints2.tail)
      var temp=sum;
      if (ints.head > ints1.head) {
        temp+=ints1.head - ints2.head;
      }
      else
        temp+=ints.head-ints2.head
      temp
    }
  }
  def find_ans_trapping_rain_water(ints: List[Int]): Int = {
    var maximum=0;
    var leftMax:List[Int]=Nil
    ints.foreach(x=>{leftMax::=(maximum max x);maximum=maximum max x})
    leftMax=leftMax.reverse
    var rightMax: List[Int] = Nil
    ints.foreach(x => {
      if (maximum > x) rightMax = (maximum :: rightMax) else {
        rightMax = (x :: rightMax); maximum = x
      };})
    ans(rightMax,leftMax,ints);

  }
  def main(args: Array[String]): Unit = {
    println("Foreach");
    val list:List[Int]=List.range(1 , 9);
//    list.foreach(x=>println(x));
    println(find_ans_trapping_rain_water(List(2,4,0,2,2,5)));
  }
}
