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

       val fizzPrinter = new FizzPrinter(fizzCalculator,printer)

       (1 until 100 inclusive) foreach {value => fizzCalculator.calculate(anyInt()) returns value.toString }

       fizzPrinter.printFrom1To100

       (1 until 100 inclusive) foreach { value => there was one(fizzCalculator).calculate(value) }
       (1 until 100 inclusive) foreach { value => there was one(printer).print(value.toString) }
       
    }
  }
}
