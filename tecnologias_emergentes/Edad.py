#Practica 4
loop = 1
while loop != 0:
    print("Cual es tu edad?")
    edad_str = input(": ")
    edad = int(edad_str)
    mensaje = ""

    if edad >= 60:
        mensaje = "Eres viejo"
    elif edad >= 18 and edad < 60:
        mensaje = "Eres un adulto"
    elif edad >= 15 and edad < 18:
        mensaje = "Eres joven"
    elif edad >= 10 and edad < 15:
        mensaje = "Eres un adolescente"
    else:
        break

    print(mensaje)
