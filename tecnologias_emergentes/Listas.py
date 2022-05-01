songsMJ = ["thiller", "beath it", "billie jean", "bad"]
birthdates = ["16-06-1999", "03-12-1992", "29-08-1959", "17-08-1999"]
myList = [1, "hola", "ABC", 22, songsMJ, "Lana del rey", birthdates, 8, True, ";*"]
print("=== Ultimo y primer valor de la lista: " + str(myList[0]) + " " + str(myList[9]))
myList.append(myList)
print("=== Agregando mi lista a la misma lista: ") 
print(myList)
print("=== Mostrando indice 3 de mi sublista 1: ")
print(songsMJ[3])
print("=== Mostrando indice 3 de mi sublista 2: ")
print(birthdates[3])
