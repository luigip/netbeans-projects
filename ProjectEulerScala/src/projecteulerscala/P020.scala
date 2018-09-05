
package projecteulerscala

object P021 extends App {
  def d(n: Int) = (1 until n).filter(n % _ == 0).sum
  def amic(n: Int) = (1 until n).filter(i => d(i) != i && i == d(d(i)))
  val result = amic(10000).sum
  println(result)
}
