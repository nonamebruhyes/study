# XSD

1. [Elementos](#id1)
2. [Elementos simples](#id2)
3. [Elementos complejos](#id3)
4. [Atributos](#id4)
4. [Valores fijos y por defecto](#id5)
4. [Restricciones](#id6)

### Raiz XSD
    <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

### Inlcuir XSD en XML
    <root xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="root.xsd">

## XSD Elementos <a name="id1"/>
Los ficheros XSD pueden estar formados por [elementos simples](#id2) o [elementos complejos](#id3)
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

## Elementos simples <a name="id2"/>
Son aquellos que solamente pueden contener un valor concreto (un texto, un numero) y nada mas.

    <xs:element name="Nombre" type="data_type">

## Elementos complejos <a name="id3">
Los elementos complejos son aquellos formados por otros elementos o atributos. Se distinguen cuatro tipos de elementos complejos
- Elementos vacios

~~~
<xs:element name="bola">
    <xs:complexType>
        <xs:attribute name="numero" type="numeroDeBola"/>
    </xs:complexType>
</xs:element>

<xs:simpleType name="numeroDeBola">
    <xs:restriction base="xs:positiveInteger">
        <xs:minInclusive value="1"/>
        <xs:maxExclusive value="90"/>
    </xs:restriction>
</xs:simpleType>
~~~
- Elementos que contienen otros elementos
~~~
<xs:element name="Persona">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="Nombre" type="xs:string"/>
            <xs:element name="Apellido" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>
...
<Persona>
    <Nombre>Juan</Nombre>
    <Apellido>Forner</Apellido>
</Persona>
~~~
- Elementos que contienen otros elementos y texto
~~~
<xs:element name="persona">
  <xs:complexType mixed="true">
    <xs:sequence>
      <xs:element name="nombre" type="xs:string"/>
      <xs:element name="ciudad" type="xs:string"/>
      <xs:element name="edad" type="xs:positiveInteger"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>
...
<persona>
    Aqui contiene texto
    <nombre>Juan Daniel Forner</nombre>
    <ciudad>Valencia</ciudad>
    <edad>23</edad>
</persona>
~~~

### Contenido de los elementos complejos
Los elementos complejos pueden contener:

- ***\<xs:sequence /\>***: contiene una secuencia de elementos.
- ***\<xs:choice /\>***: eleccion de elementos.

## Atributos <a name="id4">
Declarar un atributo:
~~~
<xs:attribute name="name_value" type="data_type" use="optional"/>
~~~

Estos son opcionales por defecto (*optional*) si queremos que sean obligatorios *use="required"*

## Valores fijos y por defecto <a name="id5">
Es posible definir ciertos valores por defecto o fijos para los elementos XSD, utilizando los atributos default y fixed

~~~
<xs:element name="Color" type="xs:string" default="red">
<xs:element name="Color" type="xs:string" fixed="red">
~~~

Un elemento con valor por defecto asignara dicho valor si no se especifica en el XML. Un valor fijo tendra siempre el valor definido en el XSD y si se le asigna otro valor dara error en la validacion

## Restricciones <a name="id6">
Las restricciones sirven para definir que datos aceptamos como valor para nuestros elementos y atributos. Estas no se limitan al tipo de datos, sino que podemos especificar ciertas restricciones en los valores:

- Valores maximos y minimos
- Lista de valores
- Serie (o patron) de los valores
- Longitud del valor
- Manejo del espacio en blanco

Asi se declara una restriccion:
~~~
<xs:element/attribute name="nombre">
    <xs:simpleType>
        <xs:restriction base="data_type">
            <!-- Restricciones -->
        </xs:restriction>
    </xs:simpleType>
</xs:element/attribute>
~~~

### Valores maximos y minimos
~~~
<xs:maxExclusive value="" />
<xs:maxInclusive value="" />
<xs:minExclusive value="" />
<xs:minInclusive value="" />
<xs:totalDigits value="" />
<xs:fractionDigits value="" />
~~~

### Lista de valores
~~~
<xs:enumeration value="1" />
<xs:enumeration value="2" />
<xs:enumeration value="3" />
~~~

### Patrones
~~~
<xs:pattern value="patron" />
~~~
|Patron|Significado|Ejemplo
|--|--|--
|.|Cualquier caracter|;
|\w|Cualquier letra|M
|\d|Un digito|1
|\D|Cualquier caracter que no sea un digito| a
|\s|Espacio (tabulador, espacio ...) cualquier caracter| 
|\S|Cualquier caracter que no sea un espacio en blanco|C
|\d{n}|n digitos exactos|
|\d{n,}|n o mas digitos|
|\d{n, m}|digitos n o m|
|[xyz]|eleccion x, y o z|
|[A-Z]|uno de los caracteres de A a Z|
|[^abc]|Revocacion de un conjunto de caracteresa|
|[A-Z-[H]]|Eliminacion de una caracter de un tramo|
|(a\|b)|Eleccion entre dos expresiones|
|b?|La secuencia de una cadena 0 o un episodio de una cadena|
|1*|Sucesion de una secuencia o mas apariciones|
|(cd)+|Una secuencia de una o mas apariciones de una cadena|

### Longitud del valor
~~~
<xs:minLength value="" />
<xs:maxLength value="" />
~~~

### Manejo del espacio
~~~
<xs:whiteSpace value=("preserve" | "replace" | "collapse")>
~~~