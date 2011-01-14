rm -rf classes
mkdir classes
scalac -cp specs_2.8.1-1.6.7.jar -d classes fizzbuzz.scala
scala -cp specs_2.8.1-1.6.7.jar:classes run fizzBuzzSpec
