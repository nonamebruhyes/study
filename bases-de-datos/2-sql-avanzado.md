# SQL AVANZADO

1. [Relaciones entre tablas](#id1)
2. [JOIN](#id2)
3. [Funciones de calculo con grupos](#id3)
4. [GROUP BY / HAVING (Agrupaciones)](#id4)
5. [Subconsulta](#id5)
6. [Operadores de conjunto](#id6)
7. [Consultas avanzadas](#id7)

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

Con la sentencia anterior la tabla resultante nos quedaria de la siguiente manera:

| NEMP | NOM | CODDEP | CODDEP | DESCRIPCIO |
| -- | -- | -- | -- | -- |
| 1001 | Juan | 10 | 10 | Compres |
| 1002 | Pedro | 20 | 20 | Vendes |
| 1003 | Mitja | 20 | 20 | Vendes |

## JOIN <a name="id2" />
Siguiendo con el ejemplo anterior, la sintaxis para diferenciar de WHERE las condiciones de seleccion de registros es usando la clausula JOIN. En el caso de que el campo que las relaciona se llame igual:

    ...FROM EMPLEADOS E JOIN DEPARTMENTS D USING(DEPARTMENT_ID)...;

En el caso contrario:

    ... FROM EMPLEADOS E JOIN DEPARTMENTS D ON(E.CODDEP=D.CD)...;

### Modificaciones de JOIN
Hay veces en la que una de las tablas puede tener el campo que las relaciona con valor nul o incluso que no coincida ninguno de la otra tabla con ese campo. Para eso tenemos las sentencias: LEFT JOIN, RIGHT JOIN, OUTER JOIN. 

1. ***LEFT JOIN***: esta sentencia saca los registros con valores null de la tabla de la izquierda.
2. ***RIGHT JOIN***: esta sentencia saca los registros de la tabla de la derecha aunque no tengan ninguna relacion con la tabla de la izquierda.
3. ***OUTER JOIN***: esta sentencia junta las dos anteriores
4. ***INNER JOIN***: por defecto

<image src="https://ingdesoftware.wpenginepowered.com/wp-content/uploads/2018/07/sqljoin.jpeg" alt="Descripción de la imagen" height="450">

## Funciones de calculos con grupos <a name="id3" />
Estas funciones lo que hacen son calculos en vertical en la tabla, es decir, de los valores correspondientes a una columna:

    - COUNT(expresion)         ->      Cuenta, ignora nulos
    - SUM(expresion)           ->      Suma los valores de la expresion
    - AVG(expresion)           ->      Media aritmetica
    - MIN(expresion)           ->      Minimo valor
    - MAX(expresion)           ->      Maximo valor
    - STDDEV(expresion)        ->      Desviacion estandard
    - VARIANCE(expresion)      ->      Varianza

## GROUP BY / HAVING (Agrupaciones) <a name="id4" />
Las expresiones anteriores es normal utilizarlas con grupos de filas en base a un criterio. Esta tecnica se conoce como agrupacion de filas i provoca que se muestre una sola fila de cada grupo.

La sintaxis completa de una sentencia SELECT quedaria:

    SELECT listaExpresiones
    FROM listaTablas
    [JOIN tablasRelacionadasMasCondicionesDeRelacion]
    [WHERE condiciones]
    [GROUP BY grupos]
    [HAVING condicionesDeGrupos]
    [ORDER BY listaExpresiones]

En el apartado ***GROUP BY*** se indica el nombre de las columnas por las cuales se agrupa. La funcion de este apartado es crear una unica fila para cada valor diferente en las columnas de grupo. Hay que tener en cuenta que si agrupamos ya no podemos sacar datos individuales.

La clausula ***HAVING*** es como otra clausula WHERE pero que se aplica a los grupos, para sacarlos o no.

Ejemplo:

    SELECT
        DEPARTMENT_ID,
        SUM(SALARY)
    FROM
        EMPLOYEES
    WHERE
        HIRE_DATE < TO_DATE('01/01/2005', 'dd/mm/yyyy')
    GROUP BY
        DEPARTMENT_ID
    HAVING
        SUM(SALARY) > 20000
    ORDER BY
        1;

## Subconsultas <a name="id5" />
El uso de subconsultas es una tecnica que permita utilizar el resultado de una SELECT en otra SELECT. Permite solucionar consulta complejas mediante el uso de resultados previos a otra consulta.

El SELECT que se coloca en el interior de otra SELECT se conoce con el termino de SUBSELECT y este se puede colocar dentro de las clausulas WHERE, HAVING, FROM, JOIN

Por ejemplo, si queremos sacar el nombre de los empleados que cobran mas que el salario medio total de la empresa:

    SELECT
        FIRST_NAME,
        LAST_NAME
    FROM
        EMPLOYEES
    WHERE
        SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES);

Evidentemente la SUBSELECT anterior solo devuelve un resultado pero si devolviera varios nos daria un error. No podriamos compararla directamente, tenemos que añadir estos operadores:

1. ***ANY*** o ***SOME***: compara con cualquier registro de la subconsulta. La instruccion es valida si hay un registro de la subconsulta que permite que la comparacion sea correcta.
2. ***ALL***: compara con todos los registros de la subconsulta. La instruccion es cierta si es cierta toda comparacion
3. ***IN***: no usa comparador, ya que sirve para comprobar si un valor se encuentra en el resultado de la subconsulta
4. ***NOT IN***: Comprueba si un valor no se encuentra en la subconsulta

Existe otro operador llamado ***EXIST*** que devuelve verdadero si la consulta que le sigue devuelve algun valor. Se utiliza normalmente utilizando consultas correlacionadas.

Por ejemplo, quiero saber los lugares de trabajo en los cuales algun trabajador esta cobrando el salario minimo:

    SELECT
        JOB_TITLE
    FROM
        JOBS J
    WHERE
        EXIST (
            SELECT
                *
            FROM
                EMPLOYEES E
            WHERE
                E.SALARY=J.MIN_SALARY
        );

La SELECT principal va leyendo fila a fila y para cada una de ellas busca en la tabla de empleados si existe alguno, el salario del qual coincida con el salario minimo que he leido en la consulta principal.

## Operadores de conjunto <a name="id6" />
Estas consultas utilizan al menos dos SELECT resultados de los cuales se pueden combinar para formar una unica consulta.

    SELECT campos FROM tabla UNION SELECT campos FROM tabla;

1. ***UNION***: une completamente ambas consultas
2. ***INTERSECT***: une unicamente lo que coincide en ambas consultas
3. ***MINUS***: muestra lo de la consulta de la izquierda menos lo que coincida con la consulta de la derecha

## Consultas avanzadas <a name="id7" />

### ROWNUM
Todas las tablas tienen unas columnas virtuales de uso interno de Oracle que normalmente no vemos, son ***ROWID*** y ***ROWNUM***. *ROWID* es un identificador interno unico para cada registro y *ROWNUM* es el numero de orden de cada fila dentro de la tabla. Normalmente el orden en el que se introdujeron.

Cuando se realiza una subconsulta se crea una **tabla temporal** con el resultado de la SELECT por lo que se vuelve a recalcular el *ROWNUM*. Eso nos permite hacer consultas tipo: *"dime los 10 mejores..."*.

Por ejemplo, quiero saber los 10 empleados que mas cobran:

    SELECT
        ROWNUM,
        FIRST_NAME
    FROM
        (
            SELECT
                FIRST_NAME
            FROM
                EMPLOYEES
            ORDER BY
                SALARY DESC
        )
    WHERE
        ROWNUM <= 10;

### Consultas jerarquicas
Una tabla puede estar relacionada con si misma como se ve en el dibujo siguiente:

<image src="https://raw.githubusercontent.com/juvndvv/study/main/bases-de-datos/0-hr-relaciones.jpg" alt="Descripción de la imagen" height="250">