# SQL AVANZADO

1. [Relaciones entre tablas](#id1)

## RELACIONES ENTRE TABLAS <a name="id1" />
    SELECT campo1, campo2 FROM tabla1, tabla2 WHERE key1=key2;

Empleados:

| NEMP | NOM | CODDEP |
| -- | -- | -- | 
| 1001 | Juan | 10 |
| 1001 | Pedro | 20 |
| 1001 | Mitja | 20 |

Departamentos: 

| CODDEP | DESCRIPCIO |
| -- | -- |
| 10 | Compres |
| 20 | Vendes |

| NEMP | NOM | CODDEP | CODDEP | DESCRIPCIO |
| -- | -- | -- | -- | -- |
| 1001 | Juan | 10 | 10 | Compres |
| 1001 | Juan | 10 | 20 | Vendes |
| 1002 | Pedro | 20 | 10 | Compres |
| 1002 | Pedro | 20 | 20 | Vendes |
| 1003 | Mitja | 20 | 10 | Compres |
| 1003 | Mitja | 20 | 20 | Vendes |