# Simulador de Propagación de Virus en Malla Celular

🦠 Descripción del Proyecto
Este proyecto educativo implementa una simulación de propagación de virus en una malla celular de 10x10, inspirada en el concepto del Juego de la Vida de Conway pero con mecánicas adaptadas para modelar comportamientos virales. La aplicación permite visualizar cómo un virus se propaga a través de generaciones, con reglas específicas que gobiernan la infección, supervivencia y muerte de las células.

🔬 Características Principales
Malla interactiva de 10x10 células con estados dinámicos

Sistema de generaciones con evolución basada en reglas predefinidas

Mecánica de infección en dos ciclos diferenciados

Historial completo de hasta 1000 generaciones

Interfaz visual que muestra el estado actual de la simulación

Sistema de logging que registra todos los eventos significativos

⚙️ Mecánicas de Simulación
Estados de las Células
Célula sana (0): No infectada, susceptible al virus

Célula infectada (1): Portadora del virus, capaz de propagarlo

Ciclos de Generación
Generación 1 - Fase de Infección:

Las células infectadas ("células madre") contagian a todas las células sanas adyacentes (incluyendo diagonales)

Generación 2 - Fase de Mortalidad:

Las células infectadas rodeadas por 5 o más células infectadas mueren por sobrepoblación viral

⚠️ Consideraciones de Rendimiento
IMPORTANTE: El código actual requiere una optimización significativa en el manejo de la interfaz de usuario. En la implementación actual:

Se realizan comprobaciones de estado para cada célula individual en cada iteración

Cada actualización implica varias verificaciones por célula

Aunque el consumo de memoria se mantiene alrededor de 100MB y el uso de CPU en aproximadamente 2%, la implementación es computacionalmente demandante

La arquitectura actual verifica cada vecino de cada célula mediante condicionales individuales, lo que genera overhead computacional

Estas características hacen que el simulation sea más resource-intensive de lo necesario, representando un área de mejora crítica para futuras versiones.

🧪 Propósito Educativo
Este proyecto fue desarrollado como herramienta educativa para:
Comprender los fundamentos de autómatas celulares
Modelar la propagación de entidades biológicas
Analizar la evolución de sistemas basados en reglas simples
Estudiar los desafíos de optimización en simulaciones por computadora

🚀 Cómo Utilizar
Configure el estado inicial seleccionando células para infectar
Inicie la simulación para observar la propagación del virus
Navegue entre generaciones para analizar la evolución del sistema
Revise el log de eventos para comprender las decisiones del algoritmo

🔮 Futuras Mejoras
Optimización del algoritmo de comprobación de vecinos
Implementación de un sistema de visualización más eficiente
Paralelización de cálculos para mejorar rendimiento
Ampliación de reglas y estados celulares
Implementación de diferentes cepas virales con comportamientos únicos
