class Usuario:
  def __init__(self, nombre, edad, sexo):
    self.nombre = nombre
    self.edad = edad
    self.sexo = sexo
    
  def getNombre(self):
    return "" + self.nombre

  def getEdad(self):
    return "" + self.edad
  
  def getSexo(self):
    return "" + self.sexo
  
  def __repr__(self):
    return " Nombre: " + self.nombre + " Edad: " + self.edad + " Sexo: " + self.sexo

#Menu
usuarios = []
loop = 1
while loop != 0:
  print("======Menu=====")
  print("1. Agregar usuario")
  print("2. Mostrar")
  print("3. Buscar")
  print("0. Salir")
  opcion = input(": ")
  if opcion=="1":
      print("---Agregar usuario---")
      nombre = input("Nombre: ")
      edad = input("Edad: ")
      sexo = input("Sexo: ")
      user = Usuario(nombre, edad, sexo)
      usuarios.append(user)
  elif opcion=="2":
      print("---Mostrar---")
      print(usuarios)
  elif opcion=="3":
      print("---Buscar---")
      busqueda = input("Escribe el nombre a buscar: ")
      for u in usuarios:
          if busqueda == u.getNombre():
              print("Usuario encontrado! ")
              print("--Datos--")
              print(u.getNombre())
              print(u.getEdad())
              print(u.getSexo())
          else:
              print("Usuario no encontrado")
  else:
    loop = 0
    break
  