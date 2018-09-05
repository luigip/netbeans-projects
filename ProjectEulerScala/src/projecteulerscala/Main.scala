
package projecteulerscala

//object Main extends App {
//  P005_V3
//}
//object P006 {
//  val MAX = 10
//  val sumsq = ((1 to MAX) foreach [Int] {x => x * x}) sum
//  val s = (1 to MAX) sum
//  println(sumsq - s * s)
//  
//}

object P005_V3 extends App {
  def isDivis(x:Int, i:Int):Boolean = {
    if(i > 20) true
    else if(x % i != 0) false
    else isDivis(x, i+1)
  }
  def find(n:Int):Int = if (isDivis(n, 2)) n else find (n+2)
  val t = System.nanoTime
//  println (find (2))
  println(System.nanoTime - t)
}

object P018 extends App {
  val lines= io.Source.fromFile("C:/Users/Rhys/IdeaProjects/IJEuler/src/P018.txt").getLines()
               .map(_.split(" ").map(_.toInt).toList).toList

  def combineRows(r1: List[Int], r2: List[Int] ): List[Int] = r1 match {
    case Nil       => Nil
    case h :: tail => (h + (r2(0) max r2(1))) :: combineRows (r1.tail, r2.tail)
  }

  val result = lines.reduceRight(combineRows(_,_)) (0)
  println(result)
}

