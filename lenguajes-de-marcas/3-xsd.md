# XSD

1. [Elementos](#id1)
2. [Elementos simples](#id2)
3. [Elementos complejos](#id3)
4. [Atributos](#id4)
4. [Restricciones](#id5)

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

## Atributos <a name="id4">
Declarar un atributo:
~~~
<xs:attribute name="name_value" type="data_type" use="optional"/>
~~~

Estos son opcionales por defecto (*optional*) si queremos que sean obligatorios *use="required"*

## Restricciones <a name="id5">
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