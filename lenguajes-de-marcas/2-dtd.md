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