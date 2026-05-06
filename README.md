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

---
 
## S — Principio de Responsabilidad Única (SRP)
![SRP](https://img.shields.io/badge/S%20%E2%80%94%20SRP-Principio%20de%20Responsabilidad%20%C3%9Anica-e74c3c?style=for-the-badge&logoColor=white)
 
### ¿En qué consiste?
Una clase debe tener **una sola razón para cambiar**, es decir, debe encargarse de una única responsabilidad dentro del sistema.
 
> 💡 **Truco para detectarlo:** si al describir lo que hace una clase tenés que usar la palabra **"y"**, probablemente tiene más de una responsabilidad.
 
### ¿Cuándo conviene aplicarlo?
- Cuando una clase mezcla lógica de negocio con acceso a la base de datos.
- Cuando un cambio pequeño obliga a modificar partes del código que no tienen nada que ver.
- Cuando una clase crece demasiado y se vuelve difícil de leer o entender.
### Ejemplo en Java
 
```java
// ❌ Sin el principio — tiene 3 razones para cambiar
public class Factura {
    void crearFactura()   { ... }
    void imprimirFactura() { ... }
    void guardarFactura()  { ... }
}
 
// ✅ Aplicando el principio — cada clase tiene una sola razón
class GeneradorFactura  { Factura crearFactura(...)  { ... } }
class ImpresoraFactura  { void imprimir(Factura f)   { ... } }
class RepositorioFactura { void guardar(Factura f)   { ... } }
```
 
### Ventajas
- Cada clase es más pequeña y fácil de entender.
- Si cambia la lógica de impresión, no hay riesgo de romper la persistencia de datos.
- Las clases separadas se pueden reutilizar en otros contextos más fácilmente.
---
 
## O — Principio Abierto/Cerrado (OCP)
![OCP](https://img.shields.io/badge/O%20%E2%80%94%20OCP-Principio%20Abierto%2FCerrado-e67e22?style=for-the-badge&logoColor=white)
 
### ¿En qué consiste?
El código debería estar **abierto para ser extendido, pero cerrado para ser modificado**. Si se necesita agregar nueva funcionalidad, lo ideal es hacerlo sumando código nuevo sin tocar el que ya existe.
 
> ⚠️ **Señal de violación:** si cada vez que aparece un nuevo tipo de objeto hay que abrir una clase ya existente y modificarla, el diseño no cumple con OCP.
 
### ¿Cuándo conviene aplicarlo?
- Cuando el sistema necesita soportar nuevos tipos de objetos con frecuencia.
- Cuando los cambios de requisitos son frecuentes y previsibles.
- Cuando se trabaja en equipo y modificar código existente puede afectar lo que otros desarrollaron.
### Ejemplo en Java
 
```java
// ❌ Sin el principio — hay que modificar la clase con cada tipo nuevo
void calcularBonos() {
    switch (empleado.tipo) {
        case PROGRAMADOR: bono = sueldo * 2;  break;
        case GERENTE:     bono = sueldo * 10; break;
        // Hay que modificar esto cada vez que hay uno nuevo
    }
}
 
// ✅ Aplicando el principio — se extiende agregando una nueva clase
abstract class Empleado { abstract void calcularBono(); }
 
class Programador extends Empleado {
    void calcularBono() { bono = sueldo * 2; }
}
// Para un tipo nuevo, solo se agrega una nueva clase
```
 
### Ventajas
- Se puede agregar funcionalidad sin arriesgarse a romper lo que ya funciona.
- El código existente queda estable y no necesita volver a probarse.
- Se evitan los bloques condicionales que crecen sin control.
---
 
## L — Principio de Sustitución de Liskov (LSP)
![LSP](https://img.shields.io/badge/L%20%E2%80%94%20LSP-Principio%20de%20Sustituci%C3%B3n%20de%20Liskov-27ae60?style=for-the-badge&logoColor=white)
 
### ¿En qué consiste?
Si tenemos una clase base y una subclase, deberíamos poder **usar la subclase en cualquier lugar donde se usa la clase base** sin que el programa se comporte de manera incorrecta.
 
> ⚠️ **Señal de violación:** si en alguna parte del código se usa `instanceof` para saber exactamente qué tipo de objeto tenemos antes de actuar, probablemente LSP no se está respetando.
 
### ¿Cuándo conviene aplicarlo?
- Siempre que se diseñe una jerarquía de herencia.
- Cuando se trabaja con listas o colecciones de objetos que comparten una clase base.
- Antes de hacer que una subclase lance una excepción en un método que la clase base no lanza.
### Ejemplo en Java
 
```java
// ❌ Sin el principio — el cliente necesita conocer los tipos concretos
for (Empleado e : empleados) {
    if (e instanceof Programador)   e.bono = e.sueldo * 2;
    else if (e instanceof Gerente)  e.bono = e.sueldo * 10;
}
 
// ✅ Aplicando el principio — cada subclase sabe cómo calcular su bono
for (Empleado e : empleados) {
    e.calcularBono(); // No importa si es Programador o Gerente
}
```
 
### Ventajas
- El código que usa la clase base queda más simple y no necesita conocer los tipos concretos.
- Se pueden agregar nuevas subclases sin modificar el código ya existente.
- Se complementa muy bien con OCP: se puede extender sin modificar.
---
 
## I — Principio de Segregación de Interfaces (ISP)
![ISP](https://img.shields.io/badge/I%20%E2%80%94%20ISP-Principio%20de%20Segregaci%C3%B3n%20de%20Interfaces-2980b9?style=for-the-badge&logoColor=white)
 
### ¿En qué consiste?
Es mejor tener **varias interfaces pequeñas y específicas** que una sola interfaz grande y general. Una clase no debería verse obligada a implementar métodos que no va a usar.
 
> ⚠️ **Señal de violación:** si una clase implementa un método con el cuerpo vacío o lanzando una excepción del tipo "no soportado", la interfaz le está pidiendo algo que no tiene sentido para esa clase.
 
### ¿Cuándo conviene aplicarlo?
- Cuando distintas clases necesitan usar solo una parte de una misma interfaz.
- Cuando agregar un método a una interfaz obliga a modificar muchas clases que no lo necesitan.
- Al definir contratos para clases con capacidades muy diferentes entre sí.
### Ejemplo en Java
 
```java
// ❌ Sin el principio — Escorpion no puede acariciarse
abstract class Animal {
    abstract void Alimentar();
    abstract void Acariciar(); // No tiene sentido para todos
}
class Escorpion extends Animal {
    void Alimentar() { ... }
    void Acariciar() { throw new Exception(); } // ❌
}
 
// ✅ Aplicando el principio — interfaces separadas por capacidad
abstract class Animal    { abstract void Alimentar(); }
interface IMascota       { void Acariciar(); }
 
class Perro extends Animal implements IMascota {
    void Alimentar() { ... }
    void Acariciar() { ... } // ✅ Tiene sentido para Perro
}
class Escorpion extends Animal {
    void Alimentar() { ... } // Solo implementa lo que le corresponde
}
```
 
### Ventajas
- Cada clase implementa solo lo que tiene sentido para ella.
- Las interfaces quedan más claras y fáciles de entender.
- Agregar un nuevo método a `IMascota` no afecta a `Escorpion` ni a ningún otro animal.
---
 
## D — Principio de Inversión de Dependencias (DIP)
![DIP](https://img.shields.io/badge/D%20%E2%80%94%20DIP-Principio%20de%20Inversi%C3%B3n%20de%20Dependencias-8e44ad?style=for-the-badge&logoColor=white)
 
### ¿En qué consiste?
Las clases de alto nivel **no deben depender directamente de clases de bajo nivel**. Ambas deben depender de abstracciones (interfaces o clases abstractas).
 
> ⚠️ **Señal de violación:** si dentro de la lógica de negocio se usa `new ClaseConcreta()` para crear un objeto de infraestructura, esa clase queda fuertemente acoplada y es muy difícil de testear.
 
### ¿Cuándo conviene aplicarlo?
- Cuando la lógica de negocio necesita interactuar con bases de datos, APIs externas o el sistema operativo.
- Cuando se quieren hacer pruebas unitarias sin depender de recursos reales.
- Cuando se quiere poder cambiar una implementación sin tocar el resto del sistema.
### Ejemplo en Java
 
```java
// ❌ Sin el principio — depende directamente de DateTime.Now
class HolaMundo {
    String saludar(String nombre) {
        if (DateTime.Now.Hour < 12) return "Buenos dias";
        // No se puede testear fácilmente
    }
}
 
// ✅ Aplicando el principio — la dependencia se inyecta desde afuera
class HolaMundo {
    DateTime _hora;
    HolaMundo(DateTime hora) { _hora = hora; } // Inyección
    String saludar(String nombre) {
        if (_hora.Hour < 12) return "Buenos dias";
    }
}
```
 
```java
// ❌ Sin el principio — acoplado a un motor concreto
class Volvo {
    private B20 _motor;
    public Volvo() { _motor = new B20(); } // Solo puede tener motor B20
}
 
// ✅ Aplicando el principio — depende de una abstracción
class Volvo {
    private IMotor _motor;
    public Volvo(IMotor motor) { _motor = motor; } // Acepta cualquier motor
}
// new Volvo(new NuevoMotorV12()); ✅
```
 
### Ventajas
- El código se puede testear de forma aislada usando objetos de prueba (mocks).
- Se puede cambiar la implementación concreta sin modificar la lógica principal.
- El sistema queda mucho más flexible y modular.
---

## Cuadro Comparativo

| Principio | Problema que resuelve | Cuándo usarlo | Señales de violación |
|---|---|---|---|
|![SRP](https://img.shields.io/badge/S-e74c3c?style=for-the-badge) | Clases con múltiples responsabilidades acopladas | Cuando una clase tiene más de una razón para cambiar o es difícil de testear | Clase muy larga; métodos sin relación; cambios frecuentes en áreas distintas |
| ![OCP](https://img.shields.io/badge/O-e67e22?style=for-the-badge) | Modificar código ya probado al agregar funcionalidad | Cuando la lógica crece con nuevos casos o hay variantes frecuentes | Cadenas de `if/switch` que crecen cada vez que se agrega un caso nuevo |
| ![LSP](https://img.shields.io/badge/L-2ecc71?style=for-the-badge) | Subclases que rompen el comportamiento de la clase base | Al diseñar jerarquías de herencia o usar polimorfismo | Subclase lanza `UnsupportedOperationException` o deja métodos vacíos |
| ![ISP](https://img.shields.io/badge/I-3498db?style=for-the-badge)  | Interfaces con métodos irrelevantes para sus implementadores | Al definir contratos entre módulos con necesidades distintas | Implementaciones con métodos vacíos o que lanzan excepciones |
| ![DIP](https://img.shields.io/badge/D-9b59b6?style=for-the-badge) | Acoplamiento directo a implementaciones concretas | Acceso a BD, APIs externas o código que deba ser testeable | `new ConcreteClass()` dentro de clases de alto nivel |

> Los principios SOLID no son reglas absolutas, sino guías de diseño. Aplicarlos con criterio y en el contexto adecuado produce sistemas Java más robustos y mantenibles.
