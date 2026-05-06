# 📐 Principios SOLID en Java

Programación Avanzada — Trabajo Práctico N° 2
>**Integrantes:** Fedra Macario, Brunella Malanca y Sofía Pereyra

---
 
## ¿Qué son los principios SOLID?
 
Los principios SOLID son cinco reglas de diseño orientado a objetos (POO) propuestas por **Robert C. Martin** (también conocido como "Uncle Bob"). El objetivo de estos principios es ayudar a los desarrolladores a escribir código que sea más fácil de mantener, extender y entender con el tiempo.

| Letra | Principio |
|-------|-----------|
| ![SRP](https://img.shields.io/badge/S-e74c3c?style=for-the-badge) | Principio de Responsabilidad Única (Single Responsibility Principle) |
| ![OCP](https://img.shields.io/badge/O-e67e22?style=for-the-badge) | Principio Abierto/Cerrado (Open/Closed Principle) |
| ![LSP](https://img.shields.io/badge/L-2ecc71?style=for-the-badge) | Principio de Sustitución de Liskov (Liskov Substitution Principle) |
| ![ISP](https://img.shields.io/badge/I-3498db?style=for-the-badge) | Principio de Segregación de Interfaces (Interface Segregation Principle) |
| ![DIP](https://img.shields.io/badge/D-9b59b6?style=for-the-badge) | Principio de Inversión de Dependencias (Dependency Inversion Principle) |

S — Principio de Responsabilidad Única (SRP)
Este principio establece que una clase debe tener una sola razón para cambiar, es decir, debe
encargarse de una única responsabilidad dentro del sistema. Si una clase hace demasiadas cosas a la
vez, cualquier cambio en una de ellas puede afectar a las demás de forma inesperada. Truco para detectarlo: si al describir lo que hace una clase tenés que usar la palabra "y", probablemente tiene más de una responsabilidad.
