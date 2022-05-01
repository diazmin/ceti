myString = "hi, my name is Diana"

print(myString.capitalize())	#Convierte el primer caracter de la cadena en mayuscula
print(myString.casefold())	#Convierte la cadena en minusculas
print(myString.swapcase())	#Cambia de minúsculas a mayúsculas o viceversa
print(myString.upper())	#Convierte la cadena a mayúsculas
print(myString.title())	#Convierte la primera letra de cada palabra en mayúscula
print(myString.center(30))	#Centra la cadena el numero que indiquemos en el argumento
print(myString.count("a"))	#Retorna el numero de veces que aparece un string en la cadena
print(myString.rsplit(" "))	#Corta la cadena dado un separador y retorna los valores en una lista
print(myString.endswith("u"))	#Returna true si la cadena termina en el string especificado
print(myString.find("Diana"))	#Busca el string especificado y retorna el numero del indice donde lo encontró
print(myString.islower())	#Retorna true si todos los caracteres de la cadena están en minúsculas
print(myString.replace("Diana", "Mark Foster"))	#Reemplaza una cadena por otra y retorna el resultado
print(myString.encode("ascii"))	#Convirte una cadena en el unicode que le señalemos

