# 📐 Principios SOLID en Java  
Programación Avanzada — Trabajo Práctico N° 2
>**Integrantes:** Fedra Macario, Brunella Malanca y Sofía Pereyra

## 📌 Descripción
Refactorización de una aplicación bancaria en Java aplicando el
**Principio de Responsabilidad Única (SRP)** de los principios SOLID.

## 🎯 Objetivo
Separar las responsabilidades de una clase monolítica (`CuentaBancaria`)
en clases independientes, donde cada una tiene una única razón para cambiar.

## 🗂️ Estructura del proyecto

| Clase               | Responsabilidad                              |
|---------------------|----------------------------------------------|
| `CuentaBancaria`    | Gestionar datos y operaciones de saldo        |
| `ImpresionCuenta`   | Mostrar los detalles de la cuenta en consola  |
| `NotificacionEmail` | Enviar notificaciones por correo electrónico  |
| `AplicacionBancaria`| Orquestar el flujo general del programa       |
