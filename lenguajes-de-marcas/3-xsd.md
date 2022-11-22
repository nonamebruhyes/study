# XSD

### Raiz XSD
    <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

### Inlcuir XSD en XML
    <root xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="root.xsd">

## XSD Elementos
Los ficheros XSD pueden estar formados por [elementos simples](#id2) o [elementos complejos]
    <xs:element name="xxx" type="data-type" />

### Tipos de datos simples predefinidos

#### Tipos cadena
- ***string***: una secuencia de longitud finita de caracteres.
- ***unayURI***: una uri estandar de Internet
- ***NOTATION***: declara enlaces a contenido externo no-XML
- ***Qname***: una cadena legal Qname (nombre con cualificador)

#### Tipos binario codificado
- ***boolean***: toma los valores true o false
- ***hexBinary***: dato binario codificado como una serie de pares de digitos hexadecimales
- ***base64binary***: datos binarios codificados en base 64

#### Tipos numericos
- ***decimal***: numero decimal de precision (digitos significativos) arbitraria*
- ***float***: numero de punto flotante de 32 bits de precision simple.
- ***double***: numero de punto flotante de 64 bits de doble precision

#### Tipos de fecha/hora
- ***duration***: duración de tiempo
- ***dateTime***: instante de tiempo específico, usando calendario gregoriano, en formato "YYYYMM-DDThh:mm:ss"
- ***date***: fecha específica del calendario gregoriano, en formato "YYYY-MM-DD” *
- ***time***: una instancia de tiempo que ocurre cada día, en formato "hh:mm:ss"
- ***gYearMonth***: un año y mes del calendario gregoriano
- ***gYear***: año del calendario gregoriano
- ***gMonthDay***: día y mes del calendario gregoriano
- ***gMonth***: un mes del calendario gregoriano
- ***gDay***: una fecha del calendario gregoriano (día)

## Elementos simples <a href="id2"/>
