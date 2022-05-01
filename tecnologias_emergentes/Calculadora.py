class Calculadora:
  x = 0
  y = 0
  
  def sumar(self, x, y):
    return x + y

  def restar(self, x, y):
    return x - y

  def multiplicar(self, x, y):
    return x * y

  def dividir(self, x, y):
    return x / y

  def modulo(self, x, y):
    return x % y

  def exponente(self, x, y):
    return x ** y

calculadora = Calculadora()
loop = 1
while loop != 0:
  print("======Calculadora=====")
  print("1. Sumar")
  print("2. Restar")
  print("3. Multiplicar")
  print("4. Dividir")
  print("5. Modulo")
  print("6. Exponente")
  print("0. Salir")
  opcion = input(": ")
  if opcion=="1":
      print("---Sumar---")
      x = input("numero 1: ")
      y = input("numero 2: ")
      print(str(x) + "+" + str(y) + " = " + str(calculadora.sumar(int(x), int(y))))

  elif opcion=="2":
      print("---Restar---")
      x = input("numero 1: ")
      y = input("numero 2: ")
      print(str(x) + "-" + str(y) + " = " + str(calculadora.restar(int(x), int(y))))

  elif opcion=="3":
      print("---Multiplicar---")
      x = input("numero 1: ")
      y = input("numero 2: ")
      print(str(x) + "*" + str(y) + " = " + str(calculadora.multiplicar(int(x), int(y))))

  elif opcion=="4":
      print("---Dividir---")
      x = input("numero 1: ")
      y = input("numero 2: ")
      print(str(x) + "/" + str(y) + " = " + str(calculadora.dividir(int(x), int(y))))

  elif opcion=="5":
      print("---Modulo---")
      x = input("numero 1: ")
      y = input("numero 2: ")
      print(str(x) + "%" + str(y) + " = " + str(calculadora.modulo(int(x), int(y))))

  elif opcion=="6":
      print("---Exponente---")
      x = input("base: ")
      y = input("exponente: ")
      print("El resultado es " + str(calculadora.exponente(int(x), int(y))))
  
  else:
    loop = 0
    break
