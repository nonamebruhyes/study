# SQL ACTUALIZACIONES



## Estado de los datos durante la transaccion

El manejo de las transacciones es una de las cuestiones mas complejas para un *SGBD*. Los mas poderosos son capaces de gestionar las transacciones en cumplimiento de la norma que asegura estos cuatro aspectos (*ACID*):
1. **Atomicidad**: que ninguna instruccion se quede a medio hacer
2. **Consistencia**: asegura que una transaccion simepre mantenga la integridad de los datos, se anule o se haga finalmente la transaccion. Hasta en cualquier momento intermedio de la transaccion.
3. **Aislamiento**: asegura que las transacciones simultanias no afecten entre si. Es decir que una transaccion sea independiente a la otra.
4. **Durabilidad**: asegura que cuando se confirme la transaccion, los efectos de sus instrucciones sean definitivos, independientemente de que el sistema se apague o se cierre por un error grave.