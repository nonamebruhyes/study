# SQL BASICO (Esto es una prueba)

1. [SELECT](#id1)
2. [WHERE](#id2)
3. [ORDER BY](#id3)
4. [Valor de variable abierto](#id4)
5. [Funciones](#id5)
6. [JOIN](#id6)

## SELECT campos FROM tabla; <a name="id1" />

    DISTINCT    ->      SELECT DISTINCT campo FROM tabla;   Saca los diferentes valores de un campo
    AS          ->      SELECT campo AS apodo FROM tabla;   Le pone un apodo a un campo

## SELECT campos FROM tabla WHERE condicion; <a name="id2" />

    >    mayor
    <    menor
    \>=   mayor igual
    <=   menor igual
    =    igual
    <>   diferente
    !=   diferente
    AND  operador y
    OR   operador or
    NOT  negacion

    BETWEEN(a, b)   ->      campo => a AND campo <= b
    IN(a, b, c)     ->      campo = a OR campo = b OR campo = c
    LIKE 'a'        ->      campo LIKE 'a'
        %           ->      para serie de caracteres cualquiera
        _           ->      para un caracter cualquiera
    IS NULL         ->      campo = NULL  
    IS NOT NULL     ->      campo <> NULL

## SELECT campo FROM tabla ORDER BY campo ASC|DESC; <a name="id3" />

Hace una ordenacion de la tabla segun el campo que le pongamos

    ASC             ->      ordenacion ascendente (por defecto)
    DESC            ->      ordenacion descendente
    NULLS FIRST     ->      muestra los que tienen el valor null al principio
    NULLS LAST      ->      muestro los que tienen el valor null al final

## &NOMBRE_VARIABLE <a name="id4" />

Dejamos abierto el valor, por ejemplo para una where y se pedira cuando
se ejecute la consulta.

    SELECT campo FROM tabla WHERE campo = &NOMBRE_VARIABLE;

## FUNCIONES <a name="id5" />
### Funciones numericas
    - ROUND(n, decimales)         ->      Redondea al numero mas proximo
    - TRUNC(n, decimales)         ->      Corta a partir de los decimales
    - MOD(n1, n2)                 ->      Devuelve el resto
    - POWER(valor, exponente)     ->      Eleva el valor al exponente
    - SIGN(n)                     ->      1 si positivo, 0 si negativo
    - SQRT()
    - ABS()
    - EXP()
    - LN()
    - LOG()
    - SIN()
    - COS()
    - TAN()
    - ACOS()
    - ASIN()
    - ATAN()
    - SINH()
    - COSH()
    - TANH()

### Funciones de caracteres

#### Conversion
    - LOWER()
    - UPPER()
    - INITCAP()

#### Transformacion
    - RTRIM()
    - LTRIM()
    - TRIM()
    - SUBSTR()
    - LENGTH()
    - REPLACE()
    - LPAD()
    - RPAD()
    - REVERSE()
    - INSTR()
    - TRANSLATE()

#### Altres
    - ASCII()
    - CHR()
    - SOUNDEX()
    
#### Funciones con nulos
    - NVL(valor, sustituto)                   ->      Si valor es null devuelve sustituto si no valor
    - NVL2(valor, sustituto1, sustituto2)     ->      Si valor es null devuelve sustituto1 si no sustituto2
    - NULLIF(valor1, valor2)                  ->      Si valor1 = valor2 devuelve null si no valor1
    - COALESCE(listaExpresiones)              ->      Devuelve la primera de las expresiones no nula

#### Funciones con fecha
    - ADD_MONTHS(fecha, n)
    - MONTHS_BETWEEN(fecha1, fecha2)
    - NEXT_DAY(fecha, dia)
    - LAST_DAY(fecha)
    - EXTRACT(valor FROM fecha)
    - GREATEST(fecha1, fecha2, ...)
    - LEAST(fech1, fecha2, ...)
    - ROUND(fecha [,'formato'])
    - TRUNC(fecha [,'formato'])

#### Funciones de conversion
    - TO_CHAR(expresion [,'formato'])
    - TO_NUMBER()
    - TO_DATE()