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
