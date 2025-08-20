# Simulador de Propagación de Virus en Malla Celular

## Descripción del Proyecto

Este proyecto educativo implementa una simulación de propagación de virus en una malla celular de 10x10, inspirada en el concepto del Juego de la Vida de Conway pero con mecánicas adaptadas para modelar comportamientos virales. La aplicación permite visualizar cómo un virus se propaga a través de generaciones, con reglas específicas que gobiernan la infección, supervivencia y muerte de las células.

## Características Principales

- **Malla interactiva** de 10x10 células con estados dinámicos
- **Sistema de generaciones** con evolución basada en reglas predefinidas
- **Mecánica de infección** en dos ciclos diferenciados
- **Historial completo** de hasta 1000 generaciones
- **Interfaz visual** que muestra el estado actual de la simulación
- **Sistema de logging** que registra todos los eventos significativos

## Mecánicas de Simulación

### Estados de las Células

- **Célula sana (0)**: No infectada, susceptible al virus
- **Célula infectada (1)**: Portadora del virus, capaz de propagarlo

### Ciclos de Generación

#### Generación 1 - Fase de Infección

Las células infectadas ("células madre") contagian a todas las células sanas adyacentes (incluyendo diagonales)

#### Generación 2 - Fase de Mortalidad

Las células infectadas rodeadas por 5 o más células infectadas mueren por sobrepoblación viral

## Consideraciones de Rendimiento

**IMPORTANTE**: El código actual requiere una optimización significativa en el manejo de la interfaz de usuario.

### Problemas Identificados

- **Comprobaciones intensivas**: Se realizan verificaciones de estado para cada célula individual en cada iteración
- **Múltiples iteraciones**: Cada actualización implica aproximadamente 10 verificaciones por célula
- **Arquitectura ineficiente**: La verificación de vecinos se realiza mediante condicionales individuales, generando overhead computacional

### Métricas Actuales

- **Consumo de memoria**: Aproximadamente 100MB
- **Uso de CPU**: Aproximadamente 2%
- **Demanda computacional**: Alta debido a la implementación actual

Estas características hacen que la simulación sea más demandante en recursos de lo necesario, representando un área de mejora crítica para futuras versiones.

## Propósito Educativo

Este proyecto fue desarrollado como herramienta educativa para:

- Comprender los fundamentos de autómatas celulares
- Modelar la propagación de entidades biológicas
- Analizar la evolución de sistemas basados en reglas simples
- Estudiar los desafíos de optimización en simulaciones por computadora

## Cómo Utilizar

1. Configure el estado inicial seleccionando células para infectar
2. Inicie la simulación para observar la propagación del virus
3. Navegue entre generaciones para analizar la evolución del sistema
4. Revise el log de eventos para comprender las decisiones del algoritmo

## Futuras Mejoras

- Optimización del algoritmo de comprobación de vecinos
- Implementación de un sistema de visualización más eficiente
- Paralelización de cálculos para mejorar rendimiento
- Ampliación de reglas y estados celulares
- Implementación de diferentes cepas virales con comportamientos unicos

---

Proyecto desarrollado con fines educativos
