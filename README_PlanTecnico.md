# Plan de 4 etapas

1. Scope técnico del MVP  
2. Modelo de datos inicial (simplificado)  
3. Diseño de APIs  
4. Plan de implementación paso a paso  

## 1. Scope técnico del MVP (concreto)

### Incluye
- Usuario (auth)
- Ingresos
- Gastos
- Balance

### NO incluye todavía
- Alcancía
- Estadísticas avanzadas
- Configuración

> Recorte del dominio a lo mínimo funcional

## 2. Modelo de datos inicial (simplificado)

### Usuario

- id
- nombre
- email
- password

### Ingreso

- id
- monto
- fecha
- descripcion
- user_id

> Para MVP: sin TipoIngreso (se agrega después)

### Gasto

- id
- monto
- fecha
- descripcion
- categoria
- user_id

> Categoría como string simple (por ahora)

### Balance (no se guarda)

```text
balance = SUM(ingreso) - SUM(gasto)
```

> se calcula, no se persiste

## 3. Diseño de APIs (muy importante)

### Publico
```text
Auth
POST /auth/registro
POST /auth/loginç
```

### Privado
```text
Ingresos
POST   /ingresos
GET    /ingresos
DELETE /ingresos/{id}
```

```text
Gastos
POST   /gastos
GET    /gastos
DELETE /gastos/{id}
```

```text
Balance
GET /balance
```

```text
Respuesta:
{
  "totalIncome": 1000,
  "totalExpense": 400,
  "balance": 600
}
```

## 4. Arquitectura real (simplificada para MVP)

### Estructura base
```text
com.finanzas

auth
ingreso
gasto
shared
```
### Dentro de cada módulo
```text
domain
application
infrastructure
interfaces
```

### Para MVP simplificamos a:
```text
controller
service
repository
entity
```
Después migración a hexagonal limpio.

# 5. Plan de implementación (paso a paso REAL)

### *FASE 1* — Setup
1.	Crear proyecto Spring Boot
2.	Configurar:
o	Spring Web
o	Spring Data JPA
o	Spring Security
o	PostgreSQL
3.	Configurar conexión a DB

### *FASE 2* — Usuario + Auth
4.	Crear entidad User
5.	Crear UserRepository
6.	Implementar:
o	registro
o	login
7.	Configurar JWT

### *FASE 3* — Ingresos
8.	Crear entidad Ingreso
9.	Crear repository
10.	Crear service
11.	Crear controller

### *FASE 4* — Gastos
12.	Crear entidad Gasto
13.	Crear repository
14.	Crear service
15.	Crear controller

### *FASE 5* — Balance
16.	Crear servicio de cálculo
17.	Endpoint /balance

### *FASE 6* — Testing manual
18.	Probar todo con:
•	Postman
•	o frontend básico

# 6. Decisiones técnicas clave

✔ un usuario dueño de todo

✔ balance calculado (no persistido)

✔ separar ingreso / gasto

✔ arquitectura preparada para escalar


# 7. Después del MVP, volver a DDD completo:
-	agregar TipoIngreso
-	agregar CategoriaGasto como entidad
-	agregar Alcancia
-	mejorar agregados
