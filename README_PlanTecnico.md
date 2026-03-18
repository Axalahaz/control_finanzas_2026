Plan de 4 etapas:
1. Scope técnico del MVP
2. Modelo de datos inicial (simplificado)
3. Diseño de APIs
4. Plan de implementación paso a paso
________________________________________
1. Scope técnico del MVP (concreto)

Incluye
•	Usuario (auth)
•	Ingresos
•	Gastos
•	Balance
NO incluye todavía
•	Alcancía
•	Estadísticas avanzadas
•	Configuración
Recorte del dominio a lo mínimo funcional
________________________________________
2. Modelo de datos inicial (simplificado)

Usuario
User
- id
- nombre
- email
- password
________________________________________
Ingreso
Ingreso
- id
- monto
- fecha
- descripcion
- user_id
Para MVP:
sin TipoIngreso (lo agregamos después)
________________________________________
Gasto
Gasto
- id
- monto 
- fecha
- descripcion
- categoria
- user_id
categoría como string simple (por ahora)
________________________________________
Balance (no se guarda)
balance = SUM(ingreso) - SUM(gasto)
se calcula, no se persiste
________________________________________
3. Diseño de APIs (muy importante)

Publico
Auth
POST /auth/registro
POST /auth/login
________________________________________
Privado
Ingresos
POST   /ingresos
GET    /ingresos
DELETE /ingresos/{id}
________________________________________
Gastos
POST   /gastos
GET    /gastos
DELETE /gastos/{id}
________________________________________
Balance
GET /balance
Respuesta:
{
  "totalIncome": 1000,
  "totalExpense": 400,
  "balance": 600
}
________________________________________
4. Arquitectura real (simplificada para MVP)

Estructura base
com.finanzas

auth
ingreso
gasto
shared
________________________________________
Dentro de cada módulo
domain
application
infrastructure
interfaces

Para MVP simplificamos a:
controller
service
repository
entity
Después migración a hexagonal limpio.
________________________________________
5. Plan de implementación (paso a paso REAL)

FASE 1 — Setup
1.	Crear proyecto Spring Boot
2.	Configurar:
o	Spring Web
o	Spring Data JPA
o	Spring Security
o	PostgreSQL
3.	Configurar conexión a DB
________________________________________
FASE 2 — Usuario + Auth
4.	Crear entidad User
5.	Crear UserRepository
6.	Implementar:
o	registro
o	login
7.	Configurar JWT
________________________________________
FASE 3 — Ingresos
8.	Crear entidad Ingreso
9.	Crear repository
10.	Crear service
11.	Crear controller
________________________________________
FASE 4 — Gastos
12.	Crear entidad Gasto
13.	Crear repository
14.	Crear service
15.	Crear controller
________________________________________
FASE 5 — Balance
16.	Crear servicio de cálculo
17.	Endpoint /balance
________________________________________
FASE 6 — Testing manual
18.	Probar todo con:
•	Postman
•	o frontend básico
________________________________________
6. Decisiones técnicas clave
✔ un usuario dueño de todo
✔ balance calculado (no persistido)
✔ separar ingreso / gasto
✔ arquitectura preparada para escalar
________________________________________
7. Después del MVP, volver a DDD completo:
•	agregar TipoIngreso
•	agregar CategoriaGasto como entidad
•	agregar Alcancia
•	mejorar agregados