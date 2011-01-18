import org.specs.Specification
import org.specs.mock.Mockito
import org.mockito.Matchers._

trait Printer {
  def print(value : String)
}

class SimplePrinter extends Printer {
  def print(value : String) {
    println(value)
  } 
}

class FizzPrinter(calculator : FizzCalculator, printer : Printer){

  def printFrom1To100 {
    (1 until 100 inclusive) foreach { value => printer.print(calculator.calculate(value)) }
  }
}

class fizzPrinterSpec extends Specification with Mockito {
  "Fizzprinter" should {
    "print fizzbuzz for numbers for 1 to 100" in {
       val fizzCalculator = mock[FizzCalculator]
       val printer = mock[Printer]
       val from1to100 = 1 until 100 inclusive

       val fizzPrinter = new FizzPrinter(fizzCalculator,printer)

       from1to100 foreach {value => fizzCalculator.calculate(value) returns value.toString }

       fizzPrinter.printFrom1To100

       from1to100 foreach { value => there was one(fizzCalculator).calculate(value) }
       from1to100 foreach { value => there was one(printer).print(value.toString) }
       
    }
  }
}
