# Soma de dois números
print("--------------------------------")
print("Vamos somar dois números:")
num1 = float(input("Digite o primeiro número: "))
num2 = float(input("Digite o segundo número: "))
soma = num1 + num2
print("A soma é:", soma)

# Par ou Ímpar
print("--------------------------------")
print("Vamos verificar se é par ou ímpar")
numero = int(input("Digite um número inteiro: "))
if numero % 2 == 0:
    print("O número é par.")
else:
    print("O número é ímpar.")

# Maior de três números
print("--------------------------------")
print("Vamo verificar qual dos 3 números é o maior")
num1 = float(input("Digite o primeiro número: "))
num2 = float(input("Digite o segundo número: "))
num3 = float(input("Digite o terceiro número: "))
maior = num1
if num2 > maior:
    maior = num2
if num3 > maior:
    maior = num3
print("O maior número é:", maior)

# Contagem de 1 a 10
print("--------------------------------")
print("Vamos contar de 1 a 10")
for i in range(1, 11):
    print(i)

# Tabuada de um número
print("--------------------------------")
print("Vamos verificar a tabuada")
numero = int(input("Digite um número para ver a tabuada: "))
for i in range(1, 11):
    print(f"{numero} x {i} = {numero * i}")

# Verificação de idade
print("--------------------------------")
print("Vamos verificar se é maior ou menor de idade")
idade = int(input("Digite sua idade: "))
if idade >= 18:
    print("Maior de idade")
else:
    print("Menor de idade")

# Soma de números pares de 1 a 100
print("--------------------------------")
print("Vamos somar os números pares de 1 a 100")
soma_pares = 0
for i in range(1, 101):
    if i % 2 == 0:
        soma_pares += i
print("A soma dos números pares de 1 a 100 é:", soma_pares)
