# SQL AVANZADO

1. [Relaciones entre tablas](#id1)
2. [JOIN](#id2)

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

Cuando realizamos la siguiente sentencia:

    SELECT * FROM EMPLEADOS, DEPARTAMENTOS;

Oracle hace lo que se llama el producto cartesiano de las dos tablas por lo que la tabla resultante quedaria algo asi:

| NEMP | NOM | CODDEP | CODDEP | DESCRIPCIO |
| -- | -- | -- | -- | -- |
| 1001 | Juan | 10 | 10 | Compres |
| 1001 | Juan | 10 | 20 | Vendes |
| 1002 | Pedro | 20 | 10 | Compres |
| 1002 | Pedro | 20 | 20 | Vendes |
| 1003 | Mitja | 20 | 10 | Compres |
| 1003 | Mitja | 20 | 20 | Vendes |

Como vemos lo anterior no tiene mucho sentido y solo nos interesaria quedarnos con los registros en los que el CODDEP sea igual. Para esto utilizamos una clausula WHERE en la que igualemos los dos campos:

    SELECT * FROM EMPLEADOS, DEPARTAMENTOS WHERE EMPLEADOS.CODDEP = DEPARTAMENTOS.CODDEP;

    SELECT * FROM EMPLEADOS E, DEPARTAMENTOS D WHERE E.CODDEP = D.CODDEP;

## JOIN <a name="id2" />