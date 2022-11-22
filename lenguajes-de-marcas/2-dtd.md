# DTD
El DTD define la estructura, elementos y atributos validos en un documento XML. Cuando un documento XML cumple con un DTD se dice que es valido.

Un DTD se define:
~~~
<!DOCTYPE root
[
    <!ELEMENT root (child1 ,child2, ...)>
    <!ELEMENT child1 (#PCDATA)>
    <!ELEMENT child2 (#PCDATA)>
    ...
]
~~~

En el ejemplo anterior el DTD se interpreta como:

- ***!DOCTYPE root***: define *root* como el elemento raiz del documento
- ***!ELEMENT root***: define que el elemento *root* debe contener los elementos: *child1*, *child2*,...
- ***!ELEMENT child1, child2, ...***: definen que dichos elementos contienen datos tipo PCDATA

Un DTD se puede definir dentro de un documento XML (en su prologo en la etiqueta \<!DOCTYPE\>) o en un documento externo (.dtd).

Si definimos un DTD en un documento externo, debemos referenciarlo:
~~~
<!DOCTYPE root SYSTEM "root.dtd">
~~~

## Elementos
Los elementos de un DTD se definen mediante ***\<!ELEMENT ...\>***:
~~~
<!ELEMENT element-name category>
o
<!ELEMENT element-name (element-content)>
~~~

*category*:
- ***EMPTY***: define un elemento vacio
- ***ANY***: define un elemento que puede tener cualquier contenido

*element-content*:
- ***#PCDATA***: texto que puede ser procesado
- ***childs***: indica el nombre de los hijos del elemento

### Patrones de element-content
~~~
<!ELEMENT element-name (child-name+)>
<!ELEMENT element-name (child-name*)>
<!ELEMENT element-name (child-name?)>
~~~

- ***+***: indica que el elemento puede aparecer una o mas veces
- ***\****: indica que el elemento puede aparecer cero o mas veces
- ***+***: indica que el elemento puede aparecer 0 o una vez

## Atributos
Para declarar atributos en un DTD utilizamos la etiqueta ***\<!ATTLIST\>***
~~~
<!ATTLIST element-name attribute-name attribute-type attribute-value>
~~~

***attribute-type***:
|Tipo|Descripcion
|--|--
|CDATA|datos de caracteres
|(en1\|en2\|...)|debe ser uno de la lista
|ID|identificador unico
|IDREF|identificador de otro elemento
|IDREFS|lista de otros identificadores
NMTOKEN|nombre XML valido
NMTOKENS|lista de nombres XML validos
ENTITY|una entidad
ENTITIES|lista de entidades
NOTATION|el nombre de una notacion
xml:|valor predefinido xml
