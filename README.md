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

## 🧩🔴 S — Principio de Responsabilidad Única (SRP)
"Una clase debe tener una sola razón para cambiar."

Establece que cada clase debe encargarse de una única responsabilidad dentro del sistema. Si una clase hace demasiado, cualquier cambio puede generar errores inesperados.

💡 Truco para detectarlo: Si al describir lo que hace una clase tenés que usar la palabra "y", probablemente tenga más de una responsabilidad.

🚀 ¿Cuándo aplicarlo?: * Cuando una clase mezcla lógica de negocio con acceso a la base de datos.

Cuando un cambio pequeño obliga a modificar partes del código que no tienen nada que ver.

Cuando una clase crece tanto que se vuelve difícil de leer.

Ejemplo Práctico
❌ Sin el principio: Una clase Factura que se crea, se imprime y se guarda en BD.
✅ Aplicando el principio: Se separa en clases independientes.

Java
// Cada clase con un único propósito
class GeneradorFactura { Factura crearFactura() { ... } }
class ImpresoraFactura { void imprimir(Factura f) { ... } }
class RepositorioFactura { void guardar(Factura f) { ... } }
Ventajas: Clases más pequeñas, fáciles de testear y reutilizables.

## 🟠 O — Principio Abierto/Cerrado (OCP)
"Abierto para extensión, cerrado para modificación."

Significa que podés agregar nueva funcionalidad sumando código nuevo, sin tener que tocar el que ya existe y funciona bien.

⚠️ Señal de alerta: Si cada vez que aparece un nuevo tipo de objeto tenés que abrir una clase y modificar un switch o un if.

🚀 ¿Cuándo aplicarlo?: * Cuando el sistema necesita soportar nuevos tipos de objetos con frecuencia.

Cuando trabajás en equipo y modificar código existente puede afectar a otros.

Ejemplo Práctico
Java
// ✅ Usando herencia y polimorfismo
abstract class Empleado { abstract void calcularBono(); }

class Programador extends Empleado {
    void calcularBono() { bono = sueldo * 2; }
}
// Para un tipo nuevo, solo agregás una nueva clase.
Ventajas: Agregás funciones sin arriesgarte a romper lo que ya funciona.

## 🟣 L — Principio de Sustitución de Liskov (LSP)
"Las subclases deben poder sustituir a sus clases base."

Una subclase no debería romper el comportamiento esperado por quien usa la clase base.

⚠️ Señal de alerta: El uso de instanceof para saber qué tipo de objeto tenemos antes de actuar.

🚀 ¿Cuándo aplicarlo?: Siempre que diseñes jerarquías de herencia o colecciones de objetos que comparten una base.

Ejemplo Práctico
Java
// ✅ El cliente no necesita conocer los tipos concretos
for (Empleado e : empleados) {
    e.calcularBono(); // Funciona igual para cualquier tipo de empleado
}
Ventajas: Código más simple y resistente a errores de jerarquía.

## 🧩 I — Principio de Segregación de Interfaces (ISP)
"Mejor muchas interfaces pequeñas que una sola interfaz grande."

Una clase no debería verse obligada a implementar métodos que no usa.

⚠️ Señal de alerta: Clases con métodos vacíos o que lanzan la excepción "NotSupportedException".

🚀 ¿Cuándo aplicarlo?: Cuando definís contratos para clases con capacidades muy diferentes entre sí.

Ejemplo Práctico
Java
// ✅ Interfaces específicas
interface IAlimentable { void alimentar(); }
interface IMascota { void acariciar(); }

class Perro implements IAlimentable, IMascota { ... }
class Escorpion implements IAlimentable { ... } // Solo lo que necesita
Ventajas: Interfaces claras y fácil mantenimiento de contratos.

##  D — Principio de Inversión de Dependencias (DIP)
"Depende de abstracciones, no de clases concretas."

Las clases de alto nivel no deben depender de detalles de bajo nivel (como bases de datos o APIs).

⚠️ Señal de alerta: Uso de new ClaseConcreta() dentro de la lógica principal (acoplamiento fuerte).

🚀 ¿Cuándo aplicarlo?: Al interactuar con recursos externos o cuando querés hacer pruebas unitarias con Mocks.

Ejemplo Práctico
Java
// ✅ Inyección de dependencias
class Volvo {
    private IMotor _motor;
    public Volvo(IMotor motor) { // Depende de la interfaz IMotor
        _motor = motor;
    }
}
Ventajas: Podés cambiar la implementación (ej. cambiar motor o base de datos) sin tocar la lógica del sistema.
