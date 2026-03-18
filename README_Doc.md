# 1. Objetivos específicos
El sistema deberá permitir:

<ol type="a">
  <li>Registrar ingresos financieros clasificados por tipo.</li>
  <li>Registrar gastos clasificados por categorías.</li>
  <li>Definir objetivos de ahorro.</li>
  <li>Registrar aportes de ahorro hacia objetivos definidos.</li>
  <li>Visualizar estadísticas financieras por periodos de tiempo.</li>
  <li>Analizar el balance financiero personal.</li>
  <li>Activar o desactivar funcionalidades financieras del sistema (billetera y alcancía).</li>
</ol>

# 2. Alcance del proyecto
### Dentro del alcance
El sistema incluirá:
#### *Gestión de usuarios*
-	registro de usuario
-	autenticación
-	activación y desactivación de cuenta
#### *Gestión de gastos*
-	creación de categorías de gasto
-	registro de gastos
-	edición de gastos
-	visualización de gastos
#### *Gestión de ingresos*
-	gestión de tipos de ingreso
-	registro de ingresos
-	edición de ingresos
#### *Gestión de ahorro*
-	creación de objetivos de ahorro
-	registro de aportes de ahorro
-	seguimiento del progreso de objetivos
#### *Estadísticas financieras*
-	análisis por categoría
-	análisis por periodo
-	comparaciones anuales
-	gráficos de distribución
#### *Configuración del sistema*
-	activación y desactivación de billetera
-	activación y desactivación de alcancía
#### *Interfaz web responsive*
-	acceso desde navegador
-	diseño adaptable a dispositivos móviles
#### *Landing pública optimizada para buscadores*

### Fuera del alcance (por ahora)
Para mantener el proyecto controlado, no se incluirán en esta fase:
-	integración con bancos
-	sincronización automática de movimientos financieros
-	gestión de inversiones
-	multiusuario o cuentas compartidas
-	gestión de múltiples billeteras
-	integración con APIs financieras externas
Esto permite mantener el sistema enfocado y manejable en su primera versión.

# 3. Riesgos iniciales del proyecto
Identificación temprana de riesgos técnicos.
### *Riesgo 1* — Complejidad del modelo de dominio
El sistema incluye múltiples entidades financieras relacionadas, lo que puede generar complejidad en la consistencia del dominio si no se define correctamente la arquitectura.
Mitigación
Aplicar principios de Domain-Driven Design y separar correctamente los contextos del dominio.

### *Riesgo 2* — Carga en consultas estadísticas
Las consultas de estadísticas pueden volverse costosas si el volumen de datos crece significativamente.
Mitigación
Diseñar consultas optimizadas y considerar read models o agregaciones futuras.

### *Riesgo 3* — Escalabilidad futura
Si el sistema crece, puede requerirse una arquitectura más distribuida.
Mitigación
Diseñar el sistema como un monolito modular, permitiendo separar módulos en microservicios si fuera necesario.

### *Riesgo 4* — Seguridad del sistema
La aplicación maneja datos financieros personales, lo que requiere una autenticación segura.
Mitigación
Uso de Spring Security con JWT y buenas prácticas de seguridad.

# 4. Criterios de éxito del proyecto
El proyecto se considerará exitoso si logra:
-	permitir registrar y visualizar movimientos financieros de forma clara
-	proporcionar estadísticas útiles para el usuario
-	ofrecer una experiencia de uso simple e intuitiva
-	mantener un modelo de dominio coherente y escalable
-	contar con una arquitectura mantenible

# 5. Estrategia de desarrollo
El desarrollo del sistema se realizará siguiendo los siguientes principios:
-	diseño guiado por dominio (Domain-Driven Design)
- arquitectura modular
-	separación clara entre dominio, aplicación e infraestructura
-	desarrollo incremental por funcionalidades
-	validación temprana del modelo de dominio
